package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Methods for Home page
 */
public class HomePage extends BasePage {
	@FindBy(xpath = "//div[@id=\'main-site-nav\']//a[@class=\'nav-link\' and @href=\'/home?trk=nav_responsive_tab_home\']")
	private WebElement homeMenuLink;

	@FindBy(id = "advanced-search")
	private static WebElement advensedSearchLink;

	/**
	 * Get driver and initialization of elements
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.waitUntilElementDisplayed(this.homeMenuLink);
	}

	/**
	 * Check is Home page is loaded already
	 * @return boolean true or false
	 */
	public boolean isPageLoaded() {
		return this.waitUntilElementDisplayed(this.homeMenuLink, 5).isDisplayed();
	}

	/**
	 * Click  on advance search link in HomePage
	 * @return return SearchPage
	 */
	public SearchPage clickAdvancedSearchLink() {
		this.waitUntilElementDisplayed(advensedSearchLink).click();
		return new SearchPage(this.driver);
	}
}