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

public class TestandoMenus {
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
  public void testTttt() throws Exception {
    driver.get(baseUrl + "/login");
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("guilhermekelling@hotmail.com");
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("123@Trabalho");
    driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/button")).click();
    Thread.sleep(2000);
    driver.get(baseUrl + "/940649/lancamentos");
    Thread.sleep(2000);    
    WebElement menuPeriodo = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[1]/div[2]"));
    Actions action = new Actions(driver);
    action.moveToElement(menuPeriodo).perform();
    Thread.sleep(1000);
    driver.findElement(By.linkText("Escolher período")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("month_select_start_date")).clear();
    driver.findElement(By.id("month_select_start_date")).sendKeys("22032017");
    driver.findElement(By.linkText("22")).click();
    Thread.sleep(4000);    
    driver.findElement(By.id("month_select_end_date")).clear();
    driver.findElement(By.id("month_select_end_date")).sendKeys("22032017");
    driver.findElement(By.linkText("22")).click();
    Thread.sleep(4000); 
    action.moveToElement(menuPeriodo).click();
    driver.findElement(By.xpath("//*[@id=\"surfer-custom-form\"]/form/div[4]/button")).click();
    Thread.sleep(8000);
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
