package pagina;


import org.openqa.selenium.WebDriver;

public class PaginaConta {
	Conta conta;
	private Driver driver;
	private Elementos elementos = new Elementos();
	
	public PaginaConta(Driver driver){
		this.driver = driver;
		elementos.setWebDriver(driver.getDriver());
	}
	
	public void criarConta(String nome, String tipo, String saldo){
		conta = new Conta(nome,tipo,saldo);
		adicionarConta();
	}
		
	public void adicionarConta(){
		elementos.acessarFormularioDeNovaConta();
		elementos.preencherNomeDaNovaConta(conta.getNome());	
		elementos.preencherTipoDaNovaConta(conta.getTipo()); 
		elementos.preencherSaldoDaNovaConta(conta.getSaldo()); 
		elementos.criarNovaConta();
	}
	
	public String getPrimeiraContaExibidaNaPaginaContas(){
		return elementos.getPrimeiraContaExibidaNaPaginaContas();
	}

	public String buscaNomeTerceiraConta() {
		return elementos.buscaNomeTerceiraConta();		
	}

	public boolean verificaSePossuiTerceiraConta() {
		return elementos.verificaSePossuiTerceiraConta();
	}

	public void excluirTerceiraConta() throws InterruptedException {
		elementos.excluirTerceiraConta();		
	}

}
