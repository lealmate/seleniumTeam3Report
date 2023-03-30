import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class LoginTest extends BaseTest{

    @Test
    public void loginFunctionTest(){
        landingPage.navigate();
        loginPage.logIn("thotmad.strongarm@freemail.hu", "Thotmad.Strongarm123");

        wait.until(ExpectedConditions.elementToBeClickable(landingPage.getUserMenu()));
        landingPage.openUserMenu();
        wait.until(ExpectedConditions.elementToBeClickable(landingPage.getLogOutButton()));
        String expectedResult = "Thotmad Strongarm";
        // Checking if the name of the account logged in is matching
        String actualResult = driver.findElement(By.id("account-name")).getText();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void logOutTest(){
        landingPage.navigate();
        loginPage.logIn("thotmad.strongarm@freemail.hu", "Thotmad.Strongarm123");

        wait.until(ExpectedConditions.elementToBeClickable(landingPage.getUserMenu()));
        landingPage.openUserMenu();
        wait.until(ExpectedConditions.elementToBeClickable(landingPage.getLogOutButton()));
        landingPage.logOutClick();
        Assertions.assertTrue(driver.findElement(landingPage.getSignIn()).isDisplayed());
    }

    @Test
    public void logOutFunctionTest(){
        landingPage.navigate();
        loginPage.logIn("thotmad.strongarm@freemail.hu", "Thotmad.Strongarm123");

        wait.until(ExpectedConditions.elementToBeClickable(landingPage.getUserMenu()));
        landingPage.logOut();
        Assertions.assertTrue(driver.findElement(landingPage.getSignIn()).isDisplayed());
    }

    @Test
    public void accountSettingsTest(){
        landingPage.navigate();
        loginPage.logIn("thotmad.strongarm@freemail.hu", "Thotmad.Strongarm123");

        wait.until(ExpectedConditions.elementToBeClickable(landingPage.getSettings()));
        landingPage.openSettings();
        String expectedResult = "https://www.youtube.com/account";
        String actualResult = driver.getCurrentUrl();
        Assertions.assertEquals(expectedResult, actualResult);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loginPage.getNotifications())));
        driver.findElement(loginPage.getNotifications()).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getSharedContentToggle()));
        List<WebElement> toggles = driver.findElement(By.xpath("//*[@id = 'toggle'][@aria-label='Subscriptions']/../..")).findElements(By.id("toggle"));
        for(WebElement toggle : toggles){
            String before = toggle.getAttribute("aria-pressed");
            toggle.click();
            String after = toggle.getAttribute("aria-pressed");
            Assertions.assertNotSame(before, after);
        }
    }
}
