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

public class AdicionarReceitaNaContaInicialTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		driver = new ChromeDriver();
		baseUrl = "https://app.organizze.com.br";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCadastroReceita() throws Exception {
    driver.get(baseUrl + "/login");
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("guilhermekelling@hotmail.com");
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("123@Trabalho");
    driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/button")).click();
    Thread.sleep(2000);
    String SaldoTotal = driver.findElement(By.cssSelector("big")).getText();
    String SaldoContaInicial = driver.findElement(By.cssSelector("span.value.blue")).getText();
    driver.findElement(By.xpath("//div[@id='user_account_widget_fast_add']/div/div[2]/div/ul/li[2]/a/i")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("transaction_description")).clear();
    driver.findElement(By.id("transaction_description")).sendKeys("Salario");
    driver.findElement(By.id("transaction_amount")).clear();
    double valorDaTransacao = 1000.00;
    
    driver.findElement(By.id("transaction_amount")).sendKeys(String.format("%.2f", valorDaTransacao));
    driver.findElement(By.id("transaction_date")).clear();
    driver.findElement(By.id("transaction_date")).sendKeys("01042016");
    driver.findElement(By.linkText("11")).click();
    driver.findElement(By.xpath("//form[@id='new_transaction']/div[4]/div/div/div/a/i")).click();
    driver.findElement(By.cssSelector("span.label")).click();
    driver.findElement(By.xpath("//form[@id='new_transaction']/div[4]/div[2]/div/div/a/i")).click();
    driver.findElement(By.linkText("Lazer")).click();
    driver.findElement(By.cssSelector("button.button.button-blue")).click();
    Thread.sleep(2000);   
    System.out.println(SaldoTotal);
    SaldoTotal = SaldoTotal.replace("R", "").replace("$", "").replace(" ", "").replace(".", "").replace(",",".");
    SaldoContaInicial = SaldoContaInicial.replace("R", "").replace("$", "").replace(" ", "").replace(".", "").replace(",",".");
    System.out.println(SaldoTotal);
    System.out.println(SaldoContaInicial);    
    System.out.println("================="); 
    System.out.println(String.format("%.2f", (valorDaTransacao+Double.parseDouble(SaldoTotal))));
    System.out.println(driver.findElement(By.cssSelector("big")).getText().replace("R", "").replace("$", "").replace(" ", "").replace(".", "")); 
    System.out.println("Resultado(soma: saldototal+valordatransacao): "+ (valorDaTransacao+Double.parseDouble(SaldoTotal)));  
    System.out.println("Resultado(soma: saldocontainicial+valordatransacao): "+ (valorDaTransacao+Double.parseDouble(SaldoContaInicial)));  
    assertEquals(String.format("%.2f", (valorDaTransacao+Double.parseDouble(SaldoTotal))), driver.findElement(By.cssSelector("big")).getText().replace("R", "").replace("$", "").replace(" ", "").replace(".", ""));
    assertEquals(String.format("%.2f", (valorDaTransacao+Double.parseDouble(SaldoContaInicial))), driver.findElement(By.cssSelector("span.value.blue")).getText().replace("R", "").replace("$", "").replace(" ", "").replace(".", ""));
  }
  


  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

