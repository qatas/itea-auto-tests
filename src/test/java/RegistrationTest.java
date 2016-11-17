import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginRegistrationPage;

public class RegistrationTest extends BaseTest {
    public RegistrationTest() {
    }

    /**
     * Error massage at the empty form after user click submit
     */
    @Test
    public void errorMessageOnEmptyFormSubmit () {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        registrationPage.registrationFormFillAndSubmit("", "", "", "");
        Assert.assertEquals(registrationPage.getErrorMessageText(), "Укажите имя", "Expected error message was not found on page");
    }
    /**
     * Error massage at the filled fields form and mistake at the email after user click submit
     */
    @Test
    public void errorMessageOnFillFormBadEmailSubmit (){
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        registrationPage.registrationFormFillAndSubmit("ewrqewr", "qwerqwer", "qwerwqer@gmail", "qewrqwer");
        Assert.assertEquals(registrationPage.getErrorMessageText(), "Укажите действительный адрес электронной почты", "Expected error message was not found on page");
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

