package testesPagina;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pagina.Pagina;

public class TransferenciaDaContaInicialParaContaInicial2Test {
	  private Pagina pagina = new Pagina();
	  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  
  }

  @Test
  public void testTransferenciaDaContaInicialParaContaInicial2() throws Exception {
	pagina.tempoParaEncontrarElementoEmSegundos(30);
	pagina.setBaseUrl("https://app.organizze.com.br");
	pagina.acessarPaginaLogin();
	pagina.getPaginaLogin().executarLogin("guilhermekelling@hotmail.com","123@Trabalho");
	Thread.sleep(4000); //Tempo para esperar carregar a p�gina
	pagina.acessarPaginaInicio();
	pagina.getPaginaInicio().acessarFormularioTranferir();
	Thread.sleep(2000);
    pagina.getPaginaInicio().selecionarOrigemContaInicial();
	//Seleciona conta de destino
    Thread.sleep(2000);
    pagina.getPaginaInicio().selecionarDestinoContaInicial2();    
    pagina.getPaginaInicio().preencherValorTranferencia("100,00");
    pagina.getPaginaInicio().preencherDataTransferencia("01/04/2016");
    pagina.getPaginaInicio().executarTransferencia();
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
