import static org.junit.Assert.*;

import org.junit.Test;


public class TarefaTest {

	@Test
	public void Construtor() {
		try {
			Tarefa a= new Tarefa("");
			fail("erro Nome");
		} catch (Exception e) {
			assertEquals("Nome Invalido",e.getMessage());
		}
		try {
			Tarefa a= new Tarefa(null);
			fail("erro Nome");
		} catch (Exception e) {
			assertEquals("Nome Invalido",e.getMessage());
		}
	}
	@Test
	public void Completa() throws NomeInvalidoException {
		Tarefa b= new Tarefa("vai");
		assertEquals("Incompleta", b.iStatus());
		b.mudaStatus();
		assertEquals("Completa", b.iStatus());
		
	}
	@Test
	public void Equals() throws NomeInvalidoException {
		Tarefa b= new Tarefa("vai");
		Tarefa c= new Tarefa("vai");
		Tarefa d= new Tarefa("vou");
		assertEquals(true, b.Equals(c));
		assertEquals(false, b.Equals(d));
	}

}
