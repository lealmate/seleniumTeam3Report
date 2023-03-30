package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage{
    public LandingPage(WebDriver driver) {
        super(driver);
    }

    private final String URL = "https://www.youtube.com";
    private final By SIGN_IN = By.xpath("//*[@id=\"topbar\"]/div[2]/div[2]");
    private final By SIGN_IN_SECONDARY = By.xpath("//*[@id=\"buttons\"]/ytd-button-renderer");
    private final By USER_MENU = By.id("img");
    private final By SETTINGS = By.xpath("//*[@id=\"endpoint\"][@title='Settings']");
    private final By LOGOUT_BUTTON = By.xpath("//*[@id=\"items\"]/ytd-compact-link-renderer[4]");
    private final By SEARCH_FIELD = By.xpath("//input[@id=\"search\"]");
    private final By SEARCH_BUTTON = By.id("search-icon-legacy");
    private final By searchInputField = By.xpath("//input[@id='search']");
    private final By searchButton = By.xpath("//button[@id='search-icon-legacy']");
    private final By BUTTON_LIBRARY = By.xpath("//div/ytd-guide-collapsible-section-entry-renderer/div[1]/ytd-guide-entry-renderer");
    private final By BUTTON_VIEW_ALL = By.xpath("//*[@id=\"top-level-buttons-computed\"]/ytd-button-renderer/yt-button-shape/a");
    private final By BUTTON_LEFT_UP_MENU = By.xpath("//yt-icon-button[2]");
    private final By searchField = By.xpath("//*[@id=\"search\" and @type=\"text\"]");
    private final By firstOptionSubscribeButton = By.xpath("//ytd-subscribe-button-renderer/yt-button-shape/button");
    private final By SubscribedButton = By.xpath("//*[@id=\"notification-preference-button\"]/ytd-subscription-notification-toggle-button-renderer-next/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]");
    private final By UnsubscribeButton = By.xpath("//*[@id=\"items\"]/ytd-menu-service-item-renderer[4]");
    private final By ConfirmButton = By.id("confirm-button");





    // Getters for fixed variables
    public String getURL(){
        return URL;
    }

    public By getSignIn(){
        return SIGN_IN;
    }

    public By getSignInSecondary(){
        return SIGN_IN_SECONDARY;
    }

    public By getUserMenu(){
        return USER_MENU;
    }

    public By getLogOutButton(){
        return LOGOUT_BUTTON;
    }

    public By getSearchField(){
        return SEARCH_FIELD;
    }

    public By getSearchButton(){
        return SEARCH_BUTTON;
    }
    public By getSettings(){
        return SETTINGS;
    }

    // Methods for click-by-click navigation
    public void navigate(){
        driver.navigate().to(URL);
    }

    public void signInClick(){
        driver.findElement(SIGN_IN).click();
    }

    public void signInSecondaryClick(){
        driver.findElement(SIGN_IN_SECONDARY).click();
    }

    public void openUserMenu(){
        driver.findElement(USER_MENU).click();
    }
    public void openSettings(){
        driver.findElement(SETTINGS).click();
    }

    public void logOutClick(){
        driver.findElement(LOGOUT_BUTTON).click();
    }

    public void useSearch(String searchFor){
        driver.findElement(SEARCH_FIELD).sendKeys(searchFor);
    }

    public void searchButtonClick(){
        driver.findElement(SEARCH_BUTTON).click();
    }

    // Method for logging out
    public void logOut(){
        openUserMenu();
        WebElement logOutButtonWait = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_BUTTON));
        logOutClick();
    }


    //method for perform search
    public void performSearch(String wordToSearch) {
        WebElement searchInputFieldWait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(SEARCH_FIELD));
        driver.findElement(SEARCH_FIELD).sendKeys(wordToSearch);
        driver.findElement(SEARCH_BUTTON).click();
    }


    //method for go to playlist menu
    public void goToPlaylist() {
        WebElement leftUpMenuWait = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_LEFT_UP_MENU));
        driver.findElement(BUTTON_LEFT_UP_MENU).click();
        driver.findElement(BUTTON_LIBRARY).click();
        driver.findElement(BUTTON_VIEW_ALL).click();
    }

    public void SearchYouTube(String channel) {
        //driver.findElement(searchField).click();
        driver.findElement(searchField).sendKeys(channel);
        driver.findElement(searchButton).click();
        //driver.findElement(firstSearchDropDownOption).click();
    }

    public void SubscribeFirstOption () {

        driver.findElement(firstOptionSubscribeButton).click();
    }

    public void Unsubscribe () {
        driver.findElement(SubscribedButton).click();
        driver.findElement(UnsubscribeButton).click();
        driver.findElement(ConfirmButton).click();
    }

}
