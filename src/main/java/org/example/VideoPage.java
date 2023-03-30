package org.example;

import com.sun.jdi.ByteValue;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoPage {

    WebDriver driver;

    public VideoPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstElementTitle = By.xpath("//span[@class='yt-core-attributed-string' and contains(text(), 'Cabbage Boy - King Kong')]");

    //private final By simpleBoxPlaceHolder = By.id("simplebox-placeholder");
    //private final By simpleBoxPlaceHolder = By.xpath("//*[@id=\"simplebox-placeholder\"]");


    //private final By simpleBoxPlaceHolder = By.xpath("//*[@id=\"simplebox-input\" and @class=\"style-scope ytd-comments-simplebox-renderer\"]");
    //private final By simpleBoxPlaceHolder = By.id("placeholder-area");
    private final By simpleBoxPlaceHolder = By.xpath("//ytd-comment-simplebox-renderer/div[1]");



    private final By placeHolder = By.id("placeholder-area");
    //private final By commentField = By.id("contenteditable-root");
    private final By commentField = By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[1]/ytd-comments-header-renderer/div[5]/ytd-comment-simplebox-renderer/div[3]/ytd-comment-dialog-renderer/ytd-commentbox/div[2]/div/div[2]/tp-yt-paper-input-container/div[2]/div/div[1]/ytd-emoji-input/yt-user-mention-autosuggest-input/yt-formatted-string/div");
    private final By commentField2 = By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-renderer/div[4]/ytd-comment-dialog-renderer/ytd-commentbox/div[2]/div/div[2]/tp-yt-paper-input-container/div[2]/div/div[1]/ytd-emoji-input/yt-user-mention-autosuggest-input/yt-formatted-string/div");
    //private final By commentField = By.id("creation-box");
    //private final By commentField = By.id("contenteditable-textarea");
    //private final By commentField1 = By.xpath("//*[@id='input-container']/div[2]");
    //private final By commentField2 = By.xpath("//*[@id='input-container']/div[3]/div[2]");
    //private final By commentField2 = By.xpath("//*[@id=\"main\" and @class='style-scope ytd-commentbox']");

    private final By submitButton = By.id("submit-button");
    private final By submitButton2 = By.xpath("//ytd-comment-thread-renderer[1]/ytd-comment-renderer//ytd-comment-dialog-renderer/ytd-commentbox/div[2]/div/div[4]/div[5]/ytd-button-renderer[2]/yt-button-shape/button");

    //private final By LikeButton = By.xpath("//div[4]/div[1]/div//ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]");
    private final By LikeButton = By.xpath("//div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-renderer/div[3]/div[2]/ytd-comment-action-buttons-renderer/div[1]/ytd-toggle-button-renderer[1]/yt-button-shape/button/yt-touch-feedback-shape/div");

    private final By DislikeButton = By.xpath("//*[contains(text(), 'This is awesome')]/../../../..//*[@id='dislike-button']");

    //private final By ThreePointButton = By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-comments/ytd-item-section-renderer/div[3]/ytd-comment-thread-renderer[1]/ytd-comment-renderer/div[3]/div[3]/ytd-menu-renderer/yt-icon-button/button");

   private final By ThreePointButton = By.xpath("//ytd-comment-thread-renderer[1]/ytd-comment-renderer/div[3]/div[3]/ytd-menu-renderer/yt-icon-button/button");

    private final By EditCommentButton = By.xpath("//ytd-menu-navigation-item-renderer[1]/a/tp-yt-paper-item");

    private final By EditCommentField = By.xpath("//ytd-emoji-input/yt-user-mention-autosuggest-input/yt-formatted-string/div");
    //private final By DeleteButton = By.xpath("//ytd-menu-navigation-item-renderer[2]/a/tp-yt-paper-item");
    private final By DeleteButton = By.xpath("//ytd-popup-container/tp-yt-iron-dropdown/div/ytd-menu-popup-renderer/tp-yt-paper-listbox/ytd-menu-navigation-item-renderer[2]");

    private final By PlaylistButton = By.xpath("//span[@class='yt-core-attributed-string' and text()='TCS - Playlist']\n");

    public void ClickOnVideo () {
        driver.findElement(firstElementTitle).click();
    }

    public void Comment(String comment) throws InterruptedException {
        //try {
        //    driver.findElement(placeHolder).click();
        //}
        //catch (NoSuchElementException e) {
        //}
        //WebElement commentWait1 = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(simpleBoxPlaceHolder));
        Actions a = new Actions(driver);

        //scroll down a page
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        driver.findElement(simpleBoxPlaceHolder).click();
        //driver.findElement(placeHolder).click();
        driver.findElement(commentField).click();
        Thread.sleep(2000);
        driver.findElement(commentField).sendKeys(Keys.SPACE);
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(submitButton).click();
    }

    public void editComment(String comment) throws InterruptedException {
        //try {
        //    driver.findElement(placeHolder).click();
        //}
        //catch (NoSuchElementException e) {
        //}
        //WebElement commentWait1 = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(simpleBoxPlaceHolder));
        driver.findElement(ThreePointButton).click();
        Thread.sleep(2000);
        driver.findElement(EditCommentButton).click();
        Thread.sleep(4000);
        driver.findElement(commentField2).sendKeys(Keys.SPACE);
        driver.findElement(commentField2).sendKeys(comment);
        Thread.sleep(3000);
        driver.findElement(submitButton2).click();
    }


    public void LikeComment () {
        driver.findElement(LikeButton).click();
    }

    public void DislikeComment () {
        driver.findElement(DislikeButton).click();
    }

    public void DeleteComment () throws InterruptedException {
        //try {
        //    driver.findElement(placeHolder).click();
        //}
        //catch (NoSuchElementException e) {
        //}
        //WebElement commentWait1 = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(simpleBoxPlaceHolder));

        Thread.sleep(2000);
        driver.findElement(ThreePointButton).click();
        Thread.sleep(2000);
        driver.findElement(DeleteButton).click();
        Thread.sleep(2000);



    }

    public void OpenPlaylist () {
        driver.findElement(PlaylistButton).click();
    }
}
