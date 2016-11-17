import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginRegistrationPage;
import page.SearchPage;

/**
 * Tests for advanced search
 */
public class AdvancedSearchPageTest extends BaseTest {

    public HomePage homePage;

    /**
     * The same operations for all tests, for class search result
     * it is login in linkedin
     */
    @BeforeClass
    public void beforeTest() {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(this.getDriver());
        homePage = registrationPage.loginFormFillAndSubmit("dem.iuliia.p@gmail.com", "dem.iuliia.p.password");
        Assert.assertTrue(homePage.isPageLoaded());
    }

    /**
     *  List of search terms that will be used in the test
     * @return keywords for different searching
     */
    @DataProvider(name = "searchTerms")
    public Object[][] searchTermsData() {
        return new Object[][]{
                {"HR", "HR"},
                {"hr", "hr"}
        };
    }


    /**
     * Search by keyword and check that result by keyword is displayed on the page
     */
    @Test(dataProvider = "searchTerms")
    public void advancedSearchTest(String searchTerm, String expectedContainedTerm) {
        SearchPage searchPage = homePage.clickForAdvansedSearchLink();
        searchPage.fillKeywordSearchTermAndSubmit(searchTerm);
        Assert.assertEquals(searchPage.getSearchResultsOnPageCount(), 10, "Actual results on page number is wrong");
        Assert.assertTrue(searchPage.getDescriptionsStringList(expectedContainedTerm), "Expected search term is not found in result list");
    }

}