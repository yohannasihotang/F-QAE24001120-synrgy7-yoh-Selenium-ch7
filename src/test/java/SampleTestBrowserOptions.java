import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTestBrowserOptions {

    @Test
    public void homepage() {
        //Setup browseroptions menggunakan chrome
        ChromeOptions options = new ChromeOptions();

        //Set headless mode
//      //options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();

        //set browser size
        options.addArguments("window-size=1000,850");
        //set browser incognito mode
        options.addArguments("--incognito");

        //kirim setup options ke parameter chtome driver
        WebDriver driver = new ChromeDriver(options);
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
