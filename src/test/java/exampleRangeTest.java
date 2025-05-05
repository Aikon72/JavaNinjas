import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class exampleRangeTest {
    public static void main(String[] args) {
        // Установка пути к драйверу (замените на ваш актуальный путь)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Создание экземпляра WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Переход на страницу
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            // Поиск элемента "example range" по id
            WebElement rangeElement = driver.findElement(By.id("my-range"));

            // Альтернативные способы поиска:
            // По имени:
            // WebElement rangeElement = driver.findElement(By.name("my-range"));
            // По CSS селектору:
            // WebElement rangeElement = driver.findElement(By.cssSelector("input[type='range']"));
            // По XPath:
            // WebElement rangeElement = driver.findElement(By.xpath("//input[@type='range']"));

            // Выполнение действий с элементом (например, установка значения)
            rangeElement.sendKeys("5"); // Установка значения 5

            // Проверка значения (опционально)
            String value = rangeElement.getAttribute("value");
            System.out.println("Current range value: " + value);

        } finally {
            // Закрытие браузера
            driver.quit();
        }
    }
}
