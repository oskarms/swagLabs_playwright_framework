package tests;

import core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import utils.User;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @Test
    public void logoutTest() {
        page.navigate(url);
        LoginPage loginPage = new LoginPage(page);
        loginPage.checkLoginPage("Swag Labs");
        loginPage.checkErrorLockedUserLoginIsHidden();
        loginPage.login(User.STANDARD.getUserLogin(), User.STANDARD.getUserPassword());
        BasePage basePage = new BasePage(page);
        basePage.checkTitleOfThePage("Products");
        basePage.checkAppLogo("Swag Labs");
        basePage.openMenu();
        basePage.clickLogout();
        loginPage.checkLoginPage("Swag Labs");
    }
}
