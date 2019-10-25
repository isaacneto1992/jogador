package Testes;
import Pages.Login;
import Pages.TelaCadastroForcadeTrabalho;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import suporte.web;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "TestesIsaac.csv")

public class CriarDiversasForcaTrabalhoTest {
    private WebDriver navegador;

    @Rule
    public TestName teste = new TestName();


    @Before
    public void setUp(){
        navegador = web.createFirefox();
        new Login(navegador)
                .LogandoCorsci("procergs","2734973081","1703431992neto")
                .SelecionandoUS();
    }
    @Test
    public void TestCriarumaForcaTrabalho(
            @Param(name="IncluirForcaTrabalho")String IncluirForcaTrabalho,
            @Param(name="IncluirVeiculo")String IncluirVeiculo,
            @Param(name="IncluirEquipamento")String IncluirEquipamento,
            @Param(name="IncluirSetor")String IncluirSetor,
            @Param(name="IncluirAgente")String IncluirAgente
    ){

        new TelaCadastroForcadeTrabalho(navegador)
        .CadastrandoForcadeTrabalho(IncluirForcaTrabalho,IncluirVeiculo,IncluirEquipamento,IncluirSetor,IncluirAgente);

   }

    @After
    public void tearDown(){
        navegador.quit();


    }

}

