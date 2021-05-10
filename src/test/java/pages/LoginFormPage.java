package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage {
    private WebDriver navegador;

    public LoginFormPage(WebDriver navegador){
        this.navegador=navegador;
    }

    public LoginFormPage digitarEmail(String email){
        navegador.findElement(By.id("center_column")).findElement(By.id("email")).sendKeys(email);
        //Retorna essa pagina
        return this;
    }

    public LoginFormPage digitarSenha(String senha){
        navegador.findElement(By.id("center_column")).findElement(By.id("passwd")).sendKeys(senha);
        //Retorna essa pagina
        return this;
    }

    public LoginSucessPage clicarSignIn(){
        //Clica no botão de entrar através do seu XPath "//button[@id="SubmitLogin"]"
        navegador.findElement(By.xpath("//button[@id=\"SubmitLogin\"]")).click();
        //Retorna a proxima pagina (pagina inicial)
        return new LoginSucessPage(navegador);
    }

    public LoginFormPage contaInvalida(){
        //Identifica o erro no elemento através do seu XPath "//div[@class="alert alert-danger"]" e
        //o atribui a String erro
        String erro = navegador.findElement(By.xpath("//div[@class=\"alert alert-danger\"]")).getText();
        //Valida se a mensagem de erro é igual a encontrada na tentativa de entrar com uma conta invalida/incorreta
        Assert.assertEquals("There is 1 error\nAuthentication failed.", erro);
        return this;
    }

    public LoginFormPage faltaDeCampo(String tipoErro){
        //Identifica o erro no elemento através do seu XPath "//div[@class="alert alert-danger"]" e
        //o atribui a String erro
        String erro = navegador.findElement(By.xpath("//div[@class=\"alert alert-danger\"]")).getText();
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
        return this;
    }

    public LoginSucessPage fazerLogin(String email, String senha){
        digitarEmail(email);
        digitarSenha(senha);
        clicarSignIn();

        return new LoginSucessPage(navegador);
    }

    public LoginFormPage fazerLoginIncorreto(String email, String senha){
        digitarEmail(email);
        digitarSenha(senha);
        clicarSignIn();

        return this;
    }
}
