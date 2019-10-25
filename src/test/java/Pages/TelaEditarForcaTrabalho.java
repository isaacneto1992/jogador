package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class TelaEditarForcaTrabalho {

    private WebDriver navegador;

    public TelaEditarForcaTrabalho(WebDriver navegador){

        this.navegador = navegador;

    }

      public TelaEditarForcaTrabalho ClicarBotaoEditar(String EditarForca) {

          try {
              Thread.sleep(150);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          WebElement Editar= navegador.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
          Editar.sendKeys(EditarForca);
          Editar.sendKeys(Keys.ENTER);

          navegador.findElement(By.xpath("//html/body/app-root/app-forca-trabalho-lista/mat-card/mat-card/app-tabela-forca-trabalho/mat-table/mat-row/mat-cell[8]/a/span/mat-icon\n")).click();
                                        //html/body/app-root/app-forca-trabalho-lista/mat-card/mat-card/app-tabela-forca-trabalho/mat-table/mat-row[6]/mat-cell[8]/a

        return this;
    }

    public TelaEditarForcaTrabalho TelaeditarClicarSelecaoVeiculo(String AlterarVeiculo) {

        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement input=navegador.findElement(By.xpath("//*[@id=\"mat-input-3\"]"));
        input.click();
        input.sendKeys(AlterarVeiculo); //Set the value in the element
        input.sendKeys(Keys.ENTER);

        return this;

    }


    public TelaEditarForcaTrabalho SelecaoEquipamento(String AlterarEquipamento) {

        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement input=navegador.findElement(By.xpath("//*[@id=\"mat-input-4\"]"));
        input.click();
        input.sendKeys(AlterarEquipamento); //Set the value in the element
        input.sendKeys(Keys.ENTER);

        return this;

    }

    public TelaEditarForcaTrabalho AlterarForcaTrabalho() {

        navegador.findElement(By.xpath("//html/body/app-root/app-forca-trabalho-edicao/mat-card/app-forca-trabalho-edicao-menu/div/button[1]")).click();
        WebElement Mensagemelementos = navegador.findElement(By.xpath("//html/body/div[2]/div/div/snack-bar-container"));
        String mensagemguarda = Mensagemelementos.getText();
        assertEquals("Força de trabalho alterada com sucesso!\n" +
                "OK",mensagemguarda);

        return this;


    }
    public TelaEditarForcaTrabalho VoltarParaListagemForcaTrabalho() {

        WebElement Mensagemelementos = navegador.findElement(By.xpath("//html/body/app-root/app-forca-trabalho-lista/mat-card/h1"));
        String mensagemguardadas = Mensagemelementos.getText();
        assertEquals("Forças de Trabalho",mensagemguardadas);

        return this;


    }

    public TelaEditarForcaTrabalho AlterandoForcaTrabalho(String EditarForca,String AlterarVeiculo,String AlterarEquipamento ) {
        ClicarBotaoEditar(EditarForca);
        TelaeditarClicarSelecaoVeiculo(AlterarVeiculo);
        SelecaoEquipamento(AlterarEquipamento);
        AlterarForcaTrabalho();
        VoltarParaListagemForcaTrabalho();

        return this;

    }




}
