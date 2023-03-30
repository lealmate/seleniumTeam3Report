import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.LandingPage;
import org.example.LoginPage;
import org.example.PlaylistPage;
import org.example.SearchPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlaylistTest extends BaseTest{

    @Test
    @Order(1)
    @DisplayName("Create new playlist")
    void createANewPlaylist() throws InterruptedException {
        landingPage.navigate();
        loginPage.logIn("horsemummy07@gmail.com", "01234qwert");
        //loginPage.logIn("thotmad.strongarm@freemail.hu", "Thotmad.Strongarm123");

        landingPage.performSearch("Lewis Hamilton");
        Thread.sleep(2000);
        String expectedVideoName = "Top 10 Moments of Lewis Hamilton Brilliance";
        searchPage.goToLink(expectedVideoName);
        Assertions.assertEquals(expectedVideoName, searchPage.verifyVideo());

        String expectedPlaylistName = "test playlist";
        searchPage.performCreateNewPlaylist(expectedPlaylistName);
        Thread.sleep(2000);
        String actual = searchPage.verifyNewlyCreatedPlaylist();
        Assertions.assertEquals(expectedPlaylistName, actual);


    }


    @Test
    @Order(4)
    @DisplayName("Add video to already created playlist")
    void addVideoToPlaylist() throws InterruptedException {
        landingPage.navigate();
        loginPage.logIn("horsemummy07@gmail.com", "01234qwert");
        //loginPage.logIn("thotmad.strongarm@freemail.hu", "Thotmad.Strongarm123");

        landingPage.performSearch("Lewis Hamilton");
        Thread.sleep(2000);
        String expectedVideoName = "Top 10 Moments of Lewis Hamilton Brilliance";
        searchPage.goToLink(expectedVideoName);
        Assertions.assertEquals(expectedVideoName, searchPage.verifyVideo());

        searchPage.performAddToPlaylist();
        landingPage.goToPlaylist();
        Assertions.assertNotNull(driver.findElement(By.xpath("//a[contains(text(), 'Top 10 Moments of Lewis Hamilton Brilliance')]")));


    }


    @Test
    @Order(3)
    @DisplayName("Delete previously added video from playlist")
    void deleteAnAddedVideoFromPlaylist() throws InterruptedException {
        landingPage.navigate();
        loginPage.logIn("horsemummy07@gmail.com", "01234qwert");
        //loginPage.logIn("thotmad.strongarm@freemail.hu", "Thotmad.Strongarm123");

        landingPage.performSearch("Lewis Hamilton");
        Thread.sleep(2000);
        String expectedVideoName = "Top 10 Moments of Lewis Hamilton Brilliance";
        searchPage.goToLink(expectedVideoName);
        Assertions.assertEquals(expectedVideoName, searchPage.verifyVideo());

        searchPage.performDeleteFromPlaylist();
        landingPage.goToPlaylist();
        Assertions.assertNull(driver.findElement(By.xpath("//a[contains(text(), 'Top 10 Moments of Lewis Hamilton Brilliance')]")));



    }


    @Test
    @Order(2)
    @DisplayName("Go to playlistMenu")
    void goToPlaylist() {
        landingPage.navigate();
        loginPage.logIn("horsemummy07@gmail.com", "01234qwert");

        landingPage.goToPlaylist();
        Assertions.assertNotNull(driver.findElement(By.xpath("//a[contains(text(), 'test playlist")));
    }

    @Test
    @Order(5)
    @DisplayName("Add multiple Video To test playlist")
    void addMultipleVioToPlaylist() throws InterruptedException {
        landingPage.navigate();
        loginPage.logIn("horsemummy07@gmail.com", "01234qwert");

        landingPage.performSearch("Alonso");
        Thread.sleep(2000);
        String expectedVideoName = "Így kapta vissza Alonso a dobogóját";
        searchPage.goToLink(expectedVideoName);
        Assertions.assertEquals(expectedVideoName, searchPage.verifyVideo());
        searchPage.performAddToPlaylist();

        driver.navigate().back();
        searchPage.clickOnDeleteSearchButton();
        landingPage.performSearch("f1 top 10 unusual");
        Thread.sleep(2000);
        String expectedVideoName2 = "Top 10 Unusual Moments in F1";
        searchPage.goToLink(expectedVideoName2);
        Assertions.assertEquals(expectedVideoName2, searchPage.verifyVideo());
        searchPage.performAddToPlaylist();


        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(2000);
        landingPage.goToPlaylist();
        playlistPage.playAllVideoFromPlaylist();
        Thread.sleep(3000);
        playlistPage.verifyPlayingTheTestPlaylist();
        String expectedPlayedPlaylistName = "test playlist";
        Assertions.assertEquals(expectedPlayedPlaylistName, playlistPage.verifyPlayingTheTestPlaylist());
    }

    @Test
    @Order(6)
    @DisplayName("Delete playlist")
    void deletePlaylist() throws InterruptedException {
        landingPage.navigate();
        loginPage.logIn("horsemummy07@gmail.com", "01234qwert");

        landingPage.goToPlaylist();
        playlistPage.deletePlaylist();
    }

}
