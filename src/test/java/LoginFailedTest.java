import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginFailedPage;

import java.time.Duration;

public class LoginFailedTest {

    WebDriver driver;
    LoginFailedPage loginPage; // Menggunakan LoginFailedPage sebagai objek

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginFailedPage(driver); // Menginisialisasi dengan LoginFailedPage
    }

    @Test
    public void testLoginFailed() {
        // Implicit wait (opsional, bisa dihapus jika tidak diperlukan)
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        // Input Username and Password
        loginPage.enterUsername("yoana");
        loginPage.enterPassword("yohanna123");

        // Explicit wait for login button to be clickable and then click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginButton()));
        loginPage.clickLoginButton();

        // Wait for the error message to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getErrorMessageLocator()));

        // Verify the error message
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        System.out.println("Error message: " + actualErrorMessage);

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
