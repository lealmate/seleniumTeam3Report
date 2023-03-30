import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.LandingPage;
import org.example.LoginPage;
import org.example.VideoPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestYoutube extends BaseTest{


    /*@Test
    @Disabled
    @Order(405)
    public void LoginToYouTube() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        loginPage.NavigateToLogin();
        String address = "csaba_toth@hotmail.com";
        String password = "Tcs+1026";
        loginPage.login1(address);
        Thread.sleep(5000);
        String actualURL = driver.getCurrentUrl();
        String actualURLShort = actualURL.substring(0, 48);
        String expectedURL = "https://accounts.google.com/v3/signin/challenge/";
        //Thread.sleep(5000);
        loginPage.login2(password);
        Thread.sleep(5000);
        String actualURLShort2 = actualURL.substring(0, 34);
        String expectedURL2 = "https://gds.google.com/web/chip?ep";
        Assertions.assertEquals(expectedURL2, actualURLShort2);
        if (actualURLShort2 == expectedURL2) {
            loginPage.ClickOnNotNow();
        }
        String channel = "Mercedes F1 race";
        landingPage.SearchYouTube(channel);
        wait(1000);
        landingPage.SubscribeFirstOption();
        //File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);


        //if (actualURLShort == expectedURL) {
        //  loginPage.login2(password);
        //} else {

        //Thread.sleep(5000);
        //String actualURL2 = driver.getCurrentUrl();
        //String expectedURL2 = "youtube.com";
        //Assertions.assertEquals(expectedURL2, actualURL2);
    }*/

    /*@Test
    @Disabled
    @Order(400)
    public void SubscribeChannelOriginal() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        Thread.sleep(1000);
        //landingPage.OpenLandingPage();
        //landingPage.OpenDropDownLeftMenu();
        String channel = "Mercedes F1 channel";
        Thread.sleep(1500);
        landingPage.SearchYouTube(channel);
        //Thread.sleep(1000);
        //landingPage.SubscribeFirstOption();
    }*/

    @Test
    @Order(1)
    public void SubscribeToChannel() throws InterruptedException {
        landingPage.navigate();
        loginPage.logIn("thotmad.strongarm@freemail.hu","Thotmad.Strongarm123");
        String channel = "Mercedes F1 channel";
        landingPage.performSearch(channel);
        Thread.sleep(2000);
        landingPage.SubscribeFirstOption();
        Thread.sleep(150);
        driver.quit();
    }

    @Test
    @Order(2)
    public void UnsubscribeFromChannel() throws InterruptedException {
        landingPage.navigate();
        loginPage.logIn("thotmad.strongarm@freemail.hu","Thotmad.Strongarm123");
        String channel = "Mercedes F1 channel";
        landingPage.performSearch(channel);
        Thread.sleep(2000);
        landingPage.Unsubscribe();
        Thread.sleep(1500);
        driver.quit();
    }

    @Test
    @Order(3)
    public void AddCommentAndLike() throws InterruptedException {
        landingPage.navigate();
        loginPage.logIn("thotmad.strongarm@freemail.hu","Thotmad.Strongarm123");
        String video = "Cabbage Boy King Kong";
        landingPage.performSearch(video);
        Thread.sleep(1000);
        searchPage.goToLink("Cabbage Boy - King Kong (NOODCB001)");
        Thread.sleep(4000);
        String comment1 = "This is awesome!";
        videoPage.Comment(comment1);
        Thread.sleep(2000);
        videoPage.LikeComment();
        Thread.sleep(4000);
        String comment2 = " Heard this in 2004. This was the final track of a Solid Steel Mix";
        videoPage.editComment(comment2);
        Thread.sleep(1000);
        videoPage.DislikeComment();
        Thread.sleep(4000);
        videoPage.DeleteComment();
        Thread.sleep(1000);
        driver.quit();
    }

    /*@Test
    @Order(4)
    public void EditCommentAndDislike() throws InterruptedException {
        landingPage.navigate();
        loginPage.logIn("thotmad.strongarm@freemail.hu","Thotmad.Strongarm123");
        String video = "Cabbage Boy King Kong";
        landingPage.SearchYouTube(video);
        Thread.sleep(1000);
        videoPage.ClickOnVideo();
        Thread.sleep(4000);
        String comment2 = " Heard this in 2004. This was the final track of a Solid Steel Mix";
        videoPage.editComment(comment2);
        videoPage.DislikeComment();
        driver.quit();
    }*/

    /*@Test
    @Order(5)
    public void DeleteComment() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        VideoPage videoPage = new VideoPage(driver);
        Thread.sleep(1000);
        landingPage.OpenLandingPage();
        landingPage.ClickOnSignIn();
        String address = "csaba_toth@hotmail.com";
        String password = "Tcs+1026";
        Thread.sleep(1000);
        loginPage.login1(address);
        Thread.sleep(500);
        loginPage.login2(password);
        Thread.sleep(2000);
        String video = "Cabbage Boy King Kong";
        landingPage.SearchYouTube(video);
        Thread.sleep(1000);
        videoPage.ClickOnVideo();
        Thread.sleep(4000);
        videoPage.DeleteComment();
        Thread.sleep(1000);
        driver.quit();
    }*/


    /*@Test
    @Disabled
    public void EnterPlaylist() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        VideoPage videoPage = new VideoPage(driver);
        Thread.sleep(1000);
        landingPage.OpenLandingPage();
        landingPage.ClickOnSignIn();
        String address = "csaba_toth@hotmail.com";
        String password = "Tcs+1026";
        Thread.sleep(1000);
        loginPage.login1(address);
        Thread.sleep(500);
        loginPage.login2(password);
        Thread.sleep(2000);
        landingPage.dropDownLeftMenu();
        Thread.sleep(2000);
        videoPage.OpenPlaylist();
        Thread.sleep(1000);
    }*/

}





