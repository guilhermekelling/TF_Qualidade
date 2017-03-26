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

public class lancamentoDispesaTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    baseUrl = "https://app.organizze.com.br";
    driver = new ChromeDriver();  
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testE() throws Exception {
    driver.get(baseUrl + "/login");    
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_email")).sendKeys("guilhermekelling@gmail.com");    
    driver.findElement(By.id("user_password")).sendKeys("123@Trabalho");
    driver.findElement(By.cssSelector("button.button.button-green")).click();
   /* Thread.sleep(1000);
    driver.get(baseUrl + "/919518/inicio");  
    driver.findElement(By.xpath("//*[@id=\"transactions-add-button-bar\"]/div/div/ul/li[1]/a"));
    driver.findElement(By.id("transaction_description")).clear();
    driver.findElement(By.id("transaction_description")).sendKeys("Bala");
    driver.findElement(By.id("transaction_amount")).clear();
    driver.findElement(By.id("transaction_amount")).sendKeys("1,99");
    driver.findElement(By.id("transaction_date")).clear();
    driver.findElement(By.id("transaction_date")).sendKeys("20/03/2017");
    driver.findElement(By.id("transaction_category")).clear();
    driver.findElement(By.id("transaction_category")).sendKeys("");
    driver.findElement(By.linkText("Alimentação")).click();
    driver.findElement(By.cssSelector("div.action-bar > button.button.button-blue")).click();
  */}

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
