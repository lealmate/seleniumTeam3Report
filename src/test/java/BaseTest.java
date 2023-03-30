import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    LandingPage landingPage;
    LoginPage loginPage;
    VideoPlayPage videoPlayPage;
    Actions action;
    VideoPage videoPage;
    SearchPage searchPage;
    PlaylistPage playlistPage;



    @BeforeEach
    public void init() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        videoPlayPage = new VideoPlayPage(driver);
        action = new Actions(driver);
        videoPage = new VideoPage(driver);
        searchPage = new SearchPage(driver);
        playlistPage = new PlaylistPage(driver);
    }
}
