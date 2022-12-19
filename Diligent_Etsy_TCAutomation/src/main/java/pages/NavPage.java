package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavPage {
    WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSignInButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'signin-header-action')]"));
    }

    public WebElement getSeachBar() {
        return driver.findElement(By.id("global-enhancements-search-query"));
    }

    public WebElement getProfileIcon() {
        return driver.findElement(By.className("wt-menu__trigger wt-btn wt-btn--transparent" +
                " wt-tooltip__trigger wt-btn--icon wt-pr-xs-1 wt-display-inline-flex-xs reduced-margin-xs"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.linkText("Sign out"));
    }


}
