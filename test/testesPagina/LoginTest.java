package testesPagina;

import org.junit.*;

import static org.junit.Assert.*;

import pagina.*;

public class LoginTest {
  private Pagina pagina = new Pagina();
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
  }
  
@Test
  public void testLoginComEmaileSenhaCorreta() throws Exception {
	pagina.tempoParaEncontrarElementoEmSegundos(30);
	pagina.setBaseUrl("https://app.organizze.com.br");
    pagina.acessarPaginaLogin();
    pagina.getPaginaLogin().executarLogin("guilhermekelling@hotmail.com","123@Trabalho");
    Thread.sleep(2000); //Tempo para esperar carregar a página
    String caminhoFinalEnderecoPagina = pagina.getCurrentUrl().substring(pagina.getCurrentUrl().length()-"inicio".length(), pagina.getCurrentUrl().length());
    assertEquals("inicio", caminhoFinalEnderecoPagina);
  }

@Test
public void testLoginComSenhaIncorreta() throws Exception {
	pagina.tempoParaEncontrarElementoEmSegundos(30);
	pagina.setBaseUrl("https://www.organizze.com.br");
	pagina.acessarPaginaLogin();
	pagina.getPaginaLogin().executarLogin("guilhermekelling@gmail.com","1234@Trabalho");
	Thread.sleep(2000);
	String caminhoFinalEnderecoPagina = pagina.getCurrentUrl().substring(pagina.getCurrentUrl().length()-"login".length(), pagina.getCurrentUrl().length());
	System.out.print(caminhoFinalEnderecoPagina);
	assertEquals("login", caminhoFinalEnderecoPagina);	
	assertTrue(pagina.getPaginaLogin().verificaErroLogin());
}

@Test
public void testLoginComEmailIncorreta() throws Exception {
	pagina.tempoParaEncontrarElementoEmSegundos(30);
	pagina.setBaseUrl("https://app.organizze.com.br");
	pagina.acessarPaginaLogin();
	pagina.getPaginaLogin().executarLogin("guilhermekellingg@hotmail.com","123@Trabalho");
	Thread.sleep(2000);
	String caminhoFinalEnderecoPagina = pagina.getCurrentUrl().substring(pagina.getCurrentUrl().length()-"login".length(), pagina.getCurrentUrl().length());
	assertEquals("login", caminhoFinalEnderecoPagina);
	assertTrue(pagina.getPaginaLogin().verificaErroLogin());;
}

  @After
  public void tearDown() throws Exception {
	pagina.fecharInstanciasAntigas();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
