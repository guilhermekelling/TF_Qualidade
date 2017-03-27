package testesPagina;

import static org.junit.Assert.*;
 
import org.junit.Test;
 
public class meuTest {
 
	  private int x = 1;
	  private int y = 1;
	  
	@Test public void metodo() {
	    int z = x + y;
	    assertEquals(2, z);
	}
}