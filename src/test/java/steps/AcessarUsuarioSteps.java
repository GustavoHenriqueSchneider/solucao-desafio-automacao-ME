package steps;

import configs.Web;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import pages.BasePage;
import pages.LoginFormPage;
import pages.HomePage;
import java.io.File;
import java.io.IOException;

public class AcessarUsuarioSteps {
    protected static WebDriver navegador;

    @Before
    public void setup() {
        //Instancia o navegador
        navegador = Web.createChrome();
    }

    @Dado("que desejo acessar minha conta")
    public void desejoAcessarMinhaConta(){
        //Abre o navegador e clica em Sign In
        new HomePage(navegador).clicarSignIn();
    }

    @Quando("^forneço dados de conta (corretos|incorretos|inexistentes)$")
    public void fornecoDadosDeAcessoCorretos(String tipoDadosConta){
        //Confere o tipo de dados fornecidos e realiza a operação de acordo
        if("corretos".equals(tipoDadosConta)){
            new LoginFormPage(navegador)
                    .fazerLogin("testeguguinha3@teste.com","123456");
        }
        if("incorretos".equals(tipoDadosConta)){
            new LoginFormPage(navegador)
                    .fazerLoginIncorreto("teste-me-automacao101@hotmail.com","testeSenhaErrada123");
        }
        if("inexistentes".equals(tipoDadosConta)){
            new LoginFormPage(navegador)
                    .fazerLoginIncorreto("teste-email-inexistente@teste.com.br","123456");
        }
    }

    @Então("acesso a pagina inicial")
    public void acessoAPaginaInicial() {
        //Valida o nome apresentado na pagina com o nome completo do usuario
        String nomeMensagem = new BasePage(navegador).conferirNome();
        Assert.assertEquals("Gustavo Schneider", nomeMensagem);
    }

    @Então("^visualizo o erro de autenticação$")
    public void visualizoOErroDeAutenticação() {
        //Valida se a mensagem de erro é igual a encontrada na tentativa de entrar com uma conta invalida
        String erro = new BasePage(navegador).mensagemErroLogin();
        Assert.assertEquals("There is 1 error\nAuthentication failed.", erro);
    }

    @Então("visualizo o erro de obrigatoriedade de {word}")
    public void visualizoOErroDeObrigatoriedadeDeCampo(String tipoErro) {
        //Valida mensagens de erro de acordo com o erro de campo obrigatório não preenchido
        String erro = new BasePage(navegador).mensagemErroLogin();
        if("email".equals(tipoErro))
        {
            //Valida se a mensagem de erro é igual a encontrada na tentativa de entrar sem email
            Assert.assertEquals("There is 1 error\nAn email address required.", erro);
        }
        else if("senha".equals(tipoErro))
        {
            //Valida se a mensagem de erro é igual a encontrada na tentativa de entrar sem senha
            Assert.assertEquals("There is 1 error\nPassword is required.", erro);
        }
    }

    @Quando("informo somente o campo {word}")
    public void informoOOutroCampoDoTeste(String campoPreenchido) {
        //Informa somente o campo determinado de acordo com o desejado
        if("email".equals(campoPreenchido))
            new LoginFormPage(navegador).fazerLoginIncorreto("teste-me-automacao101@hotmail.com","");
        if("senha".equals(campoPreenchido))
            new LoginFormPage(navegador).fazerLoginIncorreto("","123456");
    }

    @After(order=1)
    public void screenshot(Scenario cenario){
        //Cria uma variavel do tipo File e atribui o print da tela nela, pois casteia os metodos da classe
        //TakesScreenshot para a variavel navegador
        File file = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        String caminho = "relatorios/evidencias/"+cenario.getName()+"."+cenario.getLine()+".jpg";
            //Copia o arquivo para o diretório, ou seja, salva a evidencia
        try {
            FileUtils.copyFile(file, new File(caminho));
        } catch (IOException e) {
            System.out.println("\nHouve um erro ao tirar o print da evidencia: "+e+"\n");
        }
    }

    @After(order=0)
    public void tearDown() {
        //Encerra o navegador (todas abas)
        navegador.quit();
    }
}
