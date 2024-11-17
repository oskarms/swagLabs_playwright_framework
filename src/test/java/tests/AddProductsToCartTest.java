package tests;

import core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.User;

public class AddProductsToCartTest extends BaseTest {

    final private String logoName = "Swag Labs";

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
        BasePage basePage = new BasePage(page);
        basePage.checkTitleOfThePage("Products");
        basePage.checkAppLogo(logoName);
        ProductsPage productsPage = new ProductsPage(page);
        productsPage.checkNameOfThePage("Products");
        productsPage.shoppingCartBadgeIsHidden();
        productsPage.addBackpackToBasket();
        productsPage.shoppingCartBadgeIsVisible();
        productsPage.checkAmountOfItemsInShoppingCartBadge("1");
        productsPage.clickOnCart();
        basePage.checkTitleOfThePage("Your Cart");
        CartPage cartPage = new CartPage(page);
        cartPage.checkHowManyItemsInCart(1);
    }

    @Test
    public void addTwoProductsToCartTest(){
        page.navigate(url);
        LoginPage loginPage = new LoginPage(page);
        loginPage.checkLoginPage(logoName);
        loginPage.login(User.STANDARD.getUserLogin(), User.STANDARD.getUserPassword());
        BasePage basePage = new BasePage(page);
        basePage.checkTitleOfThePage("Products");
        basePage.checkAppLogo(logoName);
        ProductsPage productsPage = new ProductsPage(page);
        productsPage.checkNameOfThePage("Products");
        productsPage.shoppingCartBadgeIsHidden();
        productsPage.addBackpackToBasket();
        productsPage.shoppingCartBadgeIsVisible();
        productsPage.checkAmountOfItemsInShoppingCartBadge("1");
        productsPage.addLightBikeToCart();
        productsPage.checkAmountOfItemsInShoppingCartBadge("2");
        productsPage.clickOnCart();
        basePage.checkTitleOfThePage("Your Cart");
        CartPage cartPage = new CartPage(page);
        cartPage.checkHowManyItemsInCart(2);
    }

    @Test
    public void addProductAndRemoveFromCart(){
        page.navigate(url);
        LoginPage loginPage = new LoginPage(page);
        loginPage.checkLoginPage(logoName);
        loginPage.login(User.STANDARD.getUserLogin(), User.STANDARD.getUserPassword());
        BasePage basePage = new BasePage(page);
        basePage.checkTitleOfThePage("Products");
        basePage.checkAppLogo(logoName);
        ProductsPage productsPage = new ProductsPage(page);
        productsPage.checkNameOfThePage("Products");
        productsPage.shoppingCartBadgeIsHidden();
        productsPage.addBackpackToBasket();
        productsPage.shoppingCartBadgeIsVisible();
        productsPage.checkAmountOfItemsInShoppingCartBadge("1");
        productsPage.removeBackpackFromCart();
        productsPage.shoppingCartBadgeIsHidden();
        productsPage.clickOnCart();
        basePage.checkTitleOfThePage("Your Cart");
        CartPage cartPage = new CartPage(page);
        cartPage.checkHowManyItemsInCart(0);
    }

    @Test
    public void addTwoProductsAndRemoveOneProductFromCart(){
        page.navigate(url);
        LoginPage loginPage = new LoginPage(page);
        loginPage.checkLoginPage(logoName);
        loginPage.login(User.STANDARD.getUserLogin(), User.STANDARD.getUserPassword());
        BasePage basePage = new BasePage(page);
        basePage.checkTitleOfThePage("Products");
        basePage.checkAppLogo(logoName);
        ProductsPage productsPage = new ProductsPage(page);
        productsPage.shoppingCartBadgeIsHidden();
        productsPage.addBackpackToBasket();
        productsPage.shoppingCartBadgeIsVisible();
        productsPage.checkAmountOfItemsInShoppingCartBadge("1");
        productsPage.addLightBikeToCart();
        productsPage.checkAmountOfItemsInShoppingCartBadge("2");
        productsPage.removeLightBikeFromCart();
        productsPage.shoppingCartBadgeIsVisible();
        productsPage.checkAmountOfItemsInShoppingCartBadge("1");
        productsPage.clickOnCart();
        basePage.checkTitleOfThePage("Your Cart");
        CartPage cartPage = new CartPage(page);
        cartPage.checkHowManyItemsInCart(1);
    }

    @Test
    public void removeAllProductsFromCart(){
        page.navigate(url);
        LoginPage loginPage = new LoginPage(page);
        loginPage.checkLoginPage(logoName);
        loginPage.login(User.STANDARD.getUserLogin(), User.STANDARD.getUserPassword());
        BasePage basePage = new BasePage(page);
        basePage.checkTitleOfThePage("Products");
        basePage.checkAppLogo(logoName);
        ProductsPage productsPage = new ProductsPage(page);
        productsPage.addBackpackToBasket();
        productsPage.addLightBikeToCart();
        productsPage.addTShirtToCart();
        productsPage.checkAmountOfItemsInShoppingCartBadge("3");
        basePage.openMenu();
        basePage.resetAppState();
        basePage.closeMenu();
        productsPage.shoppingCartBadgeIsHidden();
        productsPage.clickOnCart();
        basePage.checkTitleOfThePage("Your Cart");
    }
}
