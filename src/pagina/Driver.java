package pagina;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
		System.setProperty("webdriver.chrome.driver", "C:\\plugin\\chromedriver.exe");	
		this.driver = new ChromeDriver();
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
