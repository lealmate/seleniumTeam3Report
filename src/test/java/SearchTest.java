import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.LandingPage;
import org.example.LoginPage;
import org.example.PlaylistPage;
import org.example.SearchPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTest extends BaseTest{

    @Test
    @Order(1)
    @DisplayName("Search for a video and validate")
    void searchForAVideoAndValidate() throws InterruptedException {
        landingPage.navigate();
        loginPage.logIn("horsemummy07@gmail.com", "01234qwert");
        //loginPage.logIn("thotmad.strongarm@freemail.hu", "Thotmad.Strongarm123");

        String wordToSearch = "Lewis Hamilton";
        landingPage.performSearch(wordToSearch);
        Thread.sleep(2000);
        String expectedVideoName = "Top 10 Moments of Lewis Hamilton Brilliance";
        searchPage.goToLink(expectedVideoName);

        Assertions.assertEquals(expectedVideoName, searchPage.verifyVideo());


    }





    @Test
    @Order(2)
    @DisplayName("Delete history")
    public void goToLibraryAndDeleteHistory () throws InterruptedException {
        landingPage.navigate();
        loginPage.logIn("horsemummy07@gmail.com", "01234qwert");
        //loginPage.logIn("thotmad.strongarm@freemail.hu", "Thotmad.Strongarm123");

        playlistPage.goToLibrary();
        Thread.sleep(2000);
        searchPage.deleteHistory();
        searchPage.verifyAllDeletedHistory();
        Assertions.assertEquals("A listán nem szerepelnek videók.", searchPage.verifyAllDeletedHistory());


    }

    @Test
    @Order(3)
    @DisplayName("Clear search input after searching")
    public void testSearchInoutField() throws InterruptedException {
        // Open YouTube homepage
        landingPage.navigate();
        loginPage.logIn("horsemummy07@gmail.com", "01234qwert");
        //loginPage.logIn("thotmad.strongarm@freemail.hu", "Thotmad.Strongarm123");

        // Search for a video
        String searchedSong = "Lewis hamilton";

        Thread.sleep(5000);

        searchPage.writeTextInSearchInput(searchedSong);

        searchPage.clickOnSearchButton();

        String expectedVideoName = "Top 10 Moments of Lewis Hamilton Brilliance";
        searchPage.goToLink(expectedVideoName);
        Assertions.assertEquals(expectedVideoName, searchPage.verifyVideo());

        driver.navigate().back();
        searchPage.clickOnDeleteSearchButton();

        String expectedViewAfterDeleteSearch = "";

        String actualViewAfterDeleteSearch = searchPage.whatIsWriteInTheSearchInput();

        // Verify that the inputBox is empty after deleted the searched text and get back to the search list
        Assertions.assertEquals(expectedViewAfterDeleteSearch, actualViewAfterDeleteSearch);
    }



    @Test
    @Order(4)
    @DisplayName("Test search input variation while navigate through youtube")
    public void testSearchInputVariations() {
        // Open YouTube homepage
        landingPage.navigate();
        loginPage.logIn("horsemummy07@gmail.com", "01234qwert");

        // Search for a video
        String searchedSong = "Lewis hamilton";

        searchPage.writeTextInSearchInput(searchedSong);

        searchPage.clickOnSearchButton();

        String expectedVideoName = "Top 10 Moments of Lewis Hamilton Brilliance";
        searchPage.goToLink(expectedVideoName);
        Assertions.assertEquals(expectedVideoName, searchPage.verifyVideo());

        driver.navigate().back();
        searchPage.clickOnDeleteSearchButton();
        driver.navigate().forward();
        driver.navigate().back();
        driver.navigate().refresh();

        String expectedViewAfterDeleteSearch = "";

        String actualViewAfterDeleteSearch = searchPage.whatIsWriteInTheSearchInput();

        // Verify that the inputBox is empty after deleted the searched text and get back to the search list
        Assertions.assertEquals(expectedViewAfterDeleteSearch, actualViewAfterDeleteSearch);
    }




    @Test
    @Order(5)
    @DisplayName("Search with wrongly write input data")
    public void testWithWronglyWriteInputDate() {
        // Open YouTube homepage
        landingPage.navigate();
        loginPage.logIn("horsemummy07@gmail.com", "01234qwert");

        // Search for a video
        String searchedSong1 = "Leewis haamilton";
        searchPage.writeTextInSearchInput(searchedSong1);
        searchPage.clickOnSearchButton();

        String expectedVideoName = "Top 10 Moments of Lewis Hamilton Brilliance";
        searchPage.goToLink(expectedVideoName);
        Assertions.assertEquals(expectedVideoName, searchPage.verifyVideo());

        driver.navigate().back();
        searchPage.clickOnDeleteSearchButton();

        String searchedSong2 = "LewiSs haamilton.";
        searchPage.writeTextInSearchInput(searchedSong2);
        searchPage.clickOnSearchButton();

        String expectedVideoName2 = "Lewis Hamilton Overtakes EVERYONE! | 2021 Sao Paulo Grand Prix";
        searchPage.goToLink(expectedVideoName2);
        Assertions.assertEquals(expectedVideoName2, searchPage.verifyVideo());
    }


}
