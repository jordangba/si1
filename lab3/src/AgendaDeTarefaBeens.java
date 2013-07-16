

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sun.faces.util.CollectionsUtils;
import java.util.*;
@ManagedBean
@SessionScoped
public class AgendaDeTarefaBeens implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dataLimite;
	private String nome;
	private String horas;
	private String descricao;
	private AgendaDeTarefas agenda;
	private List<Tarefa> listaTarefa;
	private List<Tarefa> listaTarefaCompleta;
	private Tarefa tarefaSelect;
	private Tarefa selecTarefaConcluida;
	private Tarefa selectVisualizar;

	public Tarefa getSelecTarefaConcluida() {
		return selecTarefaConcluida;
	}
	
	public String visualizar(Tarefa tarefa){
		if(tarefa!=null){
			System.out.println(tarefa.toString());
		selectVisualizar= tarefa;
		this.nome= selectVisualizar.getNome();
		this.horas= selectVisualizar.getHora().toString();
		System.out.println(horas);
		this.dataLimite= selectVisualizar.getDuracao().toString();
		System.out.println(dataLimite);
		this.descricao= selectVisualizar.getDescricao();
		return "Editar.xhtml";
		}
		return "index.xhtml";
	}
	public String salva(){
		try {
			selectVisualizar.setNome(nome);
			selectVisualizar.setDescricao(descricao);
			selectVisualizar.setDuracao(new Data(Integer.parseInt( this.dataLimite.substring(0, 2)),
					Integer.parseInt(this.dataLimite.substring(3, 5)),
					Integer.parseInt(this.dataLimite.substring(6, 10))));
			selectVisualizar.setHora(new Horario(Integer.parseInt(this.horas.substring(0, 2)), Integer.parseInt(this.horas.substring(3, 5))));
			
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(e.getMessage()));
		}
		return "index.xhtml";
		
	}
	public void setSelecTarefaConcluida(Tarefa selecTarefaConcluida) {
		this.selecTarefaConcluida = selecTarefaConcluida;
	}

	public AgendaDeTarefaBeens(){
		 this.agenda = new AgendaDeTarefas();
		 this.listaTarefa =  agenda.getListaIncompleta();
		 this.listaTarefaCompleta = agenda.getListacompleta();
		limpar();
	}
	
	public List<Tarefa> getListaTarefaCompleta() {
		return listaTarefaCompleta;
	}

	public void setListaTarefaCompleta(List<Tarefa> listaTarefaCompleta) {
		this.listaTarefaCompleta = listaTarefaCompleta;
	}

	public List<Tarefa> getListaTarefa() {
		return listaTarefa;
	}

	public String getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(String dataLimite) {
		this.dataLimite = dataLimite;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String hora) {
		this.horas = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String volta(){
		limpar();
		return "index.xhtml";
	}

	private void limpar() {
		this.nome = "";
		this.dataLimite = "";
		this.descricao="";
		this.horas = "";
	}
	
	public String criar() {
		agenda.addTarefa(nome, descricao, dataLimite, horas);
		limpar();
		return "cadastra.xhtml";
	}

	public Tarefa getTarefaSelect() {
		return tarefaSelect;
	}

	public void setTarefaSelect(Tarefa tarefaSelect) {
		this.tarefaSelect = tarefaSelect;
	}
	
	public void ordenarporDataLimite(){
		Collections.sort(listaTarefa);
	}
	
	public String mudaStatus(){
		agenda.mudaStatus(tarefaSelect);
		return "index.xhtml";

	}

	public AgendaDeTarefas getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaDeTarefas agenda) {
		this.agenda = agenda;
	}

	public void setListaTarefa(List<Tarefa> listaTarefa) {
		this.listaTarefa = listaTarefa;
	}
	 public void ListaPorDataCriacaoIncompleta(){
		 agenda.organizaDataCriacaoTarefaIncompleta();
	 }
	 public void ListaPorDataCriacaoCompleta(){
		 agenda.organizaDataCriacaoTarefaCompleta();
	 }
	 public void ListaPorDataLimiteIncompleta(){
		 agenda.organizaDataLimiteTarefaIncompleta();
	 }
	 public void ListaPorDataLimiteCompleta(){
		 agenda.organizaDataLimiteTarefaCompleta();
	 }
	 
	 public void removeTarefaIncompleta(){
		 agenda.removeTareIncompleta(tarefaSelect);
	 }
	 
	 public void removeTarefaConcluida(){
		 agenda.removeTarecompleta(selecTarefaConcluida);
	 }
}
