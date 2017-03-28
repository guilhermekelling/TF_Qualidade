package testesPagina;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

import pagina.*;

public class loginTest {
  private Driver pagina = new Driver();
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
  }
  


  @Test
  public void testE() throws Exception {
	pagina.setTimeouts(30);
	pagina.setBaseUrl("https://www.organizze.com.br/");
    pagina.acessarPaginaLogin();
    pagina.executarLogin("guilhermekelling@gmail.com","123@Trabalho");
    Thread.sleep(2000);
  	assertEquals("https://app.organizze.com.br/inicio", pagina.getDriver().getCurrentUrl());
  }

  //erro: //*[@id="login-form"]/div[1]/span
  @After
  public void tearDown() throws Exception {
	  pagina.getDriver().quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      pagina.getDriver().findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
    	pagina.getDriver().switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = pagina.getDriver().switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
