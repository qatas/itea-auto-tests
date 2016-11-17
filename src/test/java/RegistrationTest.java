import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginRegistrationPage;

public class RegistrationTest extends BaseTest {
    public RegistrationTest() {
    }

    /**
     * List of value that will be used in the test
     * @return value for complete registration form
     */
    @DataProvider(name = "dataForRegistration")
    public Object[][] dataForRegistration() {
        return new Object[][]{
                {"", "", "", "", "Укажите имя"},
                {"qw", "", "", "", "Укажите фамилию"},
                {"qw", "wцe", "", "", "Укажите свой адрес электронной почты"},
                {"qw", "weq", "qqq@qqq.com", "", "Укажите пароль"},
                {"qw", "weq", "qqq@qqq.com", "12", "Пароль должен быть не менее 6 символов"},
        };
    }

    /**
     *  Fix different error massages from registration form
     * @param firstNameFieldTerm value for first name, user enter his first name
     * @param lastNameFieldTerm value for last name, user enter his last name
     * @param emailFieldTerm value for email, user enter his email
     * @param passwordFieldTerm value for password, user enter his password
     * @param ErrorMessageTerm error massage
     */
    @Test(groups = {"p1", "Error Massage Test"}, dataProvider = "dataForRegistration")
    public void errorMassagesFromRegistrationForm(String firstNameFieldTerm, String lastNameFieldTerm, String emailFieldTerm, String passwordFieldTerm, String ErrorMessageTerm) {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(this.getDriver());
        registrationPage.registrationFormFillAndSubmit(firstNameFieldTerm, lastNameFieldTerm, emailFieldTerm, passwordFieldTerm);
        Assert.assertEquals(registrationPage.getErrorMessageText(), ErrorMessageTerm, "Expected error message was not found on page");
    }
}

