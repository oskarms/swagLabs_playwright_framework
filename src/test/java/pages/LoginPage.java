package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {

    private final Page page;
    private final Locator loginLogo;
    private final Locator userInput;
    private final Locator userInputError;
    private final Locator passwordInput;
    private final Locator passwordInputError;
    private final Locator loginInput;
//    private final Locator errorIconLoginInput;
    private final Locator errorContainer;
    private final Locator errorMessage;
    private final Locator buttonCloseErrorMessage;

    public LoginPage(Page page) {
        this.page = page;
        this.loginLogo = page.locator("//*[@id=\"root\"]/div/div[contains(@class, 'login_logo')]");
        this.userInput = page.locator("//*[@id=\"user-name\"]");
        this.userInputError = page.locator("//*[@id=\"user-name\"][contains(@class, 'input_error form_input error')]");
        this.passwordInput = page.locator("//*[@id=\"password\"]");
        this.passwordInputError = page.locator("//*[@id=\"password\"][contains(@class, 'input_error form_input error')]");
        this.loginInput = page.locator("//*[@id=\"login-button\"]");
//        this.errorIconLoginInput = page.locator("//*[@id=\"login_button_container\"]/div/form/div[1]/svg");
        this.errorContainer = page.locator("//*[@id=\"login_button_container\"]/div/form/div[3]");
        this.errorMessage = page.locator("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
        this.buttonCloseErrorMessage = page.locator("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/button");
    }
    public void checkLoginPage(String textOfLogo){
        assertThat(loginLogo).containsText(textOfLogo);
    }
    public void fillLogin(String text) {userInput.fill(text);}
    public void fillPassword(String text) {passwordInput.fill(text);}
    public void login(String text, String password) {
        fillLogin(text);
        fillPassword(password);
        loginInput.click();
    }
    public void checkErrorLockedUserLoginIsVisible(String message) {
        assertThat(userInputError).isVisible();
        assertThat(passwordInputError).isVisible();
        assertThat(errorContainer).isVisible();
        assertThat(errorMessage).containsText(message);
    }
    public void checkErrorLockedUserLoginIsHidden() {
        assertThat(userInputError).isHidden();
        assertThat(passwordInputError).isHidden();
        assertThat(errorMessage).isHidden();
    }
    public void closeErrorContainer() {
        buttonCloseErrorMessage.click();
    }

}

