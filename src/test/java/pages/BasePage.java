package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver navegador;

    public BasePage (WebDriver navegador){
        this.navegador=navegador;
    }

    public String conferirNome(){
        //Retorna o nome completo do usuario através do elemento de class "account"
        return navegador.findElement(By.className("account")).getText();
    }

    public String mensagemErroLogin(){
        //Identifica o erro no elemento através do seu XPath "//div[@class="alert alert-danger"]" e o retorna
        return navegador.findElement(By.xpath("//div[@class=\"alert alert-danger\"]")).getText();
    }

    public String mensagemErroCadastro(){
        //Identifica o erro no elemento através do xpath "//div[@id="create_account_error"]/ol/li" e o retorna
        return navegador.findElement(By.xpath("//div[@id=\"create_account_error\"]/ol/li")).getText();
    }
}
