package pagina;

public class Lancamento {
	private String descricao;
	private String valor;
	private String data;
	private String conta;
	private String categoria;
	
	public Lancamento(String descricao, String valor, String data, String conta, String categoria){
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.conta = conta;
		this.categoria = categoria;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
