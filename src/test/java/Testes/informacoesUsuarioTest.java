package Testes;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;
import suporte.web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTest.csv")
public class informacoesUsuarioTest {
    private WebDriver navegador;

    @Rule
    public TestName teste = new TestName();

    @Before
        public void setup(){
        navegador = web.createFirefox();

        //clicar no link que possui texto 'sign in'
        navegador.findElement(By.linkText("Sign in")).click();
        String screenshot2 = "C:\\Users\\Isaac Pogorelsky Net\\Drivers\\imagem\\" + Generator.datahoraparaarquivo()+teste.getMethodName()+ ".png";
        Screenshot.tirar(navegador,screenshot2);

        //Identificando o formulario de login
        WebElement formulario = navegador.findElement(By.id("signinbox"));

        //digitar no campo com  name login que esta dentro do formulario de id 'signinbox' o texto 'julio0001'
        formulario.findElement(By.name("login")).sendKeys("julio0001");

        //digitar no campo com name password que esta dentro do formulario de id 'signinbox' o texto '123456'
        formulario.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com texto SIGN IN
        formulario.findElement(By.linkText("SIGN IN")).click();

        //clicar em um link que possui a class me
        navegador.findElement(By.linkText("Hi, Julio")).click();

        //clicar em link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

    }
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo,@Param(name = "contato")String contato,@Param(name = "mensagem")String mensagemesperada){

        //clicar botão atraves do xpath //button[@data-target="addmoredata"]
       navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //identifcar a popup que esta formulario de id=addmoredata
        WebElement idmoredata = navegador.findElement(By.id("addmoredata"));

        // Na combo de nome type escolher uma opcao phone
        WebElement campoType = idmoredata.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        //No campo de name de contact colocar telefone
        idmoredata.findElement(By.name("contact")).sendKeys(contato);

        //No link de text "Save" que esta na popup
        idmoredata.findElement(By.linkText("SAVE")).click();

        //na mensagem de ID 'TOAST CONTAINER' VALIDAR OTEXTO ' YOUR CONTACT

        WebElement Mensagem = navegador.findElement(By.id("toast-container"));
        String mensagem = Mensagem.getText();
        assertEquals(mensagemesperada,mensagem);

    }
    @Test
    public void removerContatoUsuario() {
        //clicar no elemmento pelo xpath //span[text()="5551995166700"]/following-sibling
        navegador.findElement(By.xpath("//span[text()=\"5551995166700\"]/following-sibling::a")).click();

        //confirmar na janela javascripts
        navegador.switchTo().alert().accept();

        //Validar que a mensagem apresentada foi Rest in peace, dear phone!

        WebElement Mensagem = navegador.findElement(By.id("toast-container"));
        String mensagem = Mensagem.getText();
        assertEquals("Rest in peace, dear phone!",mensagem);

        String screenshot = "C:\\Users\\Isaac Pogorelsky Net\\Drivers\\imagem\\" + Generator.datahoraparaarquivo()+teste.getMethodName()+ ".png";
        Screenshot.tirar(navegador,screenshot);

        //Queremos aguardar até 10 s para a tela desapareça
        WebDriverWait aguardar = new WebDriverWait(navegador,10);
        aguardar.until(ExpectedConditions.stalenessOf(Mensagem));


        //Clicar mo link com texto Logout
        navegador.findElement(By.linkText("Logout")).click();
    }


    @After
    public void teardown(){
        //Fechar o navegador
        navegador.quit();


    }
}
