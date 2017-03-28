package pagina;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
	private WebDriver driver;
	private String baseUrl;
	private PaginaLogin paginaLogin;
	
	
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Driver() {
		//System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");	
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		//this.driver = new ChromeDriver();
		String OS = System.getProperty("os.name").toLowerCase();

		if(OS.indexOf("win") >= 0){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
			driver = new ChromeDriver();
		} else {
			//System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver")
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/local/bin/phantomjs");                  
			driver = new PhantomJSDriver(cap);		
		}		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void navegateTo(String url) {
		driver.navigate().to(url);
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
	
	public void executarLogin(String email, String senha){
		paginaLogin = new PaginaLogin(email,senha);
		paginaLogin.executar(driver);
	}
	
	public void acessarPaginaLogin(){
		driver.get(baseUrl+ "/login");
	}
}
