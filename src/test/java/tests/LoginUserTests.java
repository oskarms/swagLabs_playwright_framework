package tests;

import core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.User;

public class LoginUserTests extends BaseTest {
    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @Test
    public void loginByLockedUserTest() {
        page.navigate(url);
        LoginPage loginPage = new LoginPage(page);
        loginPage.checkLoginPage("Swag Labs");
        loginPage.checkErrorLockedUserLoginIsHidden();
        loginPage.login(User.LOCKED_OUT.getUserLogin(), User.LOCKED_OUT.getUserPassword());
        loginPage.checkErrorLockedUserLoginIsVisible("Epic sadface: Sorry, this user has been locked out.");
        loginPage.closeErrorContainer();
        loginPage.checkErrorLockedUserLoginIsHidden();
    }

    @Test
    public void loginByNotExistUserTest() {
        page.navigate(url);
        LoginPage loginPage = new LoginPage(page);
        loginPage.checkLoginPage("Swag Labs");
        loginPage.checkErrorLockedUserLoginIsHidden();
        loginPage.login(User.NOT_EXIST.getUserLogin(), User.NOT_EXIST.getUserPassword());
        loginPage.checkErrorLockedUserLoginIsVisible("Epic sadface: Username and password do not match any user in this service");
        loginPage.closeErrorContainer();
        loginPage.checkErrorLockedUserLoginIsHidden();
    }
}