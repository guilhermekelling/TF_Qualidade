package testesPagina;

import org.junit.*;
import static org.junit.Assert.*;
import pagina.Pagina;

public class AdicionarDespesaNaContaInicialTest {
	  private Pagina pagina = new Pagina();
	  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void testEDespesas() throws Exception {
	  pagina.tempoParaEncontrarElementoEmSegundos(30);
	  pagina.setBaseUrl("https://app.organizze.com.br");
	  pagina.acessarPaginaLogin();
	  pagina.getPaginaLogin().executarLogin("guilhermekelling@hotmail.com","123@Trabalho");
	  Thread.sleep(2000); //Tempo para esperar carregar a página
	  pagina.acessarPaginaLancamentos();
	 // Thread.sleep(2000); //Tempo para esperar carregar a página
	//  pagina.getPaginaLancamentos().acessarFormularioAdicionarLancamento();
	//  Thread.sleep(2000);
	//  int numeroAleatorio = ((int)(Math.random() * 100000)) % 1000;
	//  pagina.getPaginaLancamentos().lancar("Despesa12", "10,00", "22/03/17", "Conta inicial", "Lazer");
	//  Thread.sleep(1000); //Tempo para esperar carregar a página
	 // pagina.getPaginaLancamentos().filtrarPeriodoLancamentos("22/03/2017", "22/03/2017");
	 // pagina.getPaginaLancamentos().pesquisarLancamento("Despesa12");
	 // Thread.sleep(1000); //Tempo para esperar carregar a página
     // assertEquals("Despesa12", pagina.getPaginaLancamentos().getNomePrimeiroLancamentoDoResultadoDaPesquisa());
     // assertEquals("22/03", pagina.getPaginaLancamentos().getDataPrimeiroLancamentoDoResultadoDaPesquisa());
	 // assertEquals("Lazer", pagina.getPaginaLancamentos().getCategoriaPrimeiroLancamentoDoResultadoDaPesquisa());
	 
  }

  @After
  public void tearDown() throws Exception {
	pagina.fecharInstanciasAntigas();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
