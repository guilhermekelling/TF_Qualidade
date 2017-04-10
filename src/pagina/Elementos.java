package pagina;

import static org.junit.Assert.assertEquals;

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
    
    public void acessarFormularioAdicionarLancamento(){
  	  driver.findElement(By.cssSelector("i.icon-plus.red")).click();
    }
    
    public void preencherDescricaoLancamento(String descricao){
	    driver.findElement(By.id("transaction_description")).clear();
	    driver.findElement(By.id("transaction_description")).sendKeys(descricao);
    }
    
    public void preencherValorLancamento(String valor){
	    driver.findElement(By.id("transaction_amount")).clear();
	    driver.findElement(By.id("transaction_amount")).sendKeys(valor);    	
    }
    
    public void preencherDataLancamento(String data){
    	System.out.println("Data "+data);
	    driver.findElement(By.id("transaction_date")).clear();
	    driver.findElement(By.id("transaction_date")).sendKeys(data);    	
    }
    
    public void selecionarContaLancamento(String conta){
    	System.out.println("Conta "+conta);
	    driver.findElement(By.xpath("//*[@id=\"new_transaction\"]/div[4]/div[1]/div[1]/div/a/i")).click();
	//    if(conta.equals("Conta inicial"))	
	    	driver.findElement(By.cssSelector("span.label")).click();
	 //   driver.findElement(By.linkText("Conta inicialoutros")).click();;    	
    }
    
    public void selecionarCategoriaLancamento(String categoria){
    	System.out.println("Categoria "+categoria);
	    driver.findElement(By.xpath("//*[@id=\"new_transaction\"]/div[4]/div[2]/div/div/a/i")).click();
	    driver.findElement(By.linkText(categoria)).click();    	
    }
    
    public void executarLancamento(){
    	driver.findElement(By.xpath("//*[@id=\"new_transaction\"]/div[10]/button")).click();
    }
    
    public void selecionarEscolherPeriodo(){
    //	driver.findElement(By.xpath("//*[@id=\"surfer-options\"]/li[4]/a")).click();
    	driver.findElement(By.linkText("Escolher período")).click();
    }
    
    public void preencherDataInicioFimDoFiltroEscolherPeriodo(String dataInicial, String dataFinal){
    	driver.findElement(By.xpath("//*[@id=\"month_select_start_date\"]")).clear();
	    driver.findElement(By.xpath("//*[@id=\"month_select_start_date\"]")).sendKeys(dataInicial);
	    driver.findElement(By.xpath("//*[@id=\"month_select_end_date\"]")).clear();
	    driver.findElement(By.xpath("//*[@id=\"month_select_end_date\"]")).sendKeys(dataFinal);
    }
    
    public void filtrarLancamentos(){
    	driver.findElement(By.xpath("//*[@id=\"surfer-custom-form\"]/form/div[4]/button")).click();
    }

    public void selecionarPesquisarLancamento(){
    	driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/div/a/i")).click();
    }
    
    public void preencherTextoDoPesquisarLancamento(String textoDaPesquisa){
    	driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/div/div/input")).clear();
 	    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/div/div/input")).sendKeys(textoDaPesquisa);
    }
    
    public String getNomePrimeiroLancamentoDoResultadoDaPesquisa(){
    	return driver.findElement(By.cssSelector("em.h")).getText();
    }
    
    public String getCategoriaPrimeiroLancamentoDoResultadoDaPesquisa(){
    	return driver.findElement(By.cssSelector("span.name.ng-binding")).getText();
    }
    
    public String getDataPrimeiroLancamentoDoResultadoDaPesquisa(){
    	return driver.findElement(By.cssSelector("span.ng-binding")).getText();
    }
    
    public String getValorPrimeiroLancamentoDoResultadoDaPesquisa(){
    	return driver.findElement(By.cssSelector("span.ng-binding")).getText();
    }
}
