package pagina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaConta {
	Conta conta;
	private Driver driver;
	private Elementos elementos = new Elementos();
	
	public PaginaConta(Driver driver){
		this.driver = driver;
	}
	
	public void criarConta(String nome, String tipo, String saldo){
		conta = new Conta(nome,tipo,saldo);
		adicionarConta(driver.getDriver());
	}
		
	public void adicionarConta(WebDriver driver){
		elementos.setWebDriver(driver);
		elementos.acessarFormularioDeNovaConta();
		elementos.preencherNomeDaNovaConta(conta.getNome());	
		elementos.preencherTipoDaNovaConta(conta.getTipo()); 
		elementos.preencherSaldoDaNovaConta(conta.getSaldo()); 
		elementos.criarNovaConta();
	}
	
	public String getPrimeiraContaExibidaNaPaginaContas(){
		return elementos.getPrimeiraContaExibidaNaPaginaContas();
	}

}
