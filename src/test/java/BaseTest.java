import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Base test where describe the main things to the all tests. Write the total for all tests
 */
public class BaseTest {
    private WebDriver driver;

    public BaseTest() {
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    /**
     * In this method write what we doing before each class
     */
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\WorkTest\\testtools\\geckodriver.exe");
        this.driver = new FirefoxDriver();
        this.driver.get("https://www.linkedin.com/");
    }

    /**
     * Close browser after each test
     */
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}