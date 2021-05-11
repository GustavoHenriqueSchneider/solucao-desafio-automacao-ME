package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.BasePage;
import pages.HomePage;
import pages.LoginFormPage;
import pages.RegisterFormPage;

import static steps.AcessarUsuarioSteps.navegador;

public class CadastrarUsuarioSteps {

    @Dado("que desejo cadastrar uma conta")
    public void desejoCadastrarUmaConta(){
        //Abre o navegador e clica em Sign In
        new HomePage(navegador)
                .clicarSignIn();
    }

    @Quando("^inicio um cadastro (corretamente|já existente|sem email)$")
    public void inicioUmCadastro(String tipoCadastro){
        //Realiza ou não o processo de cadastro de acordo com o tipo de cadastro
        if("corretamente".equals(tipoCadastro))
            //Informa o email para um novo cadastro
            new LoginFormPage(navegador).cadastrarConta("testeguguinha3@teste.com");
        if("já existente".equals(tipoCadastro))
            //Informa um email com cadastro ja existente
            new LoginFormPage(navegador).cadastrarConta("teste-me-automacao102@hotmail.com");
        if("sem email".equals(tipoCadastro))
            //Tenta iniciar o cadastro sem fornecer o email
            new LoginFormPage(navegador).cadastrarConta("");
    }

    @Quando("forneço dados de cadastro")
    public void fornecoDadosDeCadastro(){
        //Informa os dados para completar e efetuar o cadastro do usuario
        new RegisterFormPage(navegador).registrarUsuario("M","Gustavo","Schneider",
                "123456",05,11,"2001","Rua Sei la teste", "Cidade irineu",
                "Hawaii",98980,"+1199122456");
    }

    @Então("^visualizo o erro de criação de conta (já existente|sem email)$")
    public void visualizoOErroDeCriaçãoDeConta(String tipoErro) {
        //Valida se a mensagem de erro é igual a encontrada na tentativa de se registrar de forma invalida
        String erro = new BasePage(navegador).mensagemErroCadastro();
        if("já existente".equals(tipoErro))
        {
            //Valida se a mensagem de erro é igual a encontrada na tentativa de criar uma conta já existente
            Assert.assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.",erro);
        }
        else if("sem email".equals(tipoErro))
        {
            //Valida se a mensagem de erro é igual a encontrada na tentativa de criar uma conta sem email
            Assert.assertEquals("Invalid email address.",erro);
        }
    }
}
