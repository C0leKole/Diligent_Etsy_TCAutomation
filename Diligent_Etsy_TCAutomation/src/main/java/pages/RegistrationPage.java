package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getRegisterButton () {
        return driver.findElement(By.xpath("//button[contains(@class, 'register-header-action')]"));
    }

    public WebElement getFirstNameInput () {
        return driver.findElement(By.id("join_neu_first_name_field"));
    }

    public WebElement getSubmitRegistrationButton () {
        return driver.findElement(By.xpath("//button[contains(@value, 'register')]"));
    }

    public void waitRegistrationPageElementsToBeClickable () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("join_neu_first_name_field")));


    }
}
