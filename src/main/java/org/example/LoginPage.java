package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    // Login page variables
    private final By EMAIL_FIELD = By.id("identifierId");
    private final By NEXT_BUTTON_EMAIL = By.id("identifierNext");
    private final By PASSWORD_FIELD = By.name("Passwd");
    private final By NEXT_BUTTON_PASSWORD = By.id("passwordNext");

    // Settings page variables
    private final By NOTIFICATIONS = By.xpath("//*[@href='/account_notifications']");
    private final By SUBSCRIPTIONS_TOGGLE = By.xpath("//*[@id = 'toggle'][@aria-label='Subscriptions']");
    private final By RECOMMENDED_VIDEOS_TOGGLE = By.xpath("//*[@id = 'toggle'][@aria-label='Recommended videos']");
    private final By ACTIVITY_TOGGLE = By.xpath("//*[@id = 'toggle'][@aria-label='Activity on my channel']");
    private final By REPLIES_TOGGLE = By.xpath("//*[@id = 'toggle'][@aria-label='Replies to my comments']");
    private final By MENTIONS_TOGGLE = By.xpath("//*[@id = 'toggle'][@aria-label='Mentions']");
    private final By SHARED_CONTENT_TOGGLE = By.xpath("//*[@id = 'toggle'][@aria-label='Shared content']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void emailFill(String email){
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    public void emailNextButtonClick(){
        driver.findElement(NEXT_BUTTON_EMAIL).click();
    }

    public void passwordFill(String password){
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void passwordNextButtonClick(){
        driver.findElement(NEXT_BUTTON_PASSWORD).click();
    }

    // Settings page navigation
    public By getNotifications(){
        return NOTIFICATIONS;
    }

    public By getSubscriptionToggle(){
        return SUBSCRIPTIONS_TOGGLE;
    }

    public By getRecommendedToggle(){
        return RECOMMENDED_VIDEOS_TOGGLE;
    }

    public By getActivityToggle(){
        return ACTIVITY_TOGGLE;
    }

    public By getRepliesToggle(){
        return REPLIES_TOGGLE;
    }

    public By getMentionsToggle(){
        return MENTIONS_TOGGLE;
    }

    public By getSharedContentToggle(){
        return SHARED_CONTENT_TOGGLE;
    }

    // Method for logging in
    public void logIn(String email, String password){
        LandingPage landingPage = new LandingPage(driver);

        try{
        landingPage.signInClick();
        }catch(NoSuchElementException e){
            landingPage.signInSecondaryClick();
        }
        emailFill(email);
        emailNextButtonClick();

        WebElement passwordFieldWait = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD));
        passwordFill(password);
        passwordNextButtonClick();
    }
}