package testesPagina;

import org.junit.*;
import static org.junit.Assert.*;
import pagina.Pagina;

public class AdicionarDespesaNaContaInicialTest {
	  private Pagina pagina = new Pagina();
	  private StringBuffer verificationErrors = new StringBuffer();
	  private String nomeDaDespesa;

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void testAdicionarDespesaNaContaInicialEPesquisarDespesaParaValidar() throws Exception {
	  pagina.tempoParaEncontrarElementoEmSegundos(30);
	  pagina.setBaseUrl("https://app.organizze.com.br");
	  pagina.acessarPaginaLogin();
	  pagina.getPaginaLogin().executarLogin("guilhermekelling@hotmail.com","123@Trabalho");
	  Thread.sleep(2000); //Tempo para esperar carregar a página
	  pagina.acessarPaginaLancamentos();
	  Thread.sleep(2000); //Tempo para esperar carregar a página
	  pagina.getPaginaLancamentos().acessarFormularioAdicionarLancamento();
	  Thread.sleep(2000);
	  int numeroAleatorio = ((int)(Math.random() * 100000)) % 1000;
	  nomeDaDespesa = "Despesa"+numeroAleatorio;
	  pagina.getPaginaLancamentos().lancar(nomeDaDespesa, "10,00", "22032017", "Conta inicial", "Lazer");
	  Thread.sleep(5000); //Tempo para esperar carregar a página
	  pagina.getPaginaLancamentos().filtrarPeriodoLancamentos("22032017", "22032017");
	  Thread.sleep(3000);
	  pagina.getPaginaLancamentos().pesquisarLancamento(nomeDaDespesa);
	  Thread.sleep(2000); //Tempo para esperar carregar a página
      assertEquals(nomeDaDespesa, pagina.getPaginaLancamentos().getNomePrimeiroLancamentoDoResultadoDaPesquisa());
      assertEquals("21/03", pagina.getPaginaLancamentos().getDataPrimeiroLancamentoDoResultadoDaPesquisa());
      assertEquals("Lazer", pagina.getPaginaLancamentos().getCategoriaPrimeiroLancamentoDoResultadoDaPesquisa());
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
