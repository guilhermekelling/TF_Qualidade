package testesPagina;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import pagina.Pagina;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdicionarReceitaNaContaInicialTest {
  private Pagina pagina = new Pagina();
  private StringBuffer verificationErrors = new StringBuffer();
  private String nomeDaReceita = "Receita1001";
  double valorDaTransacao = 1000.00;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void firstTestCadastroReceita() throws Exception {
	pagina.tempoParaEncontrarElementoEmSegundos(30);
	pagina.setBaseUrl("https://app.organizze.com.br");
	pagina.acessarPaginaLogin();
	pagina.getPaginaLogin().executarLogin("guilhermekelling@hotmail.com","123@Trabalho");
	Thread.sleep(5000); //Tempo para esperar carregar a p�gina
	pagina.acessarPaginaInicio();
	String saldoTotal = pagina.getPaginaInicio().getSaldoTotalPaginaInicio();
	String saldoContaInicial = pagina.getPaginaInicio().getSaldoContaInicialPaginaInicio();
	Thread.sleep(4000);	
	pagina.getPaginaInicio().acessarFormularioAdicionarReceita();
	Thread.sleep(4000);	
	pagina.getPaginaInicio().lancar(nomeDaReceita, "1000,00", "22032017", "Conta inicial", "Lazer");
	Thread.sleep(4000);	
	double saldoTotalAtual = valorDaTransacao + converteParaDouble(saldoTotal);
	double saldoContaInicialAtual = valorDaTransacao + converteParaDouble(saldoContaInicial);
    assertEquals(formataDoubleParaComparar(saldoTotalAtual), limparParaComparar(pagina.getPaginaInicio().getSaldoTotalPaginaInicio()));
    assertEquals(formataDoubleParaComparar(saldoContaInicialAtual), limparParaComparar(pagina.getPaginaInicio().getSaldoContaInicialPaginaInicio()));
  }
  
  @Test
  public void secondTestPesquisaReceitaCadastrada() throws Exception{
	pagina.tempoParaEncontrarElementoEmSegundos(30);
	pagina.setBaseUrl("https://app.organizze.com.br");
	pagina.acessarPaginaLogin();
	pagina.getPaginaLogin().executarLogin("guilhermekelling@hotmail.com","123@Trabalho");
	Thread.sleep(4000); //Tempo para esperar carregar a p�gina
	pagina.acessarPaginaLancamentos();
	Thread.sleep(4000);
	pagina.getPaginaLancamentos().filtrarPeriodoLancamentos("22032017", "22032017");
	Thread.sleep(4000);
	pagina.getPaginaLancamentos().pesquisarLancamento(nomeDaReceita);
	Thread.sleep(4000);
	assertEquals(nomeDaReceita, pagina.getPaginaLancamentos().getNomePrimeiroLancamentoDoResultadoDaPesquisa());
}
  
  @Test
  public void thirdTestExcluiReceitaCadastrada() throws Exception{
	pagina.tempoParaEncontrarElementoEmSegundos(30);
	pagina.setBaseUrl("https://app.organizze.com.br");
	pagina.acessarPaginaLogin();
	pagina.getPaginaLogin().executarLogin("guilhermekelling@hotmail.com","123@Trabalho");
	Thread.sleep(4000); //Tempo para esperar carregar a p�gina
	pagina.acessarPaginaLancamentos();
	Thread.sleep(4000);
	pagina.getPaginaLancamentos().filtrarPeriodoLancamentos("22032017", "22032017");
	Thread.sleep(4000);
	pagina.getPaginaLancamentos().pesquisarLancamento(nomeDaReceita);
	Thread.sleep(4000);
	pagina.getPaginaLancamentos().acessarPrimeriaDespesaDaPesquisa();
	Thread.sleep(4000);
	pagina.getPaginaLancamentos().removerPrimerioLancamentoExibido();
	Thread.sleep(5000);
	assertTrue(pagina.getPaginaLancamentos().verificarSeNaoExibeNenhumLancamento());
  }
  
  @After
  public void tearDown() throws Exception {
	pagina.fecharInstanciasAntigas();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  
  private String formataValorObtidoDaPaginaParaConverterEmDouble(String valor){
	  return valor.replace("R", "").replace("$", "").replace(" ", "").replace(".", "").replace(",",".");
  }
  
  private String limparParaComparar(String valor){
	  return valor.replace("R", "").replace("$", "").replace(" ", "").replace(".", "");
  }
  
  private double converteParaDouble(String valor){
	  return Double.parseDouble(formataValorObtidoDaPaginaParaConverterEmDouble(valor));
  }
  
  private String formataDoubleParaComparar(double valor){
	  return (String.format("%.2f", valor)).replace(".", ",");
  }

}
