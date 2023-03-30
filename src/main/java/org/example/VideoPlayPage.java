package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VideoPlayPage extends BasePage{
    public VideoPlayPage(WebDriver driver) {
        super(driver);
    }

    private String selectedVideo = "//*[contains(text(), '%s')]";
    private final By PLAY_BUTTON = By.xpath("//button[@class='ytp-play-button ytp-button']");
    private final By PAUSE_BUTTON = By.xpath("//button[@class='ytp-play-button ytp-button']");
    private final By VIDEO_PAUSED = By.xpath("//*[@id=\"movie_player\"] [contains(@class, 'paused-mode')]");
    private final By VIDEO_PLAYING = By.xpath("//*[@id=\"movie_player\"] [contains(@class, 'playing-mode')]");
    private final By MINIPLAYER_BUTTON = By.xpath("//button[@title='Miniplayer (i)']");
    private final By EXPAND_BUTTON = By.xpath("//button[@title='Expand (i)']"); // For miniplayer
    private final By THEATER_MODE_BUTTON = By.xpath("//button[@title='Theater mode (t)']");
    private final By DEFAULT_VIEW_BUTTON = By.xpath("//button[@title='Default view (t)']"); // For theater mode
    private final By FULL_SCREEN_BUTTON = By.xpath("//button[@title='Full screen (f)']");
    private final By EXIT_FULL_SCREEN_BUTTON = By.xpath("//button[@title='Exit full screen (f)']");
    private final By SETTINGS_BUTTON = By.xpath("//*[@id=\"movie_player\"]//button[@aria-label='Settings']");
    private final By ANNOTATIONS_TOGGLE = By.className("ytp-menuitem-toggle-checkbox");
    private final By ANNOTATION_CHECKED = By.xpath("//*[@role ='menuitemcheckbox'][@aria-checked='true']");
    private final By ANNOTATION_UNCHECKED = By.xpath("//*[@role ='menuitemcheckbox'][@aria-checked='false']");
    private final By PLAYBACK_SPEED_BUTTON = By.xpath("//*[contains(text(), 'Playback speed')]");
    private final String SPEED_CUSTOM = "//div[contains(text(), 'Custom')]";
    private final String SPEED_025 = "//div[(text() = '0.25')]";
    private final String SPEED_05 = "//div[(text() = '0.5')]";
    private final String SPEED_075 = "//div[(text() = '0.75')]";
    private final String SPEED_1 = "//div[(text() = 'Normal')]";
    private final String SPEED_125 = "//div[(text() = '1.25')]";
    private final String SPEED_15 = "//div[(text() = '1.5')]";
    private final String SPEED_175 = "//div[(text() = '1.75')]";
    private final String SPEED_2 = "//div[(text() = '2')]";
    private final String PARENT_ELEMENT_CHECKER = "/parent::*[@aria-checked = 'true']";
    private final By QUALITY_BUTTON = By.xpath("//div[contains(text(), 'Quality')]");
    private final String QUALITY_AUTO = "//span[(text() = 'Auto')]";
    private final String QUALITY_144P = "//span[(text() = '144p')]";
    private final String QUALITY_240P = "//span[(text() = '240p')]";
    private final String QUALITY_360P = "//span[(text() = '360p')]";
    private final String QUALITY_480P = "//span[(text() = '480p')]";
    private final String QUALITY_720P = "//span[(text() = '720p')]";
    private final String QUALITY_1080P = "//span[(text() = '1080p')]";
    private final String QUALITY_1440P = "//span[(text() = '1440p')]";
    private final String QUALITY_2160P = "//span[(text() = '2160p')]";
    private final String LIKE_BUTTON = "//div[@id='segmented-like-button']";
    private final String DISLIKE_BUTTON = "//div[@id='segmented-dislike-button']";
    private final By SKIP_ADD_BUTTON = By.xpath("//*[@id=\"skip-button:6\"]/span/button");
    private final By ADD_COUNTDOWN_WINDOW = By.xpath("//*[@id=\"preskip-component:2\"]/span");

    // Getters for fixed variables
    public By getVideoName(String videoName){
        selectedVideo = String.format(selectedVideo, videoName);
        return By.xpath(selectedVideo);
    }

    public By getSkipAddButton(){
        return SKIP_ADD_BUTTON;
    }

    public By addCountdown(){
        return ADD_COUNTDOWN_WINDOW;
    }

    public By getPlayButton(){
        return PLAY_BUTTON;
    }

    public By getPauseButton(){
        return PAUSE_BUTTON;
    }

    public By getIsPaused(){
        return VIDEO_PAUSED;
    }

    public By getIsPlaying(){
        return VIDEO_PLAYING;
    }

    public By getMiniplayerButton(){
        return MINIPLAYER_BUTTON;
    }

    public By getExpandButton(){
        return EXPAND_BUTTON;
    }

    public By getTheaterModeButton(){
        return THEATER_MODE_BUTTON;
    }

    public By getDefaultViewButton(){
        return DEFAULT_VIEW_BUTTON;
    }

    public By getFullScreenButton(){
        return FULL_SCREEN_BUTTON;
    }

    public By getExitFullScreenButton(){
        return EXIT_FULL_SCREEN_BUTTON;
    }

    public By getSettingsButton(){
        return SETTINGS_BUTTON;
    }

    public By getAnnotationChecked(){
        return ANNOTATION_CHECKED;
    }

    public By getAnnotationUnchecked(){
        return ANNOTATION_UNCHECKED;
    }

    public String getSpeedCustom(){
        return SPEED_CUSTOM;
    }

    public String getSpeed025(){
        return SPEED_025;
    }

    public String getSpeed05(){
        return SPEED_05;
    }

    public String getSpeed75(){
        return SPEED_075;
    }

    public String getNormalSpeed(){
        return SPEED_1;
    }

    public String getSpeed125(){
        return SPEED_125;
    }

    public String getSpeed15(){
        return SPEED_15;
    }

    public String getSpeed175(){
        return SPEED_175;
    }

    public String getSpeed2(){
        return SPEED_2;
    }

    public String getParentElementChecker(){
        return PARENT_ELEMENT_CHECKER;
    }

    public String getQualityAuto(){
        return QUALITY_AUTO;
    }

    public String getQuality720p(){
        return QUALITY_720P;
    }

    public String getQuality2160p(){
        return QUALITY_2160P;
    }

    public String getQuality480p(){
        return QUALITY_480P;
    }

    public String getLikeButton(){
        return LIKE_BUTTON;
    }

    public String getDislikeButton(){
        return DISLIKE_BUTTON;
    }

    // Methods for click-by-click navigation
    public void selectVideoByName(String videoName){
        selectedVideo = String.format(selectedVideo, videoName);
        driver.findElement(By.xpath(selectedVideo)).click();
    }

    public void playVideo(){
        driver.findElement(PLAY_BUTTON).click();
    }

    public void pauseVideo(){
        driver.findElement(PAUSE_BUTTON).click();
    }

    public void useMiniplayer(){
        driver.findElement(MINIPLAYER_BUTTON).click();
    }

    public void exitMiniplayer(){
        driver.findElement(EXPAND_BUTTON).click();
    }

    public void useTheaterMode(){
        driver.findElement(THEATER_MODE_BUTTON).click();
    }

    public void exitTheaterMode(){
        driver.findElement(DEFAULT_VIEW_BUTTON).click();
    }

    public void useFullScreen(){
        driver.findElement(FULL_SCREEN_BUTTON).click();
    }

    public void exitFullScreen(){
        driver.findElement(EXIT_FULL_SCREEN_BUTTON).click();
    }

    public void settingClick(){
        driver.findElement(SETTINGS_BUTTON).click();
    }

    public void annotationToggle(){
        driver.findElement(ANNOTATIONS_TOGGLE).click();
    }

    public void playbackMenu(){
        driver.findElement(PLAYBACK_SPEED_BUTTON).click();
    }

    public void speedCustom(){
        driver.findElement(By.xpath(SPEED_CUSTOM)).click();
    }

    public void speed025(){
        driver.findElement(By.xpath(SPEED_025)).click();
    }

    public void speed05(){
        driver.findElement(By.xpath(SPEED_05)).click();
    }

    public void speed075(){
        driver.findElement(By.xpath(SPEED_075)).click();
    }

    public void speedNormal(){
        driver.findElement(By.xpath(SPEED_1)).click();
    }

    public void speed125(){
        driver.findElement(By.xpath(SPEED_125)).click();
    }

    public void speed15(){
        driver.findElement(By.xpath(SPEED_15)).click();
    }

    public void speed175(){
        driver.findElement(By.xpath(SPEED_175)).click();
    }

    public void speed2(){
        driver.findElement(By.xpath(SPEED_2)).click();
    }

    public void qualityButtonClick(){
        driver.findElement(QUALITY_BUTTON).click();
    }

    public void qualityAuto(){
        driver.findElement(By.xpath(QUALITY_AUTO)).click();
    }

    public void quality144p(){
        driver.findElement(By.xpath(QUALITY_144P)).click();
    }

    public void quality240p(){
        driver.findElement(By.xpath(QUALITY_240P)).click();
    }

    public void quality360p(){
        driver.findElement(By.xpath(QUALITY_360P)).click();
    }

    public void quality480p(){
        driver.findElement(By.xpath(QUALITY_480P)).click();
    }

    public void quality720p(){
        driver.findElement(By.xpath(QUALITY_720P)).click();
    }

    public void quality1080p(){
        driver.findElement(By.xpath(QUALITY_1080P)).click();
    }

    public void quality1440p(){
        driver.findElement(By.xpath(QUALITY_1440P)).click();
    }

    public void quality2160p(){
        driver.findElement(By.xpath(QUALITY_2160P)).click();
    }

    public void likeVideo(){
        driver.findElement(By.xpath(LIKE_BUTTON)).click();
    }

    public void dislikeVideo(){
        driver.findElement(By.xpath(DISLIKE_BUTTON)).click();
    }

    public void skipAdd(){
        driver.findElement(SKIP_ADD_BUTTON).click();
    }
}
