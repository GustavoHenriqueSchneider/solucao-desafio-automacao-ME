package steps;

import configs.ExcelReader;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.BasePage;
import pages.HomePage;
import pages.LoginFormPage;
import pages.RegisterFormPage;
import java.util.List;
import java.util.Map;

import static steps.AcessarUsuarioSteps.navegador;

public class CadastrarUsuarioSteps {
    private List<Map<String, String>> tabela = null;

    @Dado("que desejo cadastrar uma conta")
    public void desejoCadastrarUmaConta(){
        //Abre o navegador e clica em Sign In
        new HomePage(navegador)
                .clicarSignIn();
    }

    @Quando("^inicio um cadastro (corretamente|ja existente|sem email)$")
    public void inicioUmCadastro(String tipoCadastro){
        ExcelReader reader = new ExcelReader();
        try {
            tabela = reader.getData("dados.xlsx", "dadosUsuario");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Realiza ou não o processo de cadastro de acordo com o tipo de cadastro
        if("corretamente".equals(tipoCadastro))
            //Informa o email para um novo cadastro
            new LoginFormPage(navegador).cadastrarConta(tabela.get(0).get("Email"));
        if("ja existente".equals(tipoCadastro))
            //Informa um email com cadastro ja existente
            new LoginFormPage(navegador).cadastrarConta("teste-me-automacao102@hotmail.com");
        if("sem email".equals(tipoCadastro))
            //Tenta iniciar o cadastro sem fornecer o email
            new LoginFormPage(navegador).cadastrarConta("");
    }

    @Quando("forneço dados de cadastro")
    public void fornecoDadosDeCadastro(){
        //Informa os dados para completar e efetuar o cadastro do usuario
        new RegisterFormPage(navegador).registrarUsuario(
                tabela.get(0).get("Genero"),
                tabela.get(0).get("Nome"),
                tabela.get(0).get("Sobrenome"),
                tabela.get(0).get("Senha"),
                Integer.parseInt(tabela.get(0).get("DiaNASC")),
                Integer.parseInt(tabela.get(0).get("MesNASC")),
                tabela.get(0).get("AnoNASC"),
                tabela.get(0).get("Endereço"),
                tabela.get(0).get("Cidade"),
                tabela.get(0).get("Estado"),
                tabela.get(0).get("CEP"),
                tabela.get(0).get("Telefone"));
    }

    @Então("^visualizo o erro de criação de conta (ja existente|sem email)$")
    public void visualizoOErroDeCriaçãoDeConta(String tipoErro) {
        //Valida se a mensagem de erro é igual a encontrada na tentativa de se registrar de forma invalida
        String erro = new BasePage(navegador).mensagemErroCadastro();
        if("ja existente".equals(tipoErro))
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
