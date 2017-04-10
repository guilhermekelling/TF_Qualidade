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

public class AdicionarDespesaNaContaInicialTest {
	  private Pagina pagina = new Pagina();
	  private boolean acceptNextAlert = true;
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

//    driver.findElement(By.xpath("//*[@id=\"transactions-add-button-bar\"]/div/div/ul/li[1]/a")).click();
//    driver.findElement(By.id("transaction_description")).clear();
//    driver.findElement(By.id("transaction_description")).sendKeys("tetee");
//    driver.findElement(By.id("transaction_amount")).clear();
//    driver.findElement(By.id("transaction_amount")).sendKeys("1,99");
//    driver.findElement(By.id("transaction_date")).clear();
//    driver.findElement(By.id("transaction_date")).sendKeys("22/03/2017");
//    driver.findElement(By.xpath("//*[@id=\"new_transaction\"]/div[4]/div[1]/div[1]/div/input")).clear();
//    driver.findElement(By.xpath("//*[@id=\"new_transaction\"]/div[4]/div[1]/div[1]/div/input")).sendKeys("Segunda Conta");
//    driver.findElement(By.id("transaction_category")).clear();
//    driver.findElement(By.id("transaction_category")).sendKeys("Lazer");
//    driver.findElement(By.xpath("//*[@id=\"new_transaction\"]/div[10]/button")).click();
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
