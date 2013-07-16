import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static AgendaDeTarefas agenda = new AgendaDeTarefas();
	private static Scanner sc = new Scanner(System.in);
public static void main(String[] args) throws AnoInvalidoException, MesInvalidoException, DiaInvalidoException, MinuitoException, HoraException {

	while(true){
		System.out.println("O que deseja ? "+"\n"+"1- Para Cadastra Tarefa"+"\n"+"2- Para Ver Tarefas Incompletas"+"\n"+
	"3- Para as Tarefas Completa"+"\n"+"4- Para Concluir Tarefa"+"\n"+"5- Remove Tarefa"+"\n"+"6- Editar uma Tarefa"
				+"\n"+"7- Para Sair");
		int escolha = sc.nextInt();
		switch (escolha) {
		case 1:
			cadastra();
			break;
		case 2:
			listaTarefaIncompletas();
			break;
		case 3:
			listaTarefaCompletas();
			break;
		case 4:
			concluirTarefa();
			break;
		case 5:
			removeTarefa();
			break;
		case 6:
			Editar();
			break;
		case 7:
			System.exit(0);
		}
	}
	
}


private static void cadastra() throws AnoInvalidoException, MesInvalidoException, DiaInvalidoException, MinuitoException, HoraException{
	System.out.println("Digite o Nome: ");
	String nome = sc.next();
	System.out.println("Digite a Descricao");
	String descricao = sc.next();
	System.out.println("Digite a Dia: ");
	int dia= sc.nextInt();
	System.out.println("Digite o Mes: ");
	int mes= sc.nextInt();
	System.out.println("Digite o ano: ");
	int ano= sc.nextInt();
	System.out.println("Dgite o Hora: ");
	int hora = sc.nextInt();
	System.out.println("Digite o Minuto: ");
	int minuto= sc.nextInt();
	System.out.println("Confirma os dados? (s/n)");
	if(sc.next().equals("s")){
		agenda.addTarefa(nome, descricao, new Data(dia, mes, ano).toString(), new Horario(hora, minuto).toString());
		System.out.println("Cadatro Relizado"+ "\n");
	}
}

private static void listaTarefaIncompletas(){
	System.out
		.println("Listar ordernado por: \n 1-Data Duracao da tarefa \n 2- Data de criacao");
	String escolha = sc.next();
	if (escolha.equals("1")) {
		agenda.organizaDataLimiteTarefaIncompleta();
	}
	if (escolha.equals("2")) {
		agenda.organizaDataCriacaoTarefaIncompleta();
	}
	for (Tarefa tarefa : agenda.getListaIncompleta()) {
		System.out.println(tarefa.toString());
	}
}
private static void listaTarefaCompletas(){
	System.out
		.println("Listar ordernado  por: \n 1-Data Duracao da tarefa \n 2- Data de criacao");
	String escolha = sc.next();
	if (escolha.equals("1")) {
		agenda.organizaDataLimiteTarefaCompleta();
	}
	if (escolha.equals("2")) {
		agenda.organizaDataCriacaoTarefaCompleta();
	}
	for (Tarefa tarefa : agenda.getListacompleta()) {
		System.out.println(tarefa.toString());
	}
}
private static  void concluirTarefa(){
	agenda.mudaStatus(busca());
	System.out.println("Tarefa Concluida" + "\n");
}

private static void removeTarefa(){
	Tarefa tarefa= busca(); 
	agenda.removeTarecompleta(tarefa);
	agenda.removeTarecompleta(tarefa);
	System.out.println("Tarefa Removida"+ "\n");
}
private static void Editar() throws AnoInvalidoException, MesInvalidoException, DiaInvalidoException, MinuitoException, HoraException{
	Tarefa tarefa= busca();
	System.out.println("Nome da tarefa :"+tarefa.getNome());
	System.out.println("Digite o novo Nome: ");
	String nome = sc.next();
	System.out.println("Descricao da Trefa: " +tarefa.getDescricao());
	System.out.println("Digite a Nova Descricao");
	String descricao = sc.next();
	System.out.println("Data da Tarefa: "+ tarefa.getDuracao().toString());
	System.out.println("Digite a Novo Dia: ");
	int dia= sc.nextInt();
	System.out.println("Digite o Novo Mes: ");
	int mes= sc.nextInt();
	System.out.println("Digite o Novo ano: ");
	int ano= sc.nextInt();
	System.out.println("Hora da Tarefa: "+ tarefa.getHora().toString());
	System.out.println("Dgite o Nova Hora: ");
	int hora = sc.nextInt();
	System.out.println("Digite o Novo Minuto: ");
	int minuto= sc.nextInt();
	System.out.println("Confirma os dados? (s/n)");
	if(sc.next().equals("s")){
		agenda.addTarefa(nome, descricao, new Data(dia, mes, ano).toString(), new Horario(hora, minuto).toString());
		agenda.removeTarecompleta(tarefa);
		agenda.removeTarecompleta(tarefa);
		System.out.println("Tarefa Editada"+ "\n");
	}
}

private static Tarefa busca() {
	System.out.println("Digite o nome da tarefa: \n");
	String nome = sc.next();
	List<Tarefa> todasTarefa = new ArrayList<Tarefa>();
	todasTarefa.addAll(agenda.getListaIncompleta());
	todasTarefa.addAll(agenda.getListacompleta());
	for (Tarefa tarefa : todasTarefa) {
		if (tarefa.getNome().contains(nome)) {
			System.out
					.println("Essa tarefa que  deseja remover/alterar/concluir ? (s/n) \n"
							+ tarefa.toString());
			if (sc.next().equals("s")) {
				return tarefa;
			}
		}
	}
	System.out.println("Tarefa nao encontrada");
	return null;
}
}
