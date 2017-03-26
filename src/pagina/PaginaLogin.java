package pagina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaLogin {

	private String user_email;
	private String user_password;
	
	public PaginaLogin(String user_email, String user_password){
		this.user_email = user_email;
		this.user_password = user_password;
	}
		
	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}		

	public String getUser_password() {
			return user_password;
		}


	public void setUser_password(String user_password) {
			this.user_password = user_password;
		}	
	
	public void executar(WebDriver driver){
		driver.findElement(By.id("user_email")).clear();
	    driver.findElement(By.id("user_email")).sendKeys(user_email);	
	    driver.findElement(By.id("user_password")).clear();
	    driver.findElement(By.id("user_password")).sendKeys(user_password);
	    driver.findElement(By.cssSelector("button.button.button-green")).click();	    
	}

}
