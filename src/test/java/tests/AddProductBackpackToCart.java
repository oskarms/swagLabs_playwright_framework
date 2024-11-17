package tests;

import core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
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
    public void addProductBackpackToCartTest(){
        page.navigate(url);
        LoginPage loginPage = new LoginPage(page);
        loginPage.checkLoginPage(logoName);
        loginPage.login(User.STANDARD.getUserLogin(), User.STANDARD.getUserPassword());
        ProductsPage productsPage = new ProductsPage(page);
        productsPage.checkAppLogo(logoName);
        productsPage.checkNameOfThePage("Products");
        productsPage.shoppingCartBadgeNotVisible();
        productsPage.addBackpackToBasket();
        productsPage.shoppingCartBadgeIsVisible();
        productsPage.checkAmountOfItemsInShoppingCartBadge("1");
        productsPage.clickOnCart();
        CartPage cartPage = new CartPage(page);
        cartPage.checkNameOfThePage("Your Cart");
        cartPage.checkHowManyItemsInCart(1);
    }
}
