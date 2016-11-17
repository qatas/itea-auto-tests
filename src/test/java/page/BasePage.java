package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base page where describe the main things to the other pages
 */
public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Explicitly waiting for WebElement visibility with set time
     * @param element WebElement that will be explicitly waited
     * @param timeout Maximum wait time in seconds
     * @return WebElement that was explicitly waited
     */
    public WebElement waitUntilElementDisplayed(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(this.driver, (long)timeout);
        return (WebElement)wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Explicitly waiting for WebElement visibility for 10 seconds
     * @param element WebElement that will be explicitly waited
     * @return WebElement that was explicitly waited
     */
    public WebElement waitUntilElementDisplayed(WebElement element) {
        return this.waitUntilElementDisplayed(element, 10);
    }
}