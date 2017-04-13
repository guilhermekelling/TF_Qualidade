package pagina;

public class PaginaInicio {
	private Driver driver;
	private Elementos elementos = new Elementos();
	private Lancamento lancamento;
	
	public PaginaInicio(Driver driver){
		this.driver = driver;
		elementos.setWebDriver(driver.getDriver());
	}
	
	public String getSaldoTotalPaginaInicio(){
		return elementos.getSaldoTotalPaginaInicio();
	}

	public String getSaldoContaInicialPaginaInicio(){
		return elementos.getSaldoContaInicialPaginaInicio();
	}
	
	public void adicionarReceita(){
		elementos.acessarFormularioAdicionarReceita();
	}
	
	public void acessarFormularioAdicionarReceita(){
		elementos.acessarFormularioAdicionarReceita();
	}
	
	public void lancar(String descricao, String valor, String data, String conta, String categoria) throws InterruptedException{
		lancamento = new Lancamento(descricao, valor, data, conta, categoria);	
		executarLancamento(lancamento);
	}
		
	public void executarLancamento(Lancamento lancamento) throws InterruptedException{
		elementos.preencherDescricaoLancamento(lancamento.getDescricao());
		elementos.preencherValorLancamento(lancamento.getValor());		
		elementos.selecionarCategoriaLancamento(lancamento.getCategoria());	
		elementos.selecionarContaParaAdicionarReceita(lancamento.getConta());
		elementos.preencherDataLancamento(lancamento.getData());
		elementos.executarLancamentoReceita();	
	}
	
	public Driver getDriver(){
		return driver;
	}

	public void acessarFormularioTranferir() {
		elementos.acessarFormularioTranferir();		
	}

	public void selecionarOrigemContaInicial() {
		elementos.selecionarOrigemContaInicial();		
	}

	public void selecionarDestinoContaInicial2() {
		elementos.selecionarDestinoContaInicial2();		
	}
}
