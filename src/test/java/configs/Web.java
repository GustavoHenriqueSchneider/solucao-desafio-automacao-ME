package configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
    public static final String AUTOMATE_USERNAME = "gustavohenriques_fQUhMo";
    public static final String AUTOMATE_ACCESS_KEY = "T1VCW3Bw5apYczhp7znV";
    public static final String URLTESTE = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

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

    public static WebDriver createBrowserStack(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "89.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
        WebDriver navegador = null;
        try {
            navegador = new RemoteWebDriver(new URL(URLTESTE), caps);
            //Configura o timeout
            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            //Acessa a pagina
            navegador.get("http://automationpractice.com/index.php");
        } catch (MalformedURLException e) {
            System.out.println("Houve o seguinte problema com a URL: " + e.getMessage());
        }
        //Retorna o navegador
        return navegador;
    }
}
