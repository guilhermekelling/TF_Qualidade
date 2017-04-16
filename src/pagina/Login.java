package pagina;


public class Login {
	private String usuario;
	private String senha;
	
	public Login(String usuario, String senha){
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public void setUsurio(String usuario){
		this.usuario = usuario;
	}
	
	public void setSenha(String senha){
		this.senha = senha;
	}
	
	public String getUsuario(){
		return usuario;
	}
	public String getSenha(){
		return senha;
	}
	
	

}
