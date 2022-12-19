package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSaveForLaterButton() {
        return driver.findElement(By.xpath("//a[contains(@rel, 'save-for-later')]"));
    }

    public WebElement getMoveToFavoritesButton() {
        return driver.findElement(By.xpath("//button[contains(@data-selector, 'move-to-favorites')]"));
    }

    public WebElement getRemoveButton() {
        return driver.findElement(By.xpath("//a[1][contains(@rel, 'remove')]"));
    }
}
