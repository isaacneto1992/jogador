package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Login {
    private WebDriver navegador;


    public Login(WebDriver navegador) {
        this.navegador = navegador;

    }

    public Login Organizacao(String Organizacao) {
        navegador.findElement(By.xpath("//*[@id=\"organizacao\"]")).sendKeys(Organizacao);

        return this;
    }

    public Login Matricula(String Matricula) {
        navegador.findElement(By.xpath("//*[@id=\"matricula\"]")).sendKeys(Matricula);

        return this;
    }

    public Login Senha(String Senha) {
        navegador.findElement(By.xpath("//*[@id=\"senha\"]")).sendKeys(Senha);

        return this;

    }

    public Login ClicarLogar() {
        navegador.findElement(By.xpath("//*[@id=\"logonOrganizacao\"]")).click();

        return this;

    }

    public TelaListagemForcadeTrabalho LogandoCorsci(String Organizacao, String Matricula, String Senha) {
        Organizacao(Organizacao);
        Matricula(Matricula);
        Senha(Senha);
        ClicarLogar();

        return new TelaListagemForcadeTrabalho(navegador);
    }


}