package pagina;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    
    public void teste(){
    	driver.findElement(By.id("transaction_description")).clear();
    	driver.findElement(By.id("transaction_description")).sendKeys("Salario");
    	
    }
    
    public void preencherDataLancamento(String data) throws InterruptedException{
	    driver.findElement(By.id("transaction_date")).clear();
	    driver.findElement(By.id("transaction_date")).sendKeys(data);    
	    driver.findElement(By.linkText(data.substring(0,2))).click();
	    Thread.sleep(4000);
    }
    
    public void selecionarContaLancamento(String conta){
	    driver.findElement(By.xpath("//*[@id=\"new_transaction\"]/div[4]/div[1]/div[1]/div/a/i")).click();
	//    if(conta.equals("Conta inicial"))	
	    	driver.findElement(By.cssSelector("span.label")).click();
	 //   driver.findElement(By.linkText("Conta inicialoutros")).click();;    	
    }
    
    public void selecionarCategoriaLancamento(String categoria){
	    driver.findElement(By.xpath("//*[@id=\"new_transaction\"]/div[4]/div[2]/div/div/a/i")).click();
	    driver.findElement(By.linkText(categoria)).click();    	
    }
    
    public void executarLancamento(){
    	driver.findElement(By.xpath("//*[@id=\"new_transaction\"]/div[10]/button")).click();
    }
    
    public void selecionarEscolherPeriodo() throws InterruptedException{
        WebElement menuPeriodo = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[1]/div[2]"));
    	Actions action = new Actions(driver);
        action.moveToElement(menuPeriodo).perform();
        Thread.sleep(3000);
        //driver.findElement(By.linkText("Escolher período")).click();
        driver.findElement(By.xpath("//*[@id=\"surfer-options\"]/li[4]/a")).click();
      
    }
    
    public void preencherDataInicioFimDoFiltroEscolherPeriodo(String dataInicial, String dataFinal) throws InterruptedException{
    	driver.findElement(By.id("month_select_start_date")).clear();
        driver.findElement(By.id("month_select_start_date")).sendKeys(dataInicial);
        driver.findElement(By.linkText(dataInicial.substring(0,2))).click();
        Thread.sleep(4000);    
        driver.findElement(By.id("month_select_end_date")).clear();
        driver.findElement(By.id("month_select_end_date")).sendKeys(dataFinal);
        driver.findElement(By.linkText(dataFinal.substring(0,2))).click();
        Thread.sleep(4000); 
    }
    
    public void filtrarLancamentos() throws InterruptedException{
        WebElement menuPeriodo = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[1]/div[2]"));
    	Actions action = new Actions(driver);
        action.moveToElement(menuPeriodo).click();
        driver.findElement(By.xpath("//*[@id=\"surfer-custom-form\"]/form/div[4]/button")).click();
        Thread.sleep(4000);
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
    
    public String getSaldoTotalPaginaInicio(){
    	return driver.findElement(By.cssSelector("span.value.blue")).getText();
    }
    
    public String getSaldoContaInicialPaginaInicio(){
    	return driver.findElement(By.cssSelector("big")).getText();
    }
    
    public void acessarFormularioAdicionarReceita(){
    	driver.findElement(By.xpath("//div[@id='user_account_widget_fast_add']/div/div[2]/div/ul/li[2]/a/i")).click();
    }
    
        
    public void selecionarContaParaAdicionarReceita(String conta){
        driver.findElement(By.xpath("//form[@id='new_transaction']/div[4]/div/div/div/a/i")).click();
        driver.findElement(By.cssSelector("span.label")).click();
    }
  
    public void executarLancamentoReceita(){
    	driver.findElement(By.cssSelector("button.button.button-blue")).click();
    }

	public void acessarFormularioTranferir() {
		driver.findElement(By.xpath("//div[@id='user_account_widget_fast_add']/div/div[2]/div/ul/li[3]/a/i")).click();		
	}

	public void selecionarOrigemContaInicial() {
		 driver.findElement(By.cssSelector("input.ui-autocomplete-input")).click();
		 driver.findElement(By.cssSelector("span.label")).click();
	}

	public void selecionarDestinoContaInicial2() {
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
	    driver.findElement(By.cssSelector("a[title=\"Conta inicial2\"] > span.label")).click();		
	}
    
}
