package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SortItemsPage {
    private WebDriver driver;
    private By sortSelectLocator = By.className("product_sort_container");
    private By inventoryItemPriceLocator = By.className("inventory_item_price");

    public SortItemsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortItemsHighToLow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sortSelect = wait.until(ExpectedConditions.elementToBeClickable(sortSelectLocator));
        Select select = new Select(sortSelect);
        select.selectByValue("hilo");
        System.out.println("Sorting items from high to low.");
    }

    public List<Double> getItemPrices() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(inventoryItemPriceLocator));
        List<WebElement> priceElements = driver.findElements(inventoryItemPriceLocator);
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "");
            System.out.println("Price text: " + priceText);
            prices.add(Double.parseDouble(priceText));
        }
        return prices;
    }
}
