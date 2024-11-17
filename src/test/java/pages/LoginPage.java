package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {

    private final Page page;
    private final Locator loginLogo;
    private final Locator userInput;
    private final Locator passwordInput;
    private final Locator loginInput;

    public LoginPage(Page page) {
        this.page = page;
        this.loginLogo = page.locator("//*[@id=\"root\"]/div/div[contains(@class, 'login_logo')]");
        this.userInput = page.locator("//*[@id=\"user-name\"]");
        this.passwordInput = page.locator("//*[@id=\"password\"]");
        this.loginInput = page.locator("//*[@id=\"login-button\"]");
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
}

