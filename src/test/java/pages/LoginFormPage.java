package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage{
    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage digitarEmailLogin(String email){
        //Informa o email no campo de id "email"
        navegador.findElement(By.id("center_column")).findElement(By.id("email")).sendKeys(email);
        //Retorna essa pagina
        return this;
    }

    public LoginFormPage digitarSenhaLogin(String senha){
        //Informa a senha no campo de id "passwd"
        navegador.findElement(By.id("center_column")).findElement(By.id("passwd")).sendKeys(senha);
        //Retorna essa pagina
        return this;
    }

    public SucessPage clicarSignIn(){
        //Clica no botão de entrar através do seu XPath "//button[@id="SubmitLogin"]"
        navegador.findElement(By.xpath("//button[@id=\"SubmitLogin\"]")).click();
        //Retorna a proxima pagina (pagina inicial)
        return new SucessPage(navegador);
    }

    public SucessPage fazerLogin(String email, String senha){
        digitarEmailLogin(email);
        digitarSenhaLogin(senha);
        return clicarSignIn();
    }

    public LoginFormPage fazerLoginIncorreto(String email, String senha){
        digitarEmailLogin(email);
        digitarSenhaLogin(senha);
        clicarSignIn();
        return this;
    }

    public LoginFormPage digitarEmailCadastro(String email){
        //Informa o email no campo de id "email_create"
        navegador.findElement(By.id("center_column")).findElement(By.id("email_create")).sendKeys(email);
        return this;
    }

    public RegisterFormPage clicarCreateAccount(){
        //Clica em um botão (para registrar) através do seu XPath "//button[@id="SubmitCreate"]"
        navegador.findElement(By.xpath("//button[@id=\"SubmitCreate\"]")).click();
        return new RegisterFormPage(navegador);
    }

    public RegisterFormPage cadastrarConta(String email){
        digitarEmailCadastro(email);
        return clicarCreateAccount();
    }
}
