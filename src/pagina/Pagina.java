package pagina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pagina {
	
	private PaginaLogin paginaLogin;
	
	public void executarLogin(String email, String senha){
		paginaLogin = new PaginaLogin(email,senha);
		//paginaLogin.executar(driver);
	}

}