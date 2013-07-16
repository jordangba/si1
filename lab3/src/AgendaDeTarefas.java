
import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class AgendaDeTarefas {

	private List<Tarefa> listaTarefa;
	private List<Tarefa> listacompleta;
	
	public AgendaDeTarefas(){
		listaTarefa= new ArrayList<Tarefa>();
		listacompleta= new ArrayList<Tarefa>();
		iniciaTarefa();
	}
	public void addTarefa(String nome, String descricao, String dataLimite, String horas) {
		if(nome.isEmpty() || nome==null || nome.equals("")){
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Nome requerido",
					"O campo nome é obrigatório"));

		}
		try{
			 Tarefa tarefa = new Tarefa(nome);

		if(!(dataLimite.isEmpty())){
		try {
			Data dataDuracao= new Data(Integer.parseInt( dataLimite.substring(0, 2)),
					Integer.parseInt(dataLimite.substring(3, 5)),
					Integer.parseInt(dataLimite.substring(6, 10)));
			 tarefa.setDuracao(dataDuracao);
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(e.getMessage()));
		}

		}
		 tarefa.setDescricao(descricao);
		if(!(horas.isEmpty())){
		try {
			Horario hora = new Horario(Integer.parseInt(horas.substring(0, 2)), Integer.parseInt(horas.substring(3, 5)));
			 tarefa.setHora(hora);
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(e.getMessage()));
		}

		}
		Data data= new Data();
		try {
			 tarefa.setDataCriacao(data.dataAtual());

		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(e.getMessage()));
		}


			listaTarefa.add( tarefa);

		}catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(e.getMessage()));
		}

	 }
	public List<Tarefa> getListaIncompleta() {
		return listaTarefa;
	}
	public List<Tarefa> getListacompleta() {
		return listacompleta;
	}
	public void mudaStatus(Tarefa tarefaSelect) {
		if(listaTarefa.size()>0 && tarefaSelect!=null){
		tarefaSelect.mudaStatus();
		listaTarefa.remove(tarefaSelect);
		listacompleta.add(tarefaSelect);	
		}
	}
	public void organizaDataLimiteTarefaIncompleta(){
		Collections.sort(listaTarefa);
	}
	public void organizaDataLimiteTarefaCompleta(){
		Collections.sort(listacompleta);
	}
	public void organizaDataCriacaoTarefaCompleta(){
		Collections.sort(listacompleta, Tarefa.TarefaComparator);
	}
	public void organizaDataCriacaoTarefaIncompleta(){
		Collections.sort(listaTarefa, Tarefa.TarefaComparator);
	}
	
	public void removeTareIncompleta(Tarefa tarefa){
		if(listaTarefa.size()>0){
			listaTarefa.remove(tarefa);
		}
	}
	public void removeTarecompleta(Tarefa tarefa){
		if(listacompleta.size()>0){
			listacompleta.remove(tarefa);
		}
	}
	private void iniciaTarefa(){
		try {
		addTarefa("Fazer Projeto", "trabalhoso", new Data(12,7,2013).toString(),new Horario(8,00).toString());
		addTarefa("Fazer Projeto Fisica", "preguica", new Data(14,7,2013).toString(),new Horario(8,00).toString());
		addTarefa("RPG", "diversao", new Data(22,07,2013).toString(),new Horario(9,00).toString());
		addTarefa("Provas", "estudo", new Data(12,8,2013).toString(),new Horario(10,00).toString());
		addTarefa("Dormir", "descanco", new Data(13,7,2013).toString(),new Horario(23,00).toString());
		} catch (Exception e) {

		}
	}
	 
}

