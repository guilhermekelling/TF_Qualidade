package testesPagina;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import pagina.Pagina;

public class AdicionarReceitaNaContaInicialTest {
  private Pagina pagina = new Pagina();
  private StringBuffer verificationErrors = new StringBuffer();
  private String nomeDaReceita;
  double valorDaTransacao;
  int numeroAleatorio;

  @Before
  public void setUp() throws Exception {
	numeroAleatorio = ((int)(Math.random() * 100000)) % 1000;
	nomeDaReceita = "Receita"+numeroAleatorio;
	valorDaTransacao = 1000.00;
  }

  @Test
  public void testCadastroReceita() throws Exception {
	pagina.tempoParaEncontrarElementoEmSegundos(30);
	pagina.setBaseUrl("https://app.organizze.com.br");
	pagina.acessarPaginaLogin();
	pagina.getPaginaLogin().executarLogin("guilhermekelling@hotmail.com","123@Trabalho");
	Thread.sleep(5000); //Tempo para esperar carregar a página
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
