package testesPagina;


import org.junit.*;
import static org.junit.Assert.*;
import pagina.Pagina;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdicionarDespesaNaContaInicialTest {
	  private Pagina pagina = new Pagina();
	  private StringBuffer verificationErrors = new StringBuffer();
	  private String nomeDaDespesa = "Despesa1001";

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void firstTestAdicionarDespesaNaContaInicialEPesquisarDespesaParaValidar() throws Exception {
	  pagina.tempoParaEncontrarElementoEmSegundos(30);
	  pagina.setBaseUrl("https://app.organizze.com.br");
	  pagina.acessarPaginaLogin();
	  pagina.getPaginaLogin().executarLogin("guilhermekelling@hotmail.com","123@Trabalho");
	  Thread.sleep(2000); //Tempo para esperar carregar a p�gina
	  pagina.acessarPaginaLancamentos();
	  Thread.sleep(2000); //Tempo para esperar carregar a p�gina
	  pagina.getPaginaLancamentos().acessarFormularioAdicionarLancamento();
	  Thread.sleep(2000);
	  pagina.getPaginaLancamentos().lancar(nomeDaDespesa, "10,00", "22032017", "Conta inicial", "Lazer");
	  Thread.sleep(6000); //Tempo para esperar carregar a p�gina
	  assertEquals("Movimentação adicionada!", pagina.getPaginaLancamentos().verificaSeLancamentoFoiAdicionado());
  }
  
  @Test
  public void secondTestPesquisarDespesaAdicionadaNaContaInicialEPesquisarDespesaParaValidar() throws Exception {
	  pagina.tempoParaEncontrarElementoEmSegundos(30);
	  pagina.setBaseUrl("https://app.organizze.com.br");
	  pagina.acessarPaginaLogin();
	  pagina.getPaginaLogin().executarLogin("guilhermekelling@hotmail.com","123@Trabalho");
	  Thread.sleep(2000); //Tempo para esperar carregar a p�gina
	  pagina.acessarPaginaLancamentos();
	  Thread.sleep(4000); //Tempo para esperar carregar a p�gina
	  pagina.getPaginaLancamentos().filtrarPeriodoLancamentos("22032017", "22032017");
	  Thread.sleep(3000);
	  pagina.getPaginaLancamentos().pesquisarLancamento(nomeDaDespesa);
	  Thread.sleep(2000); //Tempo para esperar carregar a p�gina
      assertEquals(nomeDaDespesa, pagina.getPaginaLancamentos().getNomePrimeiroLancamentoDoResultadoDaPesquisa());
      assertEquals("22/03", pagina.getPaginaLancamentos().getDataPrimeiroLancamentoDoResultadoDaPesquisa());
      assertEquals("Lazer", pagina.getPaginaLancamentos().getCategoriaPrimeiroLancamentoDoResultadoDaPesquisa());
  }
  
  @Test
  public void thirdTestDeletarDespesaAdicionadaNaContaInicialEPesquisarDespesaParaValidar() throws Exception {
	  pagina.tempoParaEncontrarElementoEmSegundos(30);
	  pagina.setBaseUrl("https://app.organizze.com.br");
	  pagina.acessarPaginaLogin();
	  pagina.getPaginaLogin().executarLogin("guilhermekelling@hotmail.com","123@Trabalho");
	  Thread.sleep(2000); //Tempo para esperar carregar a p�gina
	  pagina.acessarPaginaLancamentos();
	  Thread.sleep(6000); //Tempo para esperar carregar a p�gina
	  pagina.getPaginaLancamentos().filtrarPeriodoLancamentos("22032017", "22032017");
	  Thread.sleep(3000);
	  pagina.getPaginaLancamentos().pesquisarLancamento(nomeDaDespesa);
	  Thread.sleep(2000); //Tempo para esperar carregar a p�gina
      assertEquals(nomeDaDespesa, pagina.getPaginaLancamentos().getNomePrimeiroLancamentoDoResultadoDaPesquisa());
      Thread.sleep(3000);
      pagina.getPaginaLancamentos().acessarPrimeriaDespesaDaPesquisa();
      Thread.sleep(5000);
      pagina.getPaginaLancamentos().removerPrimerioLancamentoExibido();
      Thread.sleep(3000); 
	  assertEquals("Nenhuma movimentação no filtro selecionado", pagina.getPaginaLancamentos().verificaSeLancamentoFoiDeletado());
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
