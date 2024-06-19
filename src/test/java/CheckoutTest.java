import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CheckoutPage;

import java.time.Duration;

public class CheckoutTest {

    WebDriver driver;
    CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        // Login
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Initialize CheckoutPage
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void testCheckoutProcess() {
        // Add first item to the cart
        checkoutPage.addItemToCart("add-to-cart-sauce-labs-backpack");

        // Add second item to the cart
        checkoutPage.addItemToCart("add-to-cart-sauce-labs-bolt-t-shirt");

        // Go to the cart
        checkoutPage.goToCart();

        // Click checkout button
        checkoutPage.checkout();

        // Fill in checkout information
        checkoutPage.fillCheckoutInformation("Yohanna", "Sihotang", "12345");

        // Finish checkout
        checkoutPage.finishCheckout();

        // Verify success page
        checkoutPage.verifySuccessMessage();

        System.out.println("Thank you for your order!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
