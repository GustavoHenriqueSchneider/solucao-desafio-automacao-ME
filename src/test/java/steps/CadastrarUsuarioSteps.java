package steps;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static steps.AcessarUsuarioSteps.formularios;
import static steps.AcessarUsuarioSteps.navegador;

public class CadastrarUsuarioSteps {
    private String diaData,mesData;

    @Quando("^informo o email \"(.*)\" no formulario cadastrar$")
    public void informoOEmailNoFormularioCadastrar(String email) {
        //Atribui o elemtento formulario de login através do id "center_column" a formularioLogin
        formularios = navegador.findElement(By.id("center_column"));
        //Informa o email no campo de id "email_create"
        formularios.findElement(By.id("email_create")).sendKeys(email);
    }

    @Quando("clico em registrar")
    public void clicoEmRegistrar() {
        //Clica em um botão (para registrar) através do seu XPath "//button[@id="SubmitCreate"]"
        navegador.findElement(By.xpath("//button[@id=\"SubmitCreate\"]")).click();
    }

    @Então("^visualizo o erro de criação de conta ([a-z\\s]+)$")
    public void visualizoOErroDeCriaçãoDeConta(String tipoErro) {
        //Identifica o erro no elemento através do xpath "//div[@id="create_account_error"]/ol/li" e o atribui a String erro
        String erro = navegador.findElement(By.xpath("//div[@id=\"create_account_error\"]/ol/li")).getText();
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

    @Quando("^escolho o gênero \"([MF])\"$")
    public void escolhoOGênero(String genero) {
        //Seleciona o genero
        if("M".equals(genero))
            //Seleciona o genero masculino clicando no elemento de id "id_gender1"
            navegador.findElement(By.id("id_gender1")).click();
        else if("F".equals(genero))
            //Seleciona o genero feminino clicando no elemento de id "id_gender2"
            navegador.findElement(By.id("id_gender2")).click();
    }

    @Quando("^informo o nome \"([a-zA-Z]+)\" e sobrenome \"([a-zA-Z]+)\"$")
    public void informoONomeESobrenomeE(String nome, String sobrenome) {
        //Digita o nome no campo de id "customer_firstname"
        navegador.findElement(By.id("customer_firstname")).sendKeys(nome);
        //Digitar o sobrenome no campo de id "customer_firstname"
        navegador.findElement(By.id("customer_lastname")).sendKeys(sobrenome);
    }

    @Quando("^informo a senha \"(.*{5,})\"$")
    public void informoASenha(String senha) {
        //Digita a senha no campo de id "passwd"
        navegador.findElement(By.id("passwd")).sendKeys(senha);
    }

    @Quando("^informo a data de nascimento (\\d{2})/(\\d{2})/(\\d{4})$")
    public void informoADataDeNascimento(int dia, int mes, String ano) {
        //Se o dia começar com "0" (exemplo: dia "03"), irá remover o "0" deixando somente o "3" para pesquisa por valor
        if("0".equals(String.valueOf(dia).substring(0,0)))
            diaData = String.valueOf(dia).substring(1);
        else
            diaData = String.valueOf(dia);
        //No combobox de id "days" escolhe a opção de valor diaData (que será o dia "03" no caso de "3")
        WebElement dias = navegador.findElement(By.id("days"));
        new Select(dias).selectByValue(String.valueOf(diaData));
        //Se o mes começar com "0" (exemplo: mes "03"), irá remover o "0" deixando somente o "3" para pesquisa por valor
        if("0".equals(String.valueOf(mes).substring(0,0)))
            mesData = String.valueOf(mes).substring(1);
        else
            mesData = String.valueOf(mes);
        //No combobox de id "months" escolhe a opção de valor mesData (que será o mês "March" no caso de "3")
        WebElement meses = navegador.findElement(By.id("months"));
        new Select(meses).selectByValue(mesData);
        //No combobox de id "years" escolhe a opção de valor anoData
        WebElement anos = navegador.findElement(By.id("years"));
        new Select(anos).selectByValue(ano);
    }

    @Quando("^informo o endereço \"([a-zA-Z,.\\d\\s]+)\"$")
    public void informoOEndereço(String endereco) {
        //Digita o endereço no campo de id "address1"
        navegador.findElement(By.id("address1")).sendKeys(endereco);
    }

    @Quando("^informo a cidade \"([a-zA-Z\\s]+)\"$")
    public void informoACidade(String cidade) {
        //Digita a cidade no campo de id "city"
        navegador.findElement(By.id("city")).sendKeys(cidade);
    }

    @Quando("^seleciono o estado \"([a-zA-Z\\s]+)\"$")
    public void selecionoOEstado(String estadoUsuario) {
        //No combobox de id "id_state" escolher a opção que contenha o texto "Hawaii"
        WebElement estado = navegador.findElement(By.id("id_state"));
        new Select(estado).selectByVisibleText(estadoUsuario);
    }

    @Quando("^informo o CEP \"(\\d{5})\"$")
    public void informoOCEP(String cep) {
        //Digita um CEP americano no campo de id "postcode"
        navegador.findElement(By.id("postcode")).sendKeys(cep);
    }

    @Quando("^informo o telefone \"([+]?\\d{8,})\"$")
    public void informoOTelefone(String telefone) {
        //Digita o telefone no campo de id "phone_mobile"
        navegador.findElement(By.id("phone_mobile")).sendKeys(telefone);
    }

    @Quando("clico no botão registrar")
    public void clicoNoBotãoRegistrar() {
        //Clica em um botão através do seu XPath "//button[@id="submitAccount"]"
        navegador.findElement(By.xpath("//button[@id=\"submitAccount\"]")).click();
    }
}
