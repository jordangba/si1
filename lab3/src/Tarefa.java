import java.util.Comparator;


public class Tarefa implements Comparable<Tarefa>{

	private Data dataCriacao;
	private Data duracao;
	private String nome;
	private String descricao;
	private Horario hora;
	private String status="Incompleta";


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStatus() {
		this.status = "Completa";
	}

	public Tarefa(String nome, String descricao, Data limite, Horario hora){
		this.nome=nome;
		this.descricao= descricao;
		this.duracao=limite;
		this.hora=hora;
		this.dataCriacao= new Data();
		dataCriacao=dataCriacao.dataAtual();
	}
	public Tarefa(String nome) throws NomeInvalidoException{
		verificaNome(nome);
		this.nome= nome;
		this.duracao= new Data();
		this.descricao="";
		this.hora= new Horario();
		this.dataCriacao= new Data();
		dataCriacao=dataCriacao.dataAtual();
		
	}
	public Tarefa() {
		// TODO Auto-generated constructor stub
	}

	public void verificaDataCriacao() throws AnoInvalidoException, MesInvalidoException, DiaInvalidoException, DataInvalidaException{
		Data a = new Data();
		a= a.dataAtual();
		if(a.compareTo(dataCriacao)==-1){
			throw new DataInvalidaException("Data de Criacao Invalida");
		}
	}
	public Horario getHora() {
		return hora;
	}
	public void setHora(Horario hora) {
		this.hora = hora;
	}
	
	public void mudaStatus(){
		this.status="Completa";
	}
	private void verificaNome(String nome) throws NomeInvalidoException{
		if(nome==null || nome.equals("")){
			throw new NomeInvalidoException("Nome Invalido");		}
	}

	public String iStatus() {
		return status;
	}

	public Data getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Data dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Data getDuracao() {
		return duracao;
	}

	public void setDuracao(Data duracao) {
		this.duracao = duracao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean Equals(Object obj){
		if(!(obj instanceof Tarefa)){
			return false;
		}
		return getNome().equals( ((Tarefa) obj).getNome());
	}


	public String toString(){
		return "Nome: "+nome+"\n"+ "Descricao: "+descricao+"\n" + 
	"Data Criacao:" + dataCriacao.toString()+"\n"+ "Data Limite: "+ duracao.toString()+"\n"+
				"Hora: " +hora.toString()+"\n"+" Status:"+status+"\n";
	}

	@Override
	public int compareTo(Tarefa o) {
		if(this.getDuracao().compareTo(o.getDuracao())==0){
			return this.getNome().compareTo(o.getNome());
		}
		return this.getDuracao().compareTo(o.getDuracao());
	}
	public static Comparator<Tarefa> TarefaComparator = new Comparator<Tarefa>() {

		public int compare(Tarefa tarefa1, Tarefa tarefa) {


			if (tarefa1.getDataCriacao().compareTo(tarefa.dataCriacao)==0) {
				return tarefa1.getNome().compareTo(tarefa.getNome());
			}

			return tarefa1.getDataCriacao().compareTo(tarefa.getDataCriacao());
		}
	};
}
