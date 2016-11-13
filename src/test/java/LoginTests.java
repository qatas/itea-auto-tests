import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginRegistrationPage;

public class LoginTests extends BaseTest {
    public LoginTests() {
    }

    @Test(groups = {"l1", "Login"})
    public void successfulLoginTest() {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(this.getDriver());
        HomePage homePage = registrationPage.loginFormFillAndSubmit("dem.iuliia.p@gmail.com", "dem.iuliia.p.password");
        Assert.assertTrue(homePage.isPageLoaded());
    }
}