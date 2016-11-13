package page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {
    @FindBy(id = "advs") private WebElement advencedSearchForm;
    @FindBy(id = "advs-keywords") private WebElement keywordsField;
    @FindBy(xpath = "//div[@class=\'description\']") private List<WebElement> searchResultDescriptionsList;
    @FindBy(xpath = "//div[@class=\'search-info\']/p[contains(text(),\'results for\') or contains(text(),\'результат для\')]") private WebElement resultsForInfoText;
//    @FindBy(xpath = "//ul[@class = 'pagination']/li/a") private List<WebElement> listOfPagesNumbers;
    @FindBy(xpath = "//*[@class='description']/b") private List<WebElement> listPageNumbers;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.waitUntilElementDisplayed(this.advencedSearchForm);
    }

    public void fillKeywordSearchTermAndSubmit(String searchTerm) {
        this.waitUntilElementDisplayed(this.keywordsField).sendKeys(new CharSequence[]{searchTerm});
        this.keywordsField.submit();
        this.waitUntilElementDisplayed(this.resultsForInfoText);
    }

    public int getSearchResultsOnPageCount() {
        return this.searchResultDescriptionsList.size();
    }

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
