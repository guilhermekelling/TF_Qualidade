package pagina;

public class Conta {
	private String nome;
	private String tipo;
	private String saldo;

	public Conta(){
	}

	public Conta(String nome, String tipo, String saldo){
		this.nome = nome;
		this.tipo = tipo;
		this.saldo = saldo;
	}
	
	public void setNome(String nome){
		this.nome = nome;		
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	public void setSaldo(String saldo){
		this.saldo = saldo;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public String getSaldo(){
		return saldo;
	}
	
}
