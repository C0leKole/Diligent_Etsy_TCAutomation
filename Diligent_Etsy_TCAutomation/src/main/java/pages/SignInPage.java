package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {
    WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getEmailInput() {
        return driver.findElement(By.id("join_neu_email_field"));
    }

    public WebElement getPasswordInput() {

        return driver.findElement(By.id("join_neu_password_field"));
    }

    public WebElement getSignInButton() {

        return driver.findElement(By.name("submit_attempt"));
    }

    public String getPasswordIsWrong() {
        String wrongPassMessage = driver.findElement(By.id("aria-join_neu_password_field-error")).getText();
        return wrongPassMessage;
    }

    public void waitForPasswordIsWrongMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("aria-join_neu_password_field-error")));
    }

}
