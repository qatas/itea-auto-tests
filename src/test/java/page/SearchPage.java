package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Methods for search page
 */
public class SearchPage extends BasePage {
    @FindBy(id = "advs")
    private WebElement advencedSearchForm;

    @FindBy(id = "advs-keywords")
    private WebElement keywordsField;

    @FindBy(xpath = "//div[@class=\'description\']")
    private List<WebElement> searchResultDescriptionsList;

    @FindBy(xpath = "//div[@class=\'search-info\']/p[contains(text(),\'results for\') or contains(text(),\'результат для\')]")
    private WebElement resultsForInfoText;

    @FindBy(xpath = "//*[@class='description']/b")
    private List<WebElement> listPageNumbers;

    /**
     * Get driver and init elements ont the page
     * @param driver
     */
    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.waitUntilElementDisplayed(this.advencedSearchForm);
    }

    /**
     * Fill search keyword and click on "Submit' button
     * @param searchTerm the parameter which should be found
     */
    public void fillKeywordSearchTermAndSubmit(String searchTerm) {
        this.waitUntilElementDisplayed(this.keywordsField);
        this.keywordsField.clear();
        this.keywordsField.sendKeys(new CharSequence[]{searchTerm});
        this.keywordsField.submit();
        this.waitUntilElementDisplayed(this.resultsForInfoText);
    }

    /**
     * Get results on the page and count it's number
     * @return number of found results on the page
     */
    public int getSearchResultsOnPageCount() {
        return this.searchResultDescriptionsList.size();
    }

    /**
     * Get the description of the each web element
     * @return the string list of descriptions
     */
    public List<String> getDescriptionsStringList() {
        ArrayList searchResultDescriptionsStringList = new ArrayList();
        Iterator var2 = this.searchResultDescriptionsList.iterator();

        while(var2.hasNext()) {
            WebElement searchResultDescriptionElement = (WebElement)var2.next();
            System.out.println(searchResultDescriptionElement.getText());
            searchResultDescriptionsStringList.add(searchResultDescriptionElement.getText());
        }
        return searchResultDescriptionsStringList;
    }

    public void ResultsSearchPage() {
        List resultSearchList = this.driver.findElements(By.xpath("//*[@class=\'description\']/b"));
        System.out.println(resultSearchList.size() + " элементов на странице.");
    }
}