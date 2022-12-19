package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getArtAndCollectiblesTab() {
        return driver.findElement(By.xpath("//ul[contains(@role, 'menubar')]/li[6]/a"));
    }

    public void waitArtAndCollectiblesTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[contains(@role, 'menubar')]/li[6]/a")));
    }

    public WebElement getPrintsTextLink() {
        return driver.findElement(By.id("catnav-l3-119"));
    }

    public void waitPrintsTextLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("catnav-l3-119")));
    }

    public WebElement getMinCustomPriceValue() {
        return driver.findElement(By.id("search-filter-min-price-input"));
    }

    public WebElement getMaxCustomPriceValue() {
        return driver.findElement(By.id("search-filter-max-price-input"));
    }

    public WebElement getShopLocationSerbia() {
        return driver.findElement(By.id("shop-location-input-2"));
    }

    public WebElement getAnItemFromTheList(int index) {
        return driver.findElement(By.xpath("//ol[contains(@class, " +
                "'wt-grid wt-grid--block wt-pl-xs-0 tab-reorder-container')]/li[" + index + "]"));
    }

    public void waitAnItemFromTheList(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ol[contains(@class," +
                        "'wt-grid wt-grid--block wt-pl-xs-0 tab-reorder-container')]/li[" + index + "]")));

    }


    public WebElement getAddToCartButton() {
        return driver.findElement(By.xpath("//div[contains(@data-selector, 'add-to-cart-button')]/button"));
    }

    public void waitAddToCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@data-selector, 'add-to-cart-button')]/button")));
    }

    public WebElement getViewCartAndCheckOutButton() {
        return driver.findElement(By.partialLinkText("View cart & check out"));
    }


    public WebElement getAllFiltersButton() {
        return driver.findElement(By.id("search-filter-button"));
    }

    public WebElement getCustomPriceInput() {
        return driver.findElement(By.id("price-input-custom"));
    }

    public void waitCustomPriceInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("price-input-custom")));
    }


    public WebElement getApplyButton() {
        return driver.findElement(
                By.xpath("//button[@class='wt-btn wt-btn--primary wt-width-full" +
                        " wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3']"));
    }

    public void waitApplyButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[@class='wt-btn wt-btn--primary wt-width-full" +
                        " wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3']")));
    }


    public WebElement getSortByButton() {
        return driver.findElement(By.id("sortby"));
    }

    public WebElement getHighestPrice() {
        return driver.findElement(
                By.xpath("//div/a[3][contains(@type, 'button')]"));
    }

    public void waitForSortByButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("sortby")));
    }

    public void waitForHighestPriceButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div/a[3][contains(@type, 'button')]")));
    }

    public void waitForAllFilltersButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("search-filter-button")));

    }


}
