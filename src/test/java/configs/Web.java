package configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome(){
        //Metodo cria instancia do navegador
        //Configura o driver para utilizar o navegador para testes automatizados
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //Abre o navegador e configura o timeout
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Expande a janela do navegador
        navegador.manage().window().maximize();
        //Acessa a pagina
        navegador.get("http://automationpractice.com/index.php");
        //Retorna o navegador
        return navegador;
    }
}
