package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Methods for login/registration page
 */
public class LoginRegistrationPage extends BasePage {
    @FindBy(id = "reg-firstname")
    private WebElement firstNameField;

    @FindBy(id = "reg-lastname")
    private WebElement lastNameField;

    @FindBy(id = "reg-email")
    private WebElement emailField;

    @FindBy(id = "reg-password")
    private WebElement passwordField;

    @FindBy(id = "registration-submit")
    private WebElement joinNowButton;

    @FindBy(id = "login-email")
    private WebElement loginEmailField;

    @FindBy(id = "login-password")
    private WebElement loginPasswordField;

    @FindBy(id = "login-submit")
    private WebElement signInButton;

    @FindBy(className = "alert-content")
    private WebElement errorMessageBox;

    /**
     * Get driver and initialization of elements
     * @param driver
     */
    public LoginRegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Check the login of user
     * @param loginEmail email of user for login
     * @param loginPassword password for login
     * @return return HomePage
     */
    public HomePage loginFormFillAndSubmit(String loginEmail, String loginPassword) {
        this.loginEmailField.sendKeys(new CharSequence[]{loginEmail});
        this.loginPasswordField.sendKeys(new CharSequence[]{loginPassword});
        this.signInButton.click();
        return new HomePage(this.driver);
    }

    /**
     * Check the registration of user
     * @param firstName name of user
     * @param lastName last name of user
     * @param email email of user
     * @param password password of user
     */
    public void registrationFormFillAndSubmit(String firstName, String lastName, String email, String password) {
        this.firstNameField.clear();
        this.firstNameField.sendKeys(new CharSequence[]{firstName});
        this.lastNameField.clear();
        this.lastNameField.sendKeys(new CharSequence[]{lastName});
        this.emailField.clear();
        this.emailField.sendKeys(new CharSequence[]{email});
        this.passwordField.clear();
        this.passwordField.sendKeys(new CharSequence[]{password});
        this.joinNowButton.click();
    }

    /**
     * Get text from the error message
     * @return text of error message
     */
    public String getErrorMessageText() {
        return this.errorMessageBox.getText();
    }
}