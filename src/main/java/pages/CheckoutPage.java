package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By firstItemLocator = By.id("add-to-cart-sauce-labs-backpack");
    private By secondItemLocator = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By cartButtonLocator = By.className("shopping_cart_link");
    private By checkoutButtonLocator = By.id("checkout");
    private By firstNameLocator = By.id("first-name");
    private By lastNameLocator = By.id("last-name");
    private By postalCodeLocator = By.id("postal-code");
    private By continueButtonLocator = By.id("continue");
    private By finishButtonLocator = By.id("finish");
    private By successMessageLocator = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addItemToCart(String itemId) {
        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(By.id(itemId)));
        item.click();
    }

    public void goToCart() {
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(cartButtonLocator));
        cartButton.click();
    }

    public void checkout() {
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(checkoutButtonLocator));
        checkoutButton.click();
    }

    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-step-one.html"));
        WebElement firstNameField = driver.findElement(firstNameLocator);
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = driver.findElement(lastNameLocator);
        lastNameField.sendKeys(lastName);
        WebElement postalCodeField = driver.findElement(postalCodeLocator);
        postalCodeField.sendKeys(postalCode);
        WebElement continueButton = driver.findElement(continueButtonLocator);
        continueButton.click();
    }

    public void finishCheckout() {
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-step-two.html"));
        WebElement finishButton = wait.until(ExpectedConditions.elementToBeClickable(finishButtonLocator));
        finishButton.click();
    }

    public void verifySuccessMessage() {
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-complete.html"));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
        Assert.assertEquals(successMessage.getText(), "Thank you for your order!");
    }
}
