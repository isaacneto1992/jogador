package Testes;
import Pages.Login;
import Pages.TelaCadastroForcadeTrabalho;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import suporte.Generator;
import suporte.Screenshot;
import suporte.web;



public class CriarForcaTrabalhoCorsiTest {
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
    public void TestCriarumaForcaTrabalho(){
        new TelaCadastroForcadeTrabalho(navegador)
                .CadastrandoForcadeTrabalho("ISAACPASSOUPORAQUI",
                        "14 - LKK0988 - Honda - Caminhão Autovácuo",
                        "9 - Isaac123456",
                        "CADASTRO","Isaac");

    }

    @After
    public void tearDown(){
          String screenshot2 = "C:\\Users\\isaac.neto\\drivers\\Testando\\testes" + Generator.datahoraparaarquivo()+teste.getMethodName()+ ".png";
          Screenshot.tirar(navegador,screenshot2);
           //navegador.quit();


    }

}

