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

public class AdicionarDespesaNaContaInicialTest {
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
  public void testEDespesas() throws Exception {
    driver.get(baseUrl + "/login");
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("guilhermekelling@gmail.com");
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("123@Trabalho");
    driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/button")).click();
    Thread.sleep(1000);
    driver.get(baseUrl + "/919518/lancamentos");
    driver.findElement(By.xpath("//*[@id=\"transactions-add-button-bar\"]/div/div/ul/li[1]/a")).click();
    driver.findElement(By.id("transaction_description")).clear();
    driver.findElement(By.id("transaction_description")).sendKeys("tetee");
    driver.findElement(By.id("transaction_amount")).clear();
    driver.findElement(By.id("transaction_amount")).sendKeys("1,99");
    driver.findElement(By.id("transaction_date")).clear();
    driver.findElement(By.id("transaction_date")).sendKeys("22/03/2017");
    driver.findElement(By.xpath("//*[@id=\"new_transaction\"]/div[4]/div[1]/div[1]/div/input")).clear();
    driver.findElement(By.xpath("//*[@id=\"new_transaction\"]/div[4]/div[1]/div[1]/div/input")).sendKeys("Segunda Conta");
    driver.findElement(By.id("transaction_category")).clear();
    driver.findElement(By.id("transaction_category")).sendKeys("Lazer");
    driver.findElement(By.xpath("//*[@id=\"new_transaction\"]/div[10]/button")).click();
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
