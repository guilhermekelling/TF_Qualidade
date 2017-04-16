package testesPagina;

import org.junit.*;
import static org.junit.Assert.*;
import pagina.Pagina;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CriarContaTest {
	  private Pagina pagina = new Pagina();
	  private StringBuffer verificationErrors = new StringBuffer();
	  private String nomeConta = "Conta1001";

  @Before
  public void setUp() throws Exception {
  }

 @Test
  public void firstTestCriaConta() throws Exception {
	pagina.tempoParaEncontrarElementoEmSegundos(30);
	pagina.setBaseUrl("https://app.organizze.com.br");
	pagina.acessarPaginaLogin();
	pagina.getPaginaLogin().executarLogin("guilhermekelling@hotmail.com","123@Trabalho");
	Thread.sleep(4000); //Tempo para esperar carregar a página
    pagina.acessarPaginaContas();
    pagina.getPaginaConta().criarConta("Conta1001", "Conta corrente", "100,00");
    Thread.sleep(8000);
    assertEquals("Conta1001 (Conta corrente)", pagina.getPaginaConta().getPrimeiraContaExibidaNaPaginaContas());
  }
  /*
  @Test
  public void secondTestExcluirConta() throws Exception {
	pagina.tempoParaEncontrarElementoEmSegundos(30);
	pagina.setBaseUrl("https://app.organizze.com.br");
	pagina.acessarPaginaLogin();
	pagina.getPaginaLogin().executarLogin("guilhermekelling@hotmail.com","123@Trabalho");
	Thread.sleep(2000); //Tempo para esperar carregar a página
    pagina.acessarPaginaContas();
    Thread.sleep(4000);
    if(pagina.getPaginaConta().verificaSePossuiTerceiraConta()){
    	assertEquals("Conta1001 (Conta corrente)", pagina.getPaginaConta().buscaNomeTerceiraConta());
    }    
   // Thread.sleep(4000);
   // pagina.getPaginaConta().excluirTerceiraConta();
  }
*/
 
  @After
  public void tearDown() throws Exception {
	pagina.fecharInstanciasAntigas();
	String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
