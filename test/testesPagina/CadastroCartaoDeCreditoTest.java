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

public class CadastroCartaoDeCreditoTest {
	private Pagina pagina = new Pagina();
	private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testECadastroCartaoDeCredito() throws Exception {
	pagina.tempoParaEncontrarElementoEmSegundos(30);
	pagina.setBaseUrl("https://app.organizze.com.br");
	pagina.acessarPaginaLogin();
	pagina.getPaginaLogin().executarLogin("guilhermekelling@hotmail.com","123@Trabalho");
	Thread.sleep(2000); //Tempo para esperar carregar a p�gina
	pagina.acessarPaginaInicio();
	pagina.getPaginaInicio().acessarCadastroDeCartoesDeCredito();
	Thread.sleep(2000);
	pagina.getPaginaInicio().adicionarCartaoDeCredito("Guilherme Kelling","27","10","800,00");
	Thread.sleep(3000);
	assertTrue(pagina.getPaginaInicio().avisoCartaoDeCreditoFoiCadastrado());
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
