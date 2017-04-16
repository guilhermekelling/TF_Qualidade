package pagina;


public class PaginaLogin {
	private Driver driver;
	private Elementos elementos = new Elementos();
	private Login login;
	
	public PaginaLogin(Driver driver){
		this.driver = driver;
	}
		
	public void executarLogin(String email, String senha){
		login = new Login(email,senha);
		executar(login);
	}
	
	public void executar(Login login){
		elementos.setWebDriver(driver.getDriver());
		elementos.preencherEmailDoUsuario(login.getUsuario());	
		elementos.preencherSenhaDoUsuario(login.getSenha()); 
	    elementos.efetuarLoggin();
	}

	public boolean verificaErroLogin() {
		return elementos.verificaErroLogin();
	}
}
