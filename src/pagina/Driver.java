package pagina;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
	private WebDriver driver;	
	private boolean acceptNextAlert = true;
	private PaginaLogin paginaLogin;

	public Driver() {
		String OS = System.getProperty("os.name").toLowerCase();

		if(OS.indexOf("win") >= 0){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
			driver = new ChromeDriver();
		} else {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/local/bin/phantomjs");                  
			driver = new PhantomJSDriver(cap);		
		}		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
		
	public WebDriver getDriver() {
		return driver;
	}
	
	public void closeNavegator() {
		getDriver().close();
	}
	
	public void setTimeouts(int time){		
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
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
