import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private WebDriver driver;

    public BaseTest() {
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\WorkTest\\testtools\\geckodriver.exe");
        this.driver = new FirefoxDriver();
        this.driver.get("https://www.linkedin.com/");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}