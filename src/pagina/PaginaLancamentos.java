package pagina;

public class PaginaLancamentos {
	private Lancamento lancamento;
	private Driver driver;
	private Elementos elementos = new Elementos();

	public PaginaLancamentos(Driver driver){
		this.driver = driver;
		elementos.setWebDriver(driver.getDriver());
	}
	
	public void acessarFormularioAdicionarLancamento(){		
		elementos.acessarFormularioAdicionarLancamento();		
	}
	
	public void lancar(String descricao, String valor, String data, String conta, String categoria){
		lancamento = new Lancamento(descricao, valor, data, conta, categoria);	
		executarLancamento(lancamento);
	}
	
	public void executarLancamento(Lancamento lancamento){
		elementos.preencherDescricaoLancamento(lancamento.getDescricao());
		elementos.preencherValorLancamento(lancamento.getValor());		
		elementos.selecionarCategoriaLancamento(lancamento.getCategoria());	
		elementos.selecionarContaLancamento(lancamento.getConta());
		elementos.preencherDataLancamento(lancamento.getData());
		elementos.executarLancamento();		
	}
	
	public void filtrarPeriodoLancamentos(String dataInicial, String dataFinal) throws InterruptedException{
		elementos.selecionarEscolherPeriodo();
		Thread.sleep(1000);
		elementos.preencherDataInicioFimDoFiltroEscolherPeriodo(dataInicial, dataFinal);
		elementos.filtrarLancamentos();
	}
	
	public void pesquisarLancamento(String textoDaPesquisa){
		elementos.selecionarPesquisarLancamento();
		elementos.preencherTextoDoPesquisarLancamento(textoDaPesquisa);
	}
	
	public String getNomePrimeiroLancamentoDoResultadoDaPesquisa(){
		return elementos.getNomePrimeiroLancamentoDoResultadoDaPesquisa();
	}
	
	public String getCategoriaPrimeiroLancamentoDoResultadoDaPesquisa(){
		return elementos.getCategoriaPrimeiroLancamentoDoResultadoDaPesquisa();
	}
	
	public String getDataPrimeiroLancamentoDoResultadoDaPesquisa(){
		return elementos.getDataPrimeiroLancamentoDoResultadoDaPesquisa();
	}
	
	public String getValorPrimeiroLancamentoDoResultadoDaPesquisa(){
		return elementos.getValorPrimeiroLancamentoDoResultadoDaPesquisa();
	}	
}
