package pagina;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pagina {
	private Driver driver;
	private String baseUrl;
	private PaginaLogin paginaLogin;
	
	public Pagina (){
		driver = new Driver();
	}
	
		
	public String getBaseUrl() {
		return baseUrl;
	}
	
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public void tempoParaEncontrarElementoEmSegundos(int time){		
		driver.setTimeouts(time);
	}
	
	public void fecharInstanciasAntigas(){
		driver.getDriver().quit();
	}
	
	public String getCurrentUrl(){
		return driver.getDriver().getCurrentUrl();
	}
	public void navegateTo(String url) {
		driver.getDriver().navigate().to(url);
	}
	
	public void acessarPaginaLogin(){
		driver.getDriver().get(baseUrl+ "/login");
	}

	public void executarLogin(String email, String senha){
		paginaLogin = new PaginaLogin(email,senha);
		paginaLogin.executar(driver.getDriver());
	}

}