package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {


    WebDriver driver;
    WebDriverWait wait;

    private final By skipAdButton = By.xpath("//button[contains(@class, 'ytp-ad-skip-button')]");
    private final By deleteSearchButton = By.xpath("//*[@id=\"search-clear-button\"]/ytd-button-renderer/yt-button-shape/button");
    private final By clickOnTheForInTheResultsList = By.xpath("//ytd-video-renderer[@class='style-scope ytd-item-section-renderer'][1]//a[@id='video-title']");
    private final By INPUT_SEARCH = By.xpath("//input[@id='search']");
    private final By BUTTON_3POINT_MENU_UNDER_VIDEO = By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[2]/ytd-watch-metadata/div/div[2]/div[2]/div/div/ytd-menu-renderer/yt-button-shape/button");
    private final By BUTTON_SAVE = By.xpath("//*[@id=\"items\"]/ytd-menu-service-item-renderer[2]/tp-yt-paper-item");
    private final By TEXT_VERIFY_VIDEO =  By.xpath("//*[@id=\"title\"]/h1/yt-formatted-string");
    private final By BUTTON_NEWLY_CREATE_PLAYLIST = By.xpath("//*[@id=\"actions\"]/ytd-add-to-playlist-create-renderer");
    private final By INPUT_NEW_PLAYLIST_NAME = By.xpath("//*[@id=\"input-1\"]/input");
    private final By BUTTON_CREATE_PLAYLIST = By.xpath("//*[@id=\"actions\"]/ytd-button-renderer/yt-button-shape/button");
    private final By TEXT_VERIFY_PLAYLIST_CREATED = By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-paper-dialog/ytd-add-to-playlist-renderer/div[2]/ytd-playlist-add-to-option-renderer[2]/tp-yt-paper-checkbox/div[2]/div/div/yt-formatted-string[1]");
    private final By BUTTON_CLOSE = By.xpath("//yt-icon-button[@id='close-button']");
    private final By BUTTON_DELETE_HISTORY = By.xpath("//*[@id=\"contents\"]/ytd-button-renderer[1]/yt-button-shape/button");
    private final By BUTTON_CONFIRM_DELETE_HISTORY = By.xpath("//*[@id=\"confirm-button\"]/yt-button-shape/button");
    private final By TEXT_VERIFY_ALL_DELETED_HISTORY = By.xpath("//*[@id=\"message\"]");
    private final By searchInputField = By.xpath("//input[@id='search']");
    private final By searchButton = By.xpath("//button[@id='search-icon-legacy']");

    //private final By clickOnTheForInTheResultsList = By.xpath("//ytd-video-renderer[@class='style-scope ytd-item-section-renderer'][1]//a[@id='video-title']");


    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }


    public void goToLink(String linkText) {
        driver.findElement(By.xpath("//*[@title='"+ linkText +"']")).click();
    }

    public void writeTextInSearchInput (String testdata) {
        driver.findElement(searchInputField).sendKeys(testdata);
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void clickOnTheFirstVideoInTheSearchedList() {
        driver.findElement(clickOnTheForInTheResultsList).click();
        wait.until(ExpectedConditions.urlContains("watch"));
        skipAdIfPresent();
    }

    //method for verify searched videoname
    public String verifyVideo() {
        WebElement videoName = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(TEXT_VERIFY_VIDEO));
        return driver.findElement(TEXT_VERIFY_VIDEO).getText();
    }


    //method for create new playlist
    public void performCreateNewPlaylist(String playlistName) {
        WebElement menuButtonWait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_3POINT_MENU_UNDER_VIDEO));
        driver.findElement(BUTTON_3POINT_MENU_UNDER_VIDEO).click();
        driver.findElement(BUTTON_SAVE).click();
        WebElement newPlaylistButtonWait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_NEWLY_CREATE_PLAYLIST));
        driver.findElement(BUTTON_NEWLY_CREATE_PLAYLIST).click();
        driver.findElement(INPUT_NEW_PLAYLIST_NAME).sendKeys(playlistName);
        driver.findElement(BUTTON_CREATE_PLAYLIST).click();

    }


    //method for verify newly created playlist
    public String verifyNewlyCreatedPlaylist() {
        WebElement menuButtonWait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_3POINT_MENU_UNDER_VIDEO));
        //driver.findElement(BUTTON_3POINT_MENU_UNDER_VIDEO).click();
        driver.findElement(BUTTON_SAVE).click();
        WebElement createdPlaylists = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_NEWLY_CREATE_PLAYLIST));
        return driver.findElement(TEXT_VERIFY_PLAYLIST_CREATED).getText();
    }


    //mothod for add a video to playlist
    public void performAddToPlaylist() {
        WebElement menuButtonWait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_3POINT_MENU_UNDER_VIDEO));
        //driver.findElement(BUTTON_3POINT_MENU_UNDER_VIDEO).click();
        driver.findElement(BUTTON_SAVE).click();
        WebElement createdPlaylists = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_NEWLY_CREATE_PLAYLIST));
        driver.findElement(TEXT_VERIFY_PLAYLIST_CREATED).click();
        driver.findElement(BUTTON_CLOSE).click();
    }



    //perform delete video from playlist
    public void performDeleteFromPlaylist() {
        WebElement menuButtonWait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_3POINT_MENU_UNDER_VIDEO));
        //driver.findElement(BUTTON_3POINT_MENU_UNDER_VIDEO).click();
        driver.findElement(BUTTON_SAVE).click();
        WebElement createdPlaylists = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_NEWLY_CREATE_PLAYLIST));
        driver.findElement(TEXT_VERIFY_PLAYLIST_CREATED).click();
        driver.findElement(BUTTON_CLOSE).click();
    }


    //method for delete history
    public void deleteHistory() {
        driver.findElement(BUTTON_DELETE_HISTORY).click();
        driver.findElement(BUTTON_CONFIRM_DELETE_HISTORY).click();

    }

    //method for verify delete history
    public String verifyAllDeletedHistory() {
        return driver.findElement(TEXT_VERIFY_ALL_DELETED_HISTORY).getText();
    }


    //method for ship ad function
    public void skipAdIfPresent() {
        try {
            WebElement skipButton = driver.findElement(skipAdButton);
            wait.until(ExpectedConditions.elementToBeClickable(skipButton)).click();
        } catch (NoSuchElementException e) {
            // Ha nincs skip gomb, akkor nem kell csinálni semmit
        } catch (TimeoutException e) {
            // Ha a skip gomb nem jelenik meg időben, akkor sem kell csinálni semmit
        }
    }


    //mothod for click on delete search input button
    public void clickOnDeleteSearchButton() {
        driver.findElement(deleteSearchButton).click();
    }


    public String whatIsWriteInTheSearchInput() {
        return driver.findElement(INPUT_SEARCH).getText();
    }

}








/*
    public void delete2() throws InterruptedException {
        WebElement menuButtonWait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_3POINT_MENU_UNDER_VIDEO));
        driver.findElement(BUTTON_3POINT_MENU_UNDER_VIDEO).click();
        driver.findElement(BUTTON_SAVE).click();
        WebElement multipleCheckboxWait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(multipleCheckbox));
        List<WebElement> checkboxes = driver.findElements(multipleCheckbox);
        new WebDriverWait(driver, 10).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(checkboxes)));
        for(WebElement checkbox : checkboxes) {
            boolean isSelected = checkbox.isSelected();
            System.out.println("Checkbox selected: " + isSelected);
            if(isSelected) {
                checkbox.click();
                Thread.sleep(1000); // Várakozás 1 másodpercig
                isSelected = checkbox.isSelected();
                System.out.println("Checkbox selected after click: " + isSelected);
            }
        }
        driver.findElement(BUTTON_CLOSE).click();
    }

 */
