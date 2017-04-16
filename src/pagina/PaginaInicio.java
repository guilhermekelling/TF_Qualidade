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

	public void selecionarOrigemContaInicial() throws InterruptedException {
		elementos.selecionarOrigemContaInicial();		
	}

	public void selecionarDestinoContaInicial2() throws InterruptedException {
		elementos.selecionarDestinoContaInicial2();		
	}

	public void acessarCadastroDeCartoesDeCredito() throws InterruptedException {
		elementos.acessarCadastroDeCartoesDeCredito();
	}

	public void adicionarCartaoDeCredito(String bandeira, String nomeProprietario, String diaFechamento, String diaVencimento,
			String limite) throws InterruptedException {
		elementos.selecionarBanderia(bandeira);
		elementos.preencherNomeProprietarioCartao(nomeProprietario);
		elementos.preencherDiaFechamentoCartao(diaFechamento);
		elementos.preencherDiaVencimentoCartao(diaVencimento);
		elementos.preencherLimiteCartao(limite);
		elementos.selecionarContaInicialPadraoPagamentoCartao();
		elementos.executarCadastroCartaoDeCredito();
			
		}

	public String getNomeProprietarioCartao() {
		return elementos.getNomeProprietarioCartao();	
	}

	public void preencherValorTranferencia(String valorTransferencia) {
		elementos.preencherValorTranferencia(valorTransferencia);		
	}

	public void preencherDataTransferencia(String dataTransferencia) {
		elementos.preencherDataTransferencia(dataTransferencia);		
	}

	public void executarTransferencia() {
		elementos.executarTransferencia();		
	}

	public void acessarLancamentosDaContaInicial() throws InterruptedException{
		elementos.acessarLancamentosDaContaInicial();		
	}

	public void pesquisarReceita(String nomeDaReceita) throws InterruptedException {
		elementos.pesquisarReceita(nomeDaReceita);		
	}

	public void removerPrimeiraReceitaDaPagina() throws InterruptedException {
		elementos.removerPrimeiraReceitaDaPagina();		
	}

}
