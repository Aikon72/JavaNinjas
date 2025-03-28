import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GroupJavaMastersTest {

    @Test
    public void testSearch() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.vpl.ca/");

        WebElement textBox = driver.findElement(By.name("keyword"));
        WebElement searchButton = driver.findElement(By.cssSelector("#edit-submit"));

        textBox.sendKeys("Java");
        searchButton.click();

        WebElement text = driver.findElement(By.className("search-query"));
        String value = text.getText();

        assertEquals(value, "Keyword search: Java");

        driver.quit();
    }
}