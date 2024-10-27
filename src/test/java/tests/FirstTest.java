package tests;

import core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.User;

public class FirstTest extends BaseTest {

    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate(url);
    }

    @Test
    public void firstTest(){
        LoginPage loginPage = new LoginPage(page);
        loginPage.checkLoginPage("Swag Labs");
        loginPage.login(User.STANDARD.getUserLogin(), User.STANDARD.getUserPassword());
    }
}
