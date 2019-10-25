package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelaListagemForcadeTrabalho {

    private WebDriver navegador;


    public TelaListagemForcadeTrabalho(WebDriver navegador) {

        this.navegador = navegador;

    }

    public TelaListagemForcadeTrabalho ClicarMenuForcaTrabalho() {

        navegador.findElement(By.xpath("//html/body/app-root/app-header/mat-toolbar/div[1]/button/span")).click();

        return this;
    }


    public TelaListagemForcadeTrabalho ClicarForcaTrabalho() {

        navegador.findElement(By.xpath("//html/body/div[2]/div[2]/div/div/div/div[1]/a")).click();

        return this;
    }

    public TelaListagemForcadeTrabalho SelecionocampoUS() {

        navegador.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).click();

        return this;
    }

    public TelaListagemForcadeTrabalho SelecionoUS() {

        navegador.findElement(By.xpath("//html/body/div[2]/div/div/div/mat-option[2]/span/span")).click();

        return this;
    }

    public TelaCadastroForcadeTrabalho SelecionandoUS() {
        ClicarMenuForcaTrabalho();
        ClicarForcaTrabalho();
        SelecionocampoUS();
        SelecionoUS();

        return new TelaCadastroForcadeTrabalho(navegador);

    }

}