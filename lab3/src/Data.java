import java.util.*;

public class Data implements Comparable<Data> {
	private int ano;
	private int mes;
	private int dia;
	private int[] mesDe30 = { 4, 6, 9, 11 };
	private final int anoGeral = 1900;

	public Data(int dia, int mes, int ano) throws AnoInvalidoException,
			MesInvalidoException, DiaInvalidoException {
		verificaAno(ano);
		verificaMes(mes);
		verificaDia(dia, mes, ano);
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public Data() {

	}

	private void verificaAno(int ano) throws AnoInvalidoException {
		if (ano < 0) {
			throw new AnoInvalidoException("Ano Invalido");
		}
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) throws AnoInvalidoException {
		verificaAno(ano);
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) throws MesInvalidoException {
		verificaMes(mes);
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) throws DiaInvalidoException {
		verificaDia(dia, mes, ano);
		this.dia = dia;
	}

	public boolean anoBissexto(int ano) {
		if (ano % 400 == 0 || ano % 4 == 0) {
			return true;
		}
		return false;
	}

	private void verificaMes(int mes) throws MesInvalidoException {
		if (mes < 0 || mes > 12) {
			throw new MesInvalidoException("Mes Invalido");
		}
	}

	private boolean verificaDiaMes(int mes, int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == mes) {
				return true;
			}
		}
		return false;

	}

	private void verificaDia(int dia, int mes, int ano)
			throws DiaInvalidoException {
		if (dia <= 0 || dia > 31) {
			throw new DiaInvalidoException("Dia Invalido");
		}
		if (verificaDiaMes(mes, mesDe30) && dia > 30) {
			throw new DiaInvalidoException("Mes com no maximo 30 dias");
		}

		if (mes == 2 && dia > 28 && anoBissexto(ano) == false) {
			throw new DiaInvalidoException("Mes com no maximo 28 dias");
		}
		if (mes == 2 && dia > 29 && anoBissexto(ano) == true) {
			throw new DiaInvalidoException("Mes com no maximo 29 dias");
		}
	}

	public Data dataAtual() 
 {
		Date atual = new Date();
		Data nova = null;
		try {
			nova = new Data(atual.getDate(), (atual.getMonth()+1), atual.getYear()
					+ anoGeral);
		} catch (Exception e) {

		}
		return nova;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + dia;
		result = prime * result + mes;
		return result;
	}

	@Override
	public int compareTo(Data data) {
		if (this.getDia() == 0 && this.getMes() == 0 && this.getAno() == 0) {
			return 2;
		}
		if (data.getAno() > this.getAno()) {
			return -1;
		} else if (data.getAno() < this.getAno()) {
			return 1;
		} else {
			if (data.getMes() > this.getMes()) {
				return -1;
			} else if (data.getMes() < this.getMes()) {
				return 1;
			} else {
				if (data.getDia() > this.getDia()) {
					return -1;
				} else if (data.getDia() < this.getDia()) {
					return 1;
				}
			}
		}
		return 0;
	}

	public String toString() {
		if(dia<10 && mes>=10){
			return "0"+String.valueOf(dia) + "/" + String.valueOf(mes) + "/"
					+ String.valueOf(ano);
			
		}
		else if(mes<10 && dia>=10 ){
			return String.valueOf(dia) + "/"+"0"+ String.valueOf(mes) + "/"
					+ String.valueOf(ano);
		}
		else if(mes<10 && dia <10){
			return "0"+String.valueOf(dia) + "/"+"0"+ String.valueOf(mes) + "/"
					+ String.valueOf(ano);
		}
		return String.valueOf(dia) + "/" + String.valueOf(mes) + "/"
				+ String.valueOf(ano);
	}

}