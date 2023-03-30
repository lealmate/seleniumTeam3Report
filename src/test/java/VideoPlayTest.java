import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VideoPlayTest extends BaseTest{

    @Test
    public void navigateToVideoTest(){
        landingPage.navigate();
        loginPage.logIn("thotmad.strongarm@freemail.hu", "Thotmad.Strongarm123");

        wait.until(ExpectedConditions.elementToBeClickable(landingPage.getSearchField()));
        landingPage.useSearch("cabbage boy king");
        landingPage.searchButtonClick();

        String videoToLookFor = "Cabbage Boy - King Kong (NOODCB001)";
        wait.until(ExpectedConditions.elementToBeClickable(videoPlayPage.getVideoName(videoToLookFor)));
        videoPlayPage.selectVideoByName(videoToLookFor);
        String expectedResult = "https://www.youtube.com/watch?v=_3Nd0Lim4nU";
        String actualResult = driver.getCurrentUrl();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void playStopActionsTest(){
        navigateToVideoTest();

        wait.until(ExpectedConditions.elementToBeClickable(videoPlayPage.getPauseButton()));
        videoPlayPage.pauseVideo();
        Assertions.assertTrue(driver.findElement(videoPlayPage.getIsPaused()).isDisplayed());

        videoPlayPage.playVideo();
        Assertions.assertTrue(driver.findElement(videoPlayPage.getIsPlaying()).isDisplayed());
    }

    @Test
    public void stopVideoTest(){
        navigateToVideoTest();

        wait.until(ExpectedConditions.elementToBeClickable(videoPlayPage.getPauseButton()));
        videoPlayPage.pauseVideo();
        Assertions.assertTrue(driver.findElement(videoPlayPage.getIsPaused()).isDisplayed());
    }

    @Test
    public void miniplayerTest(){
        stopVideoTest();

        String urlBefore = driver.getCurrentUrl();
        videoPlayPage.useMiniplayer();
        String urlAfter = driver.getCurrentUrl();
        Assertions.assertNotEquals(urlBefore, urlAfter);

        WebElement moveHere = driver.findElement(videoPlayPage.getExpandButton());
        action.moveToElement(moveHere).moveToElement(moveHere).click().build().perform();
        urlAfter = driver.getCurrentUrl();
        Assertions.assertEquals(urlBefore, urlAfter);
    }

    @Test
    public void theaterModeTest() {
        stopVideoTest();

        WebElement moveHere = driver.findElement(videoPlayPage.getTheaterModeButton());
        action.moveToElement(moveHere).moveToElement(moveHere).click().build().perform();
        Boolean result;
        try {
            result = driver.findElement(videoPlayPage.getTheaterModeButton()).isDisplayed();
        } catch (NoSuchElementException e) {
            result = false;
        }
        Assertions.assertFalse(result);

        videoPlayPage.exitTheaterMode();
        try {
            result = driver.findElement(videoPlayPage.getTheaterModeButton()).isDisplayed();
        } catch (NoSuchElementException e) {
            result = false;
        }
        Assertions.assertTrue(result);
    }

    @Test
    public void fullScreenTest(){
        stopVideoTest();

        videoPlayPage.useFullScreen();
        Assertions.assertTrue(driver.findElement(videoPlayPage.getExitFullScreenButton()).isDisplayed());

        videoPlayPage.exitFullScreen();
        Assertions.assertTrue(driver.findElement(videoPlayPage.getFullScreenButton()).isDisplayed());
    }

    @Test
    public void annotationsTest(){
        stopVideoTest();

        videoPlayPage.settingClick();
        videoPlayPage.annotationToggle();
        Assertions.assertTrue(driver.findElement(videoPlayPage.getAnnotationUnchecked()).isDisplayed());

        videoPlayPage.settingClick();
        videoPlayPage.annotationToggle();
        Assertions.assertTrue(driver.findElement(videoPlayPage.getAnnotationChecked()).isDisplayed());
    }

    @Test
    public void videoSpeed025Test(){
        stopVideoTest();

        videoPlayPage.settingClick();
        videoPlayPage.playbackMenu();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(videoPlayPage.getSpeed025())));
        videoPlayPage.speed025();
        try{
            videoPlayPage.playbackMenu();
        }catch(StaleElementReferenceException e){
            videoPlayPage.playbackMenu();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(videoPlayPage.getSpeed025()+videoPlayPage.getParentElementChecker())));
        Assertions.assertTrue(driver.findElement(By.xpath(videoPlayPage.getSpeed025()+videoPlayPage.getParentElementChecker())).isDisplayed());
    }

    @Test
    public void videoSpeed05Test(){
        stopVideoTest();

        videoPlayPage.settingClick();
        videoPlayPage.playbackMenu();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(videoPlayPage.getSpeed05())));
        videoPlayPage.speed05();
        try{
            videoPlayPage.playbackMenu();
        }catch(StaleElementReferenceException e){
            videoPlayPage.playbackMenu();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(videoPlayPage.getSpeed05()+videoPlayPage.getParentElementChecker())));
        Assertions.assertTrue(driver.findElement(By.xpath(videoPlayPage.getSpeed05()+videoPlayPage.getParentElementChecker())).isDisplayed());
    }

    @Test
    public void videoSpeed2Test(){
        stopVideoTest();

        videoPlayPage.settingClick();
        videoPlayPage.playbackMenu();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(videoPlayPage.getSpeed2())));
        videoPlayPage.speed2();
        try{
            videoPlayPage.playbackMenu();
        }catch(StaleElementReferenceException e){
            videoPlayPage.playbackMenu();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(videoPlayPage.getSpeed2()+videoPlayPage.getParentElementChecker())));
        Assertions.assertTrue(driver.findElement(By.xpath(videoPlayPage.getSpeed2()+videoPlayPage.getParentElementChecker())).isDisplayed());
    }

    @Test
    public void videoQuality720pTest(){
        stopVideoTest();

        videoPlayPage.settingClick();
        videoPlayPage.qualityButtonClick();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(videoPlayPage.getQuality720p())));
        videoPlayPage.quality720p();
        wait.until(ExpectedConditions.elementToBeClickable(videoPlayPage.getSettingsButton()));
        videoPlayPage.settingClick();
        videoPlayPage.settingClick();
        try {
            videoPlayPage.qualityButtonClick();
        }catch (StaleElementReferenceException e){
            videoPlayPage.qualityButtonClick();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(videoPlayPage.getQuality720p())));
        Assertions.assertTrue(driver.findElement(By.xpath(videoPlayPage.getQuality720p()+"/../.."+videoPlayPage.getParentElementChecker())).isDisplayed());
    }

    @Test
    public void videoQuality480pTest(){
        stopVideoTest();

        videoPlayPage.settingClick();
        videoPlayPage.qualityButtonClick();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(videoPlayPage.getQuality480p())));
        videoPlayPage.quality480p();
        wait.until(ExpectedConditions.elementToBeClickable(videoPlayPage.getSettingsButton()));
        videoPlayPage.settingClick();
        videoPlayPage.settingClick();
        try {
            videoPlayPage.qualityButtonClick();
        }catch (StaleElementReferenceException e){
            videoPlayPage.qualityButtonClick();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(videoPlayPage.getQuality480p())));
        Assertions.assertTrue(driver.findElement(By.xpath(videoPlayPage.getQuality480p()+"/../.."+videoPlayPage.getParentElementChecker())).isDisplayed());
    }

    @Test
    public void likeDislikeVideoTest(){
        stopVideoTest();

        String checkForTicked = "//button[@aria-pressed = 'true']";
        videoPlayPage.likeVideo();
        Assertions.assertTrue(driver.findElement(By.xpath(videoPlayPage.getLikeButton()+checkForTicked)).isDisplayed());

        videoPlayPage.dislikeVideo();
        Assertions.assertTrue(driver.findElement(By.xpath(videoPlayPage.getDislikeButton()+checkForTicked)).isDisplayed());
        videoPlayPage.dislikeVideo();
    }
}
