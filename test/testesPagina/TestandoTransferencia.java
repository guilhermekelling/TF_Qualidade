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

public class TestandoTransferencia {
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
  public void testE() throws Exception {
    driver.get(baseUrl + "/login");
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("guilhermekelling@hotmail.com");
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("123@Trabalho");
    driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/button")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@id='user_account_widget_fast_add']/div/div[2]/div/ul/li[3]/a/i")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//form[@id='new_transference']/div[2]/div/div/a/i")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id=\"ui-id-61\"]/a")).click();
    
    driver.findElement(By.xpath("//form[@id='new_transference']/div[3]/div/div/a/i")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id=\"ui-id-37\"]/a")).click();
    
    driver.findElement(By.id("transaction_amount")).clear();
    driver.findElement(By.id("transaction_amount")).sendKeys("10,00");
    driver.findElement(By.id("transaction_date")).clear();
    driver.findElement(By.id("transaction_date")).sendKeys("01/04/2016");
    driver.findElement(By.linkText("11")).click();
    driver.findElement(By.cssSelector("button.button.button-blue")).click();
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
