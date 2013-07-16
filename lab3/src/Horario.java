
public class Horario {

	private int hora;
	private int minuto;
	
	public Horario(){
		
	}
	 public Horario(int hora, int minuto) throws MinuitoException, HoraException {
		verificaHora(hora);
		verificaMinuto(minuto);
		this.hora=hora;
		this.minuto=minuto;
	}
	private void verificaHora(int hora) throws HoraException{
		if(hora<0 || hora >23){
			throw new HoraException("Hora Invalida");
		}
	}
	private void verificaMinuto(int minuto) throws MinuitoException{
		if(minuto<0 || minuto>59){
			throw new MinuitoException("Minuto Invalido");
		}
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) throws HoraException {
		verificaHora(hora);
		this.hora = hora;
	}
	public int getMinuto() {
		return minuto;
	}
	public void setMinuto(int minuto) throws MinuitoException {
		verificaMinuto(minuto);
		this.minuto = minuto;
	}
	public String toString(){
		if(hora<10 && minuto<10){
			return "0"+String.valueOf(hora)+":"+"0"+String.valueOf(minuto);
		}
		else if(hora>=10 && minuto<10){
			return String.valueOf(hora)+":"+"0"+String.valueOf(minuto);
		}
		else if(hora<10 && minuto>=10){
			return "0"+String.valueOf(hora)+":"+String.valueOf(minuto);
		}
		return String.valueOf(hora)+":"+String.valueOf(minuto);
	}
	}

