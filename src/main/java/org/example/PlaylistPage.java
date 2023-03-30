package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaylistPage {

    WebDriver driver;

    private final By BUTTON_EDIT_MENU_IN_PLAYLIST = By.xpath("//ytd-playlist-header-renderer/div/div[2]/div[1]/div/div[1]/div[2]/ytd-menu-renderer/yt-button-shape");
    private final By BUTTON_LIBRARY = By.xpath("//div/ytd-guide-collapsible-section-entry-renderer/div[1]/ytd-guide-entry-renderer");
    private final By BUTTON_VIEW_ALL = By.xpath("//*[@id=\"top-level-buttons-computed\"]/ytd-button-renderer/yt-button-shape/a");
    private final By BUTTON_TEST_PLAYLIST = By.xpath("//*[@id=\"section-items\"]/ytd-guide-entry-renderer[3]");
    private final By BUTTON_LEFT_UP_MENU = By.xpath("//yt-icon-button[2]");
    private final By BUTTON_DELETE_PLAYLIST = By.xpath("//tp-yt-iron-dropdown/div/ytd-menu-popup-renderer/tp-yt-paper-listbox/ytd-menu-service-item-renderer[5]");
    private final By BUTTON_MAKE_ORDER_IN_PLAYLIST = By.xpath("//ytd-playlist-video-list-renderer/div[1]/yt-sort-filter-sub-menu-renderer/yt-dropdown-menu/tp-yt-paper-menu-button/div");
    private final By BUTTON_CONFIRM_DELETE = By.xpath("//*[@id=\"confirm-button\"]");
    private final By BUTTON_PLAY_ALL_VIDEO_FROM_PLAYLIST = By.xpath("//ytd-playlist-header-renderer/div/div[2]/div[1]/div/div[2]/ytd-button-renderer[1]");
    private final By TEXT_VERIFY_PLAYING_THE_PLAYLIST = By.xpath("//ytd-miniplayer/div[2]/div/ytd-playlist-panel-renderer/div/div[1]/div/div[1]/div[1]/h3[1]/yt-formatted-string");
    private final By BUTTON_3POINT_EDIT_BUTTON = By.xpath("//ytd-playlist-video-renderer[1]/div[3]/ytd-menu-renderer/yt-icon-button/button");
    private final By BUTTON_ADD_VIDEO_TO_PLAYLIST = By.xpath("//*[@id=\"items\"]/ytd-menu-service-item-renderer[1]");
    private final By INPUT_FOR_SEARCH_IN_PLAYLIST_ADD_SECTION = By.xpath("//*[@id=\"yDmH0d\"]/div[2]/div[2]/div/div/div[3]/div/div/div[2]/div[1]/input[2]");
    private final By BUTTON_VIDEO_ADD_TO_PLAYLIST_WHEN_SEARCH_FROM_PLAYLIST = By.xpath("//*[@id=\"yDmH0d\"]/div[2]/div[5]/div/div[3]/button/span");

    public PlaylistPage(WebDriver driver) {
        this.driver = driver;
    }


    //method for go to library
    public void goToLibrary() {
        WebElement leftUpMenuWait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_LEFT_UP_MENU));
        driver.findElement(BUTTON_LEFT_UP_MENU).click();
        driver.findElement(BUTTON_LIBRARY).click();
        driver.findElement(BUTTON_VIEW_ALL).click();
    }


    //method for go to playlist
    public void goToPlaylist() {
        WebElement leftUpMenuWait = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_LEFT_UP_MENU));
        driver.findElement(BUTTON_LEFT_UP_MENU).click();
        driver.findElement(BUTTON_TEST_PLAYLIST).click();
    }



    public void makeOrderInPlaylist() {
        driver.findElement(BUTTON_MAKE_ORDER_IN_PLAYLIST).click();
    }



    //methos for delete playlist
    public void deletePlaylist() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(BUTTON_EDIT_MENU_IN_PLAYLIST).click();
        Thread.sleep(3000);
        driver.findElement(BUTTON_DELETE_PLAYLIST).click();
        Thread.sleep(3000);
        driver.findElement(BUTTON_CONFIRM_DELETE).click();
    }


    //method for delete all video from playlist
    public void playAllVideoFromPlaylist() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(BUTTON_PLAY_ALL_VIDEO_FROM_PLAYLIST).click();
    }


    //method for verify playing the playlist
    public String verifyPlayingTheTestPlaylist() {
        WebElement videoName = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(TEXT_VERIFY_PLAYING_THE_PLAYLIST));
        return driver.findElement(TEXT_VERIFY_PLAYING_THE_PLAYLIST).getText();
    }













    /*
    public void addVideoToPlaylist(String searchFor, String linkText) {
        WebElement playlistEditMenuWait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_EDIT_MENU_IN_PLAYLIST));
        driver.findElement(BUTTON_EDIT_MENU_IN_PLAYLIST).click();
        driver.findElement(BUTTON_ADD_VIDEO_TO_PLAYLIST).click();
        WebElement searchWait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(INPUT_FOR_SEARCH_IN_PLAYLIST_ADD_SECTION));
        driver.findElement(INPUT_FOR_SEARCH_IN_PLAYLIST_ADD_SECTION).sendKeys(searchFor, Keys.ENTER);
        driver.findElement(By.xpath("//*[@alt='"+ linkText +"']")).click();
        driver.findElement(BUTTON_VIDEO_ADD_TO_PLAYLIST_WHEN_SEARCH_FROM_PLAYLIST).click();
    }
     */










}
