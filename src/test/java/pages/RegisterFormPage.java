package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterFormPage extends BasePage{
    public RegisterFormPage(WebDriver navegador) {
        super(navegador);
    }

    public RegisterFormPage escolherGenero(String genero){
        //Seleciona o genero
        if("M".equals(genero))
            //Seleciona o genero masculino clicando no elemento de id "id_gender1"
            navegador.findElement(By.id("id_gender1")).click();
        else if("F".equals(genero))
            //Seleciona o genero feminino clicando no elemento de id "id_gender2"
            navegador.findElement(By.id("id_gender2")).click();
        return this;
    }

    public RegisterFormPage informarNomeCompleto(String nome, String sobrenome){
        //Digita o nome no campo de id "customer_firstname"
        navegador.findElement(By.id("customer_firstname")).sendKeys(nome);
        //Digitar o sobrenome no campo de id "customer_firstname"
        navegador.findElement(By.id("customer_lastname")).sendKeys(sobrenome);
        return this;
    }

    public RegisterFormPage informarSenha(String senha){
        //Digita a senha no campo de id "passwd"
        navegador.findElement(By.id("passwd")).sendKeys(senha);
        return this;
    }

    public RegisterFormPage informarDataNasc(int dia, int mes, String ano){
        String diaData, mesData;
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
        return this;
    }

    public RegisterFormPage informarEndereco(String endereco){
        //Digita o endereço no campo de id "address1"
        navegador.findElement(By.id("address1")).sendKeys(endereco);
        return this;
    }

    public RegisterFormPage informarCidade(String cidade){
        //Digita a cidade no campo de id "city"
        navegador.findElement(By.id("city")).sendKeys(cidade);
        return this;
    }

    public RegisterFormPage informarEstado(String estadoUsuario){
        //No combobox de id "id_state" escolher a opção que contenha o texto "Hawaii"
        WebElement estado = navegador.findElement(By.id("id_state"));
        new Select(estado).selectByVisibleText(estadoUsuario);
        return this;
    }

    public RegisterFormPage informarCEP(String cep){
        //Digita um CEP americano no campo de id "postcode"
        navegador.findElement(By.id("postcode")).sendKeys(String.valueOf(cep));
        return this;
    }

    public RegisterFormPage informarTelefone(String telefone){
        //Digita o telefone no campo de id "phone_mobile"
        navegador.findElement(By.id("phone_mobile")).sendKeys(telefone);
        return this;
    }

    public SucessPage clicarRegistrar(){
        //Clica em um botão através do seu XPath "//button[@id="submitAccount"]"
        navegador.findElement(By.xpath("//button[@id=\"submitAccount\"]")).click();
        return new SucessPage(navegador);
    }

    public SucessPage registrarUsuario(String genero, String nome, String sobrenome, String senha,
                                       int dia, int mes, String ano, String endereco, String cidade,
                                       String estado, String cep, String telefone){
        escolherGenero(genero);
        informarNomeCompleto(nome,sobrenome);
        informarSenha(senha);
        informarDataNasc(dia,mes,ano);
        informarEndereco(endereco);
        informarCidade(cidade);
        informarEstado(estado);
        informarCEP(cep);
        informarTelefone(telefone);
        return clicarRegistrar();
    }
}
