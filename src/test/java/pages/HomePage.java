package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage clicarSignIn(){
        //Clicar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();
        return new LoginFormPage(navegador);
    }
}
