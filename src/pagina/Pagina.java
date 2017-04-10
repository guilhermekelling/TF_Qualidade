package pagina;

public class Pagina {
	private Driver driver;
	private String baseUrl;
	private PaginaLogin paginaLogin;
	private PaginaConta paginaConta;
	private PaginaLancamentos paginaLancamentos;
	
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
		paginaLogin = new PaginaLogin(driver);
	}
	
	public void acessarPaginaContas(){
		driver.getDriver().get(baseUrl+ "/940649/a/contas");
		paginaConta = new PaginaConta(driver);
	}
	
	public void acessarPaginaLancamentos(){
		driver.getDriver().get(baseUrl+ "/940649/lancamentos");
		paginaLancamentos = new PaginaLancamentos(driver);
	}

	public PaginaLogin getPaginaLogin(){
		return paginaLogin;
	}

	public PaginaConta getPaginaConta(){
		return paginaConta;
	}
	
	public PaginaLancamentos getPaginaLancamentos(){
		return paginaLancamentos;
	}
		


}