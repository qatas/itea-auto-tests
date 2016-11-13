package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitUntilElementDisplayed(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(this.driver, (long)timeout);
        return (WebElement)wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilElementDisplayed(WebElement element) {
        return this.waitUntilElementDisplayed(element, 10);
    }
}
