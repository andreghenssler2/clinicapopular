import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class ConsultaSeleniumTest {

    @Test
    public void testAgendarConsultaComCpf() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");

        driver.findElement(By.id("nome")).sendKeys("Maria");
        driver.findElement(By.id("cpf")).sendKeys("456");
        driver.findElement(By.id("dataHora")).sendKeys("2025-07-01 14:00");
        driver.findElement(By.cssSelector("button")).click();

        String mensagem = driver.findElement(By.id("mensagem")).getText();
        assertTrue(mensagem.contains("Maria"));
        assertTrue(mensagem.contains("456"));

        driver.quit();
    }
}