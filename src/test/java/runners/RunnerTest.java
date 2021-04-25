package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Definição, classe Runner será executada com JUnit
@RunWith(Cucumber.class)
//Configurações e customizações do Cucumber
@CucumberOptions(
        //Declaração do local da pasta que contem as classes com métodos para execução dos cenários
        glue = "steps",
        //Declaração do local que as features (funcionalidades e cenários) se encontra
        features = "src/test/resources/features",
        //Configuração para o terminal apresentar os testes (se passaram ou não) e inclusão de
        //geração de relatórios automáticos em HTML e JSON na pasta reports
        plugin = {"pretty","html:target/reports/relatorioHTML.html","json:target/reports/relatorioJSON.json"},
        //Configuração para o terminal indicar classes não criadas com CAMELCASE
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        //Realiza as funcionalides/cenarios com a tag @cadastro ou @login
        tags = "@cadastro or @login"
)

public class RunnerTest {
}
