package pagina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Elementos {
	WebDriver driver;

    public Elementos(){
		
	}
    
    public void setWebDriver(WebDriver driver){
    	this.driver = driver;
    }
    
    public void preencherEmailDoUsuario(String user_email){
		driver.findElement(By.id("user_email")).clear();
	    driver.findElement(By.id("user_email")).sendKeys(user_email);    	
    }
    
    public void preencherSenhaDoUsuario(String user_password){
	    driver.findElement(By.id("user_password")).clear();
	    driver.findElement(By.id("user_password")).sendKeys(user_password);    	
    }
    
    public void efetuarLoggin(){
    	driver.findElement(By.cssSelector("button.button.button-green")).click();
    }
    
    public void preencherNomeDaNovaConta(String nomeDaNovaConta){
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(nomeDaNovaConta);
    }
    
    public void preencherTipoDaNovaConta(String tipoDaNovaConta){
    	new Select(driver.findElement(By.id("kind"))).selectByVisibleText(tipoDaNovaConta);
    }
    
    public void preencherSaldoDaNovaConta(String saldoDaNovaConta){
    	driver.findElement(By.id("initial_amount_value")).clear();
        driver.findElement(By.id("initial_amount_value")).sendKeys(saldoDaNovaConta);
    }
    
    public void acessarFormularioDeNovaConta(){
    	driver.findElement(By.cssSelector("i.zze-round-button-blue.icon-plus")).click();
    }
    
    public void criarNovaConta(){
    	 driver.findElement(By.xpath("//div[@id='ngdialog1']/div[2]/div/div[2]/form/div[6]/button")).click();
    }
    
    public String getPrimeiraContaExibidaNaPaginaContas(){
    	return driver.findElement(By.xpath("//div[@id='content']/div/div/div/div[2]/ul/li[1]/div/div/div/div[2]/span")).getText();
    }

    
    
    

}
