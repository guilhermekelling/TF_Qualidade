package testesPagina;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import pagina.Pagina;

public class CriarContaTest {
	  private Pagina pagina = new Pagina();
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testECriaConta() throws Exception {
	pagina.tempoParaEncontrarElementoEmSegundos(30);
	pagina.setBaseUrl("https://app.organizze.com.br");
	pagina.acessarPaginaLogin();
	pagina.getPaginaLogin().executarLogin("guilhermekelling@hotmail.com","123@Trabalho");
	Thread.sleep(2000); //Tempo para esperar carregar a página
    pagina.acessarPaginaContas();
    int numeroAleatorio = ((int)(Math.random() * 100000)) % 1000;
    pagina.getPaginaConta().criarConta("Conta"+numeroAleatorio, "Conta corrente", "100,00");
    Thread.sleep(2000);
    System.out.println("Conta"+numeroAleatorio);
    assertEquals("Conta"+numeroAleatorio+" (Conta corrente)", pagina.getPaginaConta().getPrimeiraContaExibidaNaPaginaContas());
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
