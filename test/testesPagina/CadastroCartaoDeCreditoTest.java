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
	Thread.sleep(2000); //Tempo para esperar carregar a página
	pagina.acessarPaginaInicio();
	pagina.getPaginaInicio().acessarCadastroDeCartoesDeCredito();
	Thread.sleep(2000);
	pagina.getPaginaInicio().adicionarCartaoDeCredito("Visa","Guilherme Kelling","27","10","800,00");
	assertEquals("Guilherme Kelling", pagina.getPaginaInicio().getNomeProprietarioCartao());
	//css=a[title="MasterCard"] > img
    //driver.findElement(By.cssSelector("a.current > img")).click();
    //driver.findElement(By.cssSelector("a[title=\"Visa\"] > img")).click();
    //driver.findElement(By.id("name")).clear();
    //driver.findElement(By.id("name")).sendKeys("Guilherme Kelling");
    //new Select(driver.findElement(By.id("billing_cycle_day"))).selectByVisibleText("27");
    //new Select(driver.findElement(By.id("billing_due_day"))).selectByVisibleText("10");
    //driver.findElement(By.id("limit")).clear();
    //driver.findElement(By.id("limit")).sendKeys("800,00");
    //driver.findElement(By.linkText("+ conta padrão de pagamento")).click();
    //driver.findElement(By.xpath("//form[@id='new_credit_card']/div[2]/div[5]/div/div/a/i")).click();
    //driver.findElement(By.linkText("Conta inicialoutros")).click();
    //driver.findElement(By.cssSelector("button.button.button-blue")).click();
    //assertEquals("Guilherme Kelling", driver.findElement(By.cssSelector("span.balance")).getText());
    //driver.findElement(By.cssSelector("i.icon-arrow-bottom")).click();
    //driver.findElement(By.linkText("Desativar cartão")).click();
    //driver.findElement(By.cssSelector("button.button.button-red")).click();
    //driver.findElement(By.cssSelector("i.icon-arrow-bottom")).click();
    //driver.findElement(By.linkText("Excluir cartão")).click();
    //driver.findElement(By.cssSelector("button.button.button-red")).click();
    //assertEquals("Guilherme Kelling", driver.findElement(By.cssSelector("span.balance")).getText());
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
