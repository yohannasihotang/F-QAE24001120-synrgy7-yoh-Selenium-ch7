import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest {

    @Test
    public void homepage() {
        // Mengatur driver Chrome menggunakan WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Membuat instance WebDriver
        WebDriver driver = new ChromeDriver();

        // Set browser fullscreen
        driver.manage().window().maximize();

        // Navigate to website
        driver.get("https://www.saucedemo.com/");

        System.out.println("title: " + driver.getTitle());
        System.out.println("current URL: " + driver.getCurrentUrl());

        // Assertion1 untuk title
        Assert.assertEquals(driver.getTitle(), "Swag Labs");

        // Assertion2 get current url
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        // End session
        driver.quit();
    }
}
