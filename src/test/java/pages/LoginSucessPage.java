package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class LoginSucessPage {
    private WebDriver navegador;

    public LoginSucessPage(WebDriver navegador){
        this.navegador=navegador;
    }

    public LoginSucessPage conferirNome(String nome){
        //Valida o elemento de id "account" com o nome completo do usuario
        WebElement nomeUsuarioConta = navegador.findElement(By.className("account"));
        String nomeUsuarioSite = nomeUsuarioConta.getText();
        assertEquals(nome, nomeUsuarioSite);
        return this;
    }
}
