package tests;

import core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.User;

public class OrderTest extends BaseTest {
    final private String logoName = "Swag Labs";
    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }
    @Test
    public void completeBackpackOrderTest(){
        page.navigate(url);
        LoginPage loginPage = new LoginPage(page);
        loginPage.checkLoginPage(logoName);
        loginPage.login(User.STANDARD.getUserLogin(), User.STANDARD.getUserPassword());
        BasePage basePage = new BasePage(page);
        basePage.checkAppLogo(logoName);

        basePage.checkTitleOfThePage("Products");
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
        cartPage.checkItemName(1, "Sauce Labs Backpack");
        cartPage.checkItemDescribe(1, "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        cartPage.checkItemPrice(1, "$29.99");
        cartPage.checkQuantityOfItem(1, "1");
        cartPage.clickCheckout();

        basePage.checkTitleOfThePage("Checkout: Your Information");
        ShippingDetailsPage shippingDetailsPage = new ShippingDetailsPage(page);
        shippingDetailsPage.checkInputsAreEmpty();
        shippingDetailsPage.addFirstName("John");
        shippingDetailsPage.addLastName("Focus");
        shippingDetailsPage.addPostalCode("43-345");
        shippingDetailsPage.clickContinue();

        basePage.checkTitleOfThePage("Checkout: Overview");
        OverviewPage overviewPage = new OverviewPage(page);
        overviewPage.checkTotalPriceWithoutTax("29.99");
        overviewPage.checkTax("2.40");
        overviewPage.checkTotalPriceWithTax("32.39");
        overviewPage.clickFinish();

        basePage.checkTitleOfThePage("Checkout: Complete");
        CompletePage completePage = new CompletePage(page);
        completePage.checkImageComplete();
        completePage.checkCompleteHeader();
        completePage.clickBackHome();

        basePage.checkTitleOfThePage("Products");
        productsPage.shoppingCartBadgeIsHidden();
    }
    @Test
    public void completeMultipleItemsOrderTest(){
        page.navigate(url);
        LoginPage loginPage = new LoginPage(page);
        loginPage.checkLoginPage(logoName);
        loginPage.login(User.STANDARD.getUserLogin(), User.STANDARD.getUserPassword());
        BasePage basePage = new BasePage(page);
        basePage.checkAppLogo(logoName);

        basePage.checkTitleOfThePage("Products");
        ProductsPage productsPage = new ProductsPage(page);
        productsPage.checkNameOfThePage("Products");
        productsPage.shoppingCartBadgeIsHidden();
        productsPage.addBackpackToBasket();
        productsPage.addTShirtToCart();
        productsPage.addLightBikeToCart();
        productsPage.shoppingCartBadgeIsVisible();
        productsPage.checkAmountOfItemsInShoppingCartBadge("3");
        productsPage.clickOnCart();

        basePage.checkTitleOfThePage("Your Cart");
        CartPage cartPage = new CartPage(page);
        cartPage.checkHowManyItemsInCart(3);
        cartPage.checkItemName(1, "Sauce Labs Backpack");
        cartPage.checkItemDescribe(1, "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        cartPage.checkItemPrice(1, "$29.99");
        cartPage.checkQuantityOfItem(1, "1");
        cartPage.checkItemName(2, "Sauce Labs Bolt T-Shirt");
        cartPage.checkItemDescribe(2, "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.");
        cartPage.checkItemPrice(2, "$15.99");
        cartPage.checkQuantityOfItem(2, "1");
        cartPage.checkItemName(3, "Sauce Labs Bike Light");
        cartPage.checkItemDescribe(3, "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");
        cartPage.checkItemPrice(3, "$9.99");
        cartPage.checkQuantityOfItem(3, "1");
        cartPage.clickCheckout();

        basePage.checkTitleOfThePage("Checkout: Your Information");
        ShippingDetailsPage shippingDetailsPage = new ShippingDetailsPage(page);
        shippingDetailsPage.checkInputsAreEmpty();
        shippingDetailsPage.addFirstName("John");
        shippingDetailsPage.addLastName("Focus");
        shippingDetailsPage.addPostalCode("43-345");
        shippingDetailsPage.clickContinue();

        basePage.checkTitleOfThePage("Checkout: Overview");
        OverviewPage overviewPage = new OverviewPage(page);
        overviewPage.checkTotalPriceWithoutTax("55.97");
        overviewPage.checkTax("4.48");
        overviewPage.checkTotalPriceWithTax("60.45");
        overviewPage.clickFinish();

        basePage.checkTitleOfThePage("Checkout: Complete");
        CompletePage completePage = new CompletePage(page);
        completePage.checkImageComplete();
        completePage.checkCompleteHeader();
        completePage.clickBackHome();

        basePage.checkTitleOfThePage("Products");
        productsPage.shoppingCartBadgeIsHidden();
    }
    @Test
    public void completeOrderWithoutShippingDetails_shouldThrowErrorMessageTest(){
        page.navigate(url);
        LoginPage loginPage = new LoginPage(page);
        loginPage.checkLoginPage(logoName);
        loginPage.login(User.STANDARD.getUserLogin(), User.STANDARD.getUserPassword());
        BasePage basePage = new BasePage(page);
        basePage.checkAppLogo(logoName);

        basePage.checkTitleOfThePage("Products");
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
        cartPage.checkItemName(1, "Sauce Labs Backpack");
        cartPage.checkItemDescribe(1, "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        cartPage.checkItemPrice(1, "$29.99");
        cartPage.checkQuantityOfItem(1, "1");
        cartPage.clickCheckout();

        basePage.checkTitleOfThePage("Checkout: Your Information");
        ShippingDetailsPage shippingDetailsPage = new ShippingDetailsPage(page);
        shippingDetailsPage.checkInputsAreEmpty();
        shippingDetailsPage.clickContinue();

        shippingDetailsPage.checkErrorMessage("Error: First Name is required");
        shippingDetailsPage.addFirstName("John");
        shippingDetailsPage.clickContinue();
        shippingDetailsPage.checkErrorMessage("Error: Last Name is required");
        shippingDetailsPage.addLastName("White");
        shippingDetailsPage.clickContinue();
        shippingDetailsPage.checkErrorMessage("Error: Postal Code is required");
    }
    @Test
    public void beforeFinishOrder_backToProductsTest(){
        page.navigate(url);
        LoginPage loginPage = new LoginPage(page);
        loginPage.checkLoginPage(logoName);
        loginPage.login(User.STANDARD.getUserLogin(), User.STANDARD.getUserPassword());
        BasePage basePage = new BasePage(page);
        basePage.checkAppLogo(logoName);

        basePage.checkTitleOfThePage("Products");
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
        cartPage.checkItemName(1, "Sauce Labs Backpack");
        cartPage.checkItemDescribe(1, "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        cartPage.checkItemPrice(1, "$29.99");
        cartPage.checkQuantityOfItem(1, "1");
        cartPage.clickCheckout();

        basePage.checkTitleOfThePage("Checkout: Your Information");
        ShippingDetailsPage shippingDetailsPage = new ShippingDetailsPage(page);
        shippingDetailsPage.checkInputsAreEmpty();
        shippingDetailsPage.addFirstName("John");
        shippingDetailsPage.addLastName("Focus");
        shippingDetailsPage.addPostalCode("43-345");
        shippingDetailsPage.clickContinue();

        basePage.checkTitleOfThePage("Checkout: Overview");
        OverviewPage overviewPage = new OverviewPage(page);
        overviewPage.checkTotalPriceWithoutTax("29.99");
        overviewPage.checkTax("2.40");
        overviewPage.checkTotalPriceWithTax("32.39");
        overviewPage.clickCancel();

        basePage.checkTitleOfThePage("Products");
        productsPage.shoppingCartBadgeIsVisible();
        productsPage.checkAmountOfItemsInShoppingCartBadge("1");
    }
}
