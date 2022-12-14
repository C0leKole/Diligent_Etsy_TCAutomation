package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class SignInTest extends BasicTest{

    @Test(priority = 10)
    public void signInwithInvalidPassword() {
    signInPage.getSignInButton().click();
    signInPage.getEmailInput().sendKeys("nikola.ilic12358@gmail.com");
    Random random = new Random();

    int randomPass = random.nextInt(100000 - 50000);

        System.out.println("Random number was " + randomPass);

    signInPage.getPasswordInput().sendKeys("" + randomPass + "");
    signInPage.getSubmitButton().click();
    signInPage.waitForPasswordIsWrongMessage();

    Assert.assertTrue(signInPage.getPasswordIsWrong().contains("Password was incorrect"), "Pop up message" +
            "doesn't show 'Password was incorrect'");

    }
}
