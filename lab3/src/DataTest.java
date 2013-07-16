import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class DataTest {

	@Test
	public void DataConstrutorDiaInvalido() {
		try{
			Data a= new Data(32, 1, 2012);
			fail("Erro em dia");
		}catch(Exception e){
			assertEquals("Dia Invalido", e.getMessage());
		}
		try{
			Data a= new Data(0, 5, 2012);
			fail("Erro em dia");
		}catch(Exception e){
			assertEquals("Dia Invalido", e.getMessage());
		}
		try{
			Data a= new Data(-1, 5, 2012);
			fail("Erro em dia");
		}catch(Exception e){
			assertEquals("Dia Invalido", e.getMessage());
		}
		try{
			Data a= new Data(31, 4, 2012);
			fail("Erro em dia");
		}catch(Exception e){
			assertEquals("Mes com no maximo 30 dias", e.getMessage());
		}
		try{
			Data a= new Data(29, 2, 2013);
			fail("Erro em dia");
		}catch(Exception e){
			assertEquals("Mes com no maximo 28 dias", e.getMessage());
		}
		try{
			Data a= new Data(30, 2, 2012);
			fail("Erro em dia");
		}catch(Exception e){
			assertEquals("Mes com no maximo 29 dias", e.getMessage());
		}
	}
	@Test
	public void ConstrutorMesTest(){
		try{
			Data a= new Data(31, 13, 2012);
			fail("Erro em mes");
		}catch(Exception e){
			assertEquals("Mes Invalido", e.getMessage());
		}
		try{
			Data a= new Data(1, -1, 2012);
			fail("Erro em mes");
		}catch(Exception e){
			assertEquals("Mes Invalido", e.getMessage());
		}
		
	}
	@Test
	public void ConstrutorAnoTest(){
		try{
			Data a= new Data(31, 1, -1);
			fail("Erro em ano");
		}catch(Exception e){
			assertEquals("Ano Invalido", e.getMessage());
		}
		
	}
	@Test
	public void CompareToTest() throws AnoInvalidoException, MesInvalidoException, DiaInvalidoException{
		Data b= new Data(1,1,2012);
		Data n= new Data(1,1,2012);
		Data c= new Data(1,1,2013);
		Data a= new Data(1,1,2012);
		Data g= new Data(1,2,2012);
		Data v= new Data(1,3,2012);
		Data z= new Data(2,3,2012);
		Data w = new Data();
		assertEquals(0,b.compareTo(n));
		assertEquals(-1,b.compareTo(c));
		assertEquals(-1,a.compareTo(g));
		assertEquals(-1,v.compareTo(z));
		assertEquals(1,c.compareTo(b));
		assertEquals(1,g.compareTo(a));
		assertEquals(1,z.compareTo(v));
		assertEquals(2,w.compareTo(v));
		
	}


}
