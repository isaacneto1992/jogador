package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class web {
    public static WebDriver createFirefox() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\isaac.neto\\drivers\\geckodriver.exe");
        WebDriver navegador = new FirefoxDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        navegador.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);


        //Navegando por site
        navegador.get("http://jboss7.des.intra.rs.gov.br:24980/corsci-dos-web-gestao/");


        return navegador;
    }
}
