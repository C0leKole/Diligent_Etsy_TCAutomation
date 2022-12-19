package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Random;

public class EtsyTests extends BasicTest {

    @Test(priority = 10)
    //TC01

    public void userIsTryingToRegister() {

        navPage.getSignInButton().click();
        registrationPage.getRegisterButton().click();

        Random random = new Random();
        int randomNumber = random.nextInt(1000000 - 100000);

        registrationPage.waitRegistrationPageElementsToBeClickable();
        signInPage.getEmailInput().sendKeys("user9o0" + randomNumber + "@gmail.com");
        registrationPage.getFirstNameInput().sendKeys("Nikola" + randomNumber + "");
        signInPage.getPasswordInput().sendKeys("" + randomNumber + "");
        registrationPage.getSubmitRegistrationButton().isDisplayed();
        registrationPage.getSubmitRegistrationButton().click();

        System.out.println("Email used was user9o0" + randomNumber + "@gmail.com");
        System.out.println("Password used was " + randomNumber);

    }

    @Test(priority = 20)
    //TC03

    public void userIsTryingToSignInWithInvalidPassword() {

        navPage.getSignInButton().click();
        signInPage.getEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        Random random = new Random();

        int randomPass = random.nextInt(100000 - 50000);

        signInPage.getPasswordInput().sendKeys("" + randomPass + "");
        signInPage.getSignInButton().click();
        signInPage.waitForPasswordIsWrongMessage();

        Assert.assertTrue(signInPage.getPasswordIsWrong().contains("Password was incorrect"), "Pop up message" +
                "doesn't show 'Password was incorrect'");

    }

    @Test(priority = 30)
    //TC04

    public void searchForAnItemByUsingSearchBar() throws InterruptedException {

        navPage.getSeachBar().click();
        navPage.getSeachBar().sendKeys("sony a6400 case");
        navPage.getSeachBar().sendKeys(Keys.ENTER);
        searchPage.getAllFiltersButton().click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('price-input-3').click();");

        searchPage.waitApplyButton();
        searchPage.getApplyButton().click();
        Thread.sleep(2000);
        driver.navigate().refresh();
        searchPage.waitForSortByButton();
        searchPage.getSortByButton().click();

        searchPage.waitForHighestPriceButton();
        searchPage.getHighestPrice().click();


    }


    @Test(priority = 40)
    //TC05

    public void searchForAnItemFromDropDownMenus() throws InterruptedException {

        navPage.getSignInButton().click();
        signInPage.getEmailInput().sendKeys("nikola.ilic12358@gmail.com");
        signInPage.getPasswordInput().sendKeys("diligenttest123");
        signInPage.getSignInButton().click();

        Actions action = new Actions(driver);
        Thread.sleep(5000);
        driver.navigate().refresh();
        searchPage.waitArtAndCollectiblesTab();
        action.moveToElement(searchPage.getArtAndCollectiblesTab()).perform();


        searchPage.waitPrintsTextLink();
        action.moveToElement(searchPage.getPrintsTextLink()).perform();
        searchPage.getPrintsTextLink().click();
        searchPage.waitForAllFilltersButton();
        searchPage.getAllFiltersButton().click();
        searchPage.waitCustomPriceInput();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('price-input-custom').click();");

        searchPage.getMinCustomPriceValue().sendKeys("1");
        searchPage.getMaxCustomPriceValue().sendKeys("50");


        js.executeScript("arguments[0].scrollIntoView();", searchPage.getShopLocationSerbia());
        js.executeScript("document.getElementById('shop-location-input-2').click();");

        searchPage.waitApplyButton();
        searchPage.getApplyButton().click();
        searchPage.waitAnItemFromTheList(3);
        searchPage.getAnItemFromTheList(3).click();


        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));


        searchPage.waitAddToCartButton();
        searchPage.getAddToCartButton().click();


        searchPage.getViewCartAndCheckOutButton().click();
        cartPage.getSaveForLaterButton().click();

        js.executeScript("arguments[0].scrollIntoView();", cartPage.getMoveToFavoritesButton());

        Thread.sleep(2000);
        cartPage.getMoveToFavoritesButton().click();


    }


    @Test(priority = 50)
    //TC10

    public void userIsAddingItemToCartAndThenRemoving() throws InterruptedException {

        navPage.getSeachBar().sendKeys("sony a6400 case");
        navPage.getSeachBar().sendKeys(Keys.ENTER);
        searchPage.waitForAllFilltersButton();
        searchPage.getAllFiltersButton().click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('special-offers-free-shipping').click();");
        js.executeScript("document.getElementById('special-offers-on-sale').click();");
        js.executeScript("document.getElementById('special-offers-bestseller').click();");

        searchPage.waitApplyButton();
        searchPage.getApplyButton().click();
        searchPage.waitAnItemFromTheList(2);
        searchPage.getAnItemFromTheList(2).click();

        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(1));


        Select select = new Select(driver.findElement(By.id("variation-selector-0")));
        select.selectByIndex(2);

        Thread.sleep(2000);

        Select select2 = new Select(driver.findElement(By.id("variation-selector-1")));
        select2.selectByIndex(2);

        searchPage.waitAddToCartButton();
        searchPage.getAddToCartButton().click();

        cartPage.getRemoveButton().click();

    }


}
