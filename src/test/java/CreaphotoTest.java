import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class CreaphotoTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void testUnsuccessfulLogin() {
        driver.get("https://creaphoto.su");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div[4]/button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.tagName("input"))).sendKeys("Aikon");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"root\"]/main/div/div/form/div/div[4]/button"))).click();

        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/main/div/div/form/div/div[6]/div/span[2]"))).getText();
        assertEquals(value, "Псевдоним или пароль - не корректны");
    }
    @Test
    public void testAboutUs() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".p-menuitem-text"))).click();

        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.p-10.mb-10.bg-bright.pubtext.ck-content"))).getText();
        assertEquals(value, "О нас");
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
