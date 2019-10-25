package Testes;

import Pages.Login;
import Pages.TelaCadastroForcadeTrabalho;
import Pages.TelaEditarForcaTrabalho;
import Pages.TelaListagemForcadeTrabalho;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import suporte.web;

public class EditarForcaTrabalhoTest {

    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = web.createFirefox();
        new Login(navegador)
                .LogandoCorsci("procergs","2734973081","1703431992neto")
                .SelecionandoUS();
    }
    @Test
    public void TestEditarumaForcaTrabalho(){
        new TelaEditarForcaTrabalho(navegador)
           .AlterandoForcaTrabalho("Teste 123","2 - EDT3453 - Outros - Outros","10 - edit");



    }

    @After
    public void tearDown(){
        //navegador.quit();

    }

}


