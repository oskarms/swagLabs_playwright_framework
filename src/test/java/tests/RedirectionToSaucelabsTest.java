package tests;

import core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import utils.User;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RedirectionToSaucelabsTest extends BaseTest {
    final private String logoName = "Swag Labs";
    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }
    @Test
    public void redirectionToSaucelabsTest(){
        page.navigate(url);
        LoginPage loginPage = new LoginPage(page);
        loginPage.checkLoginPage("Swag Labs");
        loginPage.login(User.STANDARD.getUserLogin(), User.STANDARD.getUserPassword());
        BasePage basePage = new BasePage(page);
        basePage.checkTitleOfThePage("Products");
        basePage.checkAppLogo(logoName);
        basePage.openMenu();
        basePage.clickAbout();
        assertThat(page).hasURL("https://saucelabs.com/");
    }
}
