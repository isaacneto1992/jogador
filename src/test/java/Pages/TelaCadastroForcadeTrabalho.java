package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class TelaCadastroForcadeTrabalho {

    private WebDriver navegador;

    public TelaCadastroForcadeTrabalho(WebDriver navegador) {

        this.navegador = navegador;

    }

    public TelaCadastroForcadeTrabalho NovaForcaTrabalho() {

        navegador.findElement(By.xpath("//html/body/app-root/app-forca-trabalho-lista/mat-card/mat-card/div/div/a/button")).click();

        return this;

    }

    public TelaCadastroForcadeTrabalho DescricaoForcaTrabalho(String DescricaoForcaTrabalho) {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        navegador.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).sendKeys(DescricaoForcaTrabalho);

        return this;

    }

    public TelaCadastroForcadeTrabalho SelecaoVeiculo(String Veiculo) {

        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement input=navegador.findElement(By.xpath("//*[@id=\"mat-input-4\"]"));
        input.click();
        input.sendKeys(Veiculo);
        input.sendKeys(Keys.ENTER);

        return this;

    }

    public TelaCadastroForcadeTrabalho SelecaoEquipamento(String Equipamento) {

        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement input=navegador.findElement(By.xpath("//*[@id=\"mat-input-5\"]"));
        input.click();
        input.sendKeys(Equipamento); //Set the value in the element
        input.sendKeys(Keys.ENTER);

        return this;

    }


    public TelaCadastroForcadeTrabalho SelecaoSetor(String Setor) {

        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement input=navegador.findElement(By.xpath("//*[@id=\"mat-input-3\"]"));
        input.click();
        input.sendKeys(Setor); //Set the value in the element
        input.sendKeys(Keys.ENTER);
        navegador.findElement(By.xpath("//html/body/app-root/app-forca-trabalho-edicao/mat-card/app-forca-trabalho-edicao-form/form/mat-card[2]/app-setores-execucao-form/div/button")).click();

        return this;

    }


    public TelaCadastroForcadeTrabalho SelecaoAgente(String Agente) {

        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement input=navegador.findElement(By.xpath("//*[@id=\"mat-input-6\"]"));
        input.click();
        input.sendKeys(Agente); //Set the value in the element
        input.sendKeys(Keys.ENTER);
        navegador.findElement(By.xpath("//html/body/app-root/app-forca-trabalho-edicao/mat-card/app-forca-trabalho-edicao-form/form/mat-card[3]/app-agentes-form/div/button")).click();

        return this;

    }

    public TelaCadastroForcadeTrabalho SalvarForcaTrabalho() {

        navegador.findElement(By.xpath("//html/body/app-root/app-forca-trabalho-edicao/mat-card/app-forca-trabalho-edicao-menu/div/button[1]")).click();
        WebElement Mensagemelemento = navegador.findElement(By.xpath("//html/body/div[2]/div[1]"));
        String mensagemguardada = Mensagemelemento.getText();
        assertEquals("Força de trabalho incluída com sucesso!\n" +
                "OK",mensagemguardada);

        return this;


    }

    public TelaCadastroForcadeTrabalho VoltarpraListagem() {

        WebElement Mensagemelementos = navegador.findElement(By.xpath("//html/body/app-root/app-forca-trabalho-lista/mat-card/h1"));
        String mensagemguardadas = Mensagemelementos.getText();
        assertEquals("Forças de Trabalho",mensagemguardadas);

        return this;


    }

    public TelaListagemForcadeTrabalho CadastrandoForcadeTrabalho
            (String IncluirForcaTrabalho, String IncluirVeiculo, String IncluirEquipamento,String IncluirSetor,String IncluirAgente) {

                NovaForcaTrabalho();
                DescricaoForcaTrabalho(IncluirForcaTrabalho);
                SelecaoVeiculo(IncluirVeiculo);
                SelecaoEquipamento(IncluirEquipamento);
                SelecaoSetor(IncluirSetor);
                SelecaoAgente(IncluirAgente);
                SalvarForcaTrabalho();
                VoltarpraListagem();


        return new TelaListagemForcadeTrabalho(navegador);

    }


}

