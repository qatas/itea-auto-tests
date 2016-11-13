import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginRegistrationPage;

public class RegistrationTests extends BaseTest {
    public RegistrationTests() {
    }

    @DataProvider(name = "searchTerms")
    public Object[][] searchTermsData() {
        return new Object[][]{
                {"", "", "", "", "Укажите имя"},
                {"qw", "", "", "", "Укажите фамилию"},
                {"qw", "wцe", "", "", "Укажите свой адрес электронной почты"},
                {"qw", "weq", "qqq@qqq.com", "", "Укажите пароль"},
                {"qw", "weq", "qqq@qqq.com", "12", "Пароль должен быть не менее 6 символов"},
        };
    }

    @Test(groups = {"p1", "Error Massage Test"}, dataProvider = "searchTerms")
    public void errorMessageOnEmptyFormSubmit(String firstNameFieldTerm, String lastNameFieldTerm, String emailFieldTerm, String passwordFieldTerm, String ErrorMessageTerm) {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(this.getDriver());
        registrationPage.registrationFormFillAndSubmit(firstNameFieldTerm, lastNameFieldTerm, emailFieldTerm, passwordFieldTerm);
        Assert.assertEquals(registrationPage.getErrorMessageText(), ErrorMessageTerm, "Expected error message was not found on page");
    }
}


