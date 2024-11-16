package tests;

import core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.User;

public class AddProductBackpackToCart extends BaseTest {
    private String logoName = "Swag Labs";

    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @Test
    public void addProductToCartTest(){
        page.navigate(url);
        LoginPage loginPage = new LoginPage(page);
        loginPage.checkLoginPage(logoName);
        loginPage.login(User.STANDARD.getUserLogin(), User.STANDARD.getUserPassword());
        ProductsPage productsPage = new ProductsPage(page);
        productsPage.checkAppLogo(logoName);
        productsPage.shoppingCartBadgeNotVisible();
        productsPage.addBackpackToBasket();
        productsPage.shoppingCartBadgeIsVisible();
        productsPage.checkAmountOfItemsInShoppingCartBadge("1");
    }
}
