import static org.junit.Assert.*;

import org.junit.Test;


public class HorarioTest {

	@Test
	public void ConstrutorHora() {
		try{
			Horario h= new Horario(-1, 2);
			fail("Erro em hora");
		}catch(Exception e){
			assertEquals("Hora Invalida", e.getMessage());
		}
		try{
			Horario h= new Horario(24, 2);
			fail("Erro em Minuto");
		}catch(Exception e){
			assertEquals("Hora Invalida", e.getMessage());
		}
	}
	@Test
	public void ConstrutorMinuto() {
		try{
			Horario h= new Horario(1, -1);
			fail("Erro em Minuto");
		}catch(Exception e){
			assertEquals("Minuto Invalido", e.getMessage());
		}
		try{
			Horario h= new Horario(23, 67);
			fail("Erro em Minuto");
		}catch(Exception e){
			assertEquals("Minuto Invalido", e.getMessage());
		}
		try {
			Horario h = new Horario(1, 0);
		} catch (Exception e) {
			fail("Erro em Minuto");
		}
	}

}
