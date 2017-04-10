package testesPagina;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

import com.gargoylesoftware.htmlunit.javascript.host.canvas.CanvasCaptureMediaStreamTrack;

import pagina.*;

public class LoginComSucessoTest {
  private Pagina pagina = new Pagina();
  private boolean acceptNextAlert = true;
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

  @After
  public void tearDown() throws Exception {
	pagina.fecharInstanciasAntigas();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
