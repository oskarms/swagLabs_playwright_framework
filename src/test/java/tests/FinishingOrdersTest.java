package tests;

import core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.User;

public class FinishingOrdersTest extends BaseTest {

    final private String logoName = "Swag Labs";

    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @Test
    public void finishBackpackOrder(){
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
}
