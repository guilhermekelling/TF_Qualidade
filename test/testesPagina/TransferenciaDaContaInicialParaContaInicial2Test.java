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
	Thread.sleep(2000); //Tempo para esperar carregar a página
	
	pagina.getPaginaInicio().acessarFormularioTranferir();
	Thread.sleep(2000);
    
	pagina.getPaginaInicio().selecionarOrigemContaInicial();
	//Seleciona conta de destino

    Thread.sleep(2000);
    pagina.getPaginaInicio().selecionarDestinoContaInicial2();
   
        
 //   driver.findElement(By.id("transaction_amount")).clear();
 //   driver.findElement(By.id("transaction_amount")).sendKeys("10,00");
 //   driver.findElement(By.id("transaction_date")).clear();
  //  driver.findElement(By.id("transaction_date")).sendKeys("01/04/2016");
  //  driver.findElement(By.linkText("11")).click();
  //  driver.findElement(By.cssSelector("button.button.button-blue")).click();
  //  Thread.sleep(8000);
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
