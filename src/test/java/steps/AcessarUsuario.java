package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AcessarUsuario {
    private WebDriver navegador;
    private WebElement formularioLogin;
    private WebElement nomeUsuarioConta;

    @Dado("que acesso o site Automation Practice")
    public void queAcessoOSiteAutomationPractice() {
        //Configura o driver para utilizar o navegador para testes automatizados
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //Abrir o navegador e configura o timeout
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Expande a janela do navegador
        navegador.manage().window().maximize();
        //Acessa a pagina
        navegador.get("http://automationpractice.com/index.php");
    }

    @E("clico em \"Sign in\"")
    public void clicoEmSignIn() {
        //Clicar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();
    }

    @Quando("^informo o email \"(.*)\" no formulario entrar$")
    public void informoOEmailNoFormularioEntrar(String email) {
        //Atribui o elemtento formulario de login através do id "center_column" a formularioLogin
        formularioLogin = navegador.findElement(By.id("center_column"));
        //Digitar o email no campo de id "email" que esta dentro do formulario de id "center_column"
        formularioLogin.findElement(By.id("email")).sendKeys(email);
    }

    @E("informo a senha {string} no formulario entrar")
    public void informoASenhaNoFormularioEntrar(String senha) {
        //Digitar a senha no campo de id "passwd" que esta dentro do formulario de id "center_column"
        formularioLogin.findElement(By.id("passwd")).sendKeys(senha);
    }

    @E("clico em entrar")
    public void clicoEmEntrar() {
        //Clica no botão de entrar através do seu XPath "//button[@id="SubmitLogin"]"
        navegador.findElement(By.xpath("//button[@id=\"SubmitLogin\"]")).click();
    }

    @Então("^visualizo meu nome \"(.*)\" na pagina inicial$")
    public void visualizoMeuNomeNaPaginaInicial(String nome) {
        //Valida o elemento de id "account" com o nome completo do usuario
        nomeUsuarioConta = navegador.findElement(By.className("account"));
        String nomeUsuarioSite = nomeUsuarioConta.getText();
        assertEquals(nome, nomeUsuarioSite);
    }

    @E("fecho a aplicação")
    public void fechoAAplicacao() {
        //Encerra o navegador (todas abas)
        //navegador.quit();
    }
}
