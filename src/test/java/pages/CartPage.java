package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartPage{
    private final Page page;
    private final Locator cartItem;
    private final Locator buttonCheckout;

    public CartPage(Page page) {
        this.page = page;
        this.cartItem = page.locator("//*[@id=\"cart_contents_container\"]/div/div[1]/div[contains(@class, 'cart_item')]");
        this.buttonCheckout = page.locator("//*[@id=\"checkout\"]");
    }

    public void checkHowManyItemsInCart(int numberOfItemsInCart) {
        assertThat(cartItem).hasCount(numberOfItemsInCart);
    }

    public void clickCheckout() {
        buttonCheckout.click();
    }
    public void checkItemName(int numberItemOnList, String itemName){
        assertThat(page.locator("//*[@id=\"cart_contents_container\"]/div/div[1]/div[contains(@class, 'cart_item')]["+numberItemOnList+"]/div[2]/a/div")).hasText(itemName);
    }
    public void checkItemDescribe(int numberItemOnlist, String itemDescribe){
        assertThat(page.locator("//*[@id=\"cart_contents_container\"]/div/div[1]/div[contains(@class, 'cart_item')]["+numberItemOnlist+"]/div[2]/div[contains(@class, 'inventory_item_desc')]")).hasText(itemDescribe);
    }
    public void checkItemPrice(int numberItemOnlist, String itemPrice) {
        assertThat(page.locator("//*[@id=\"cart_contents_container\"]/div/div[1]/div[contains(@class, 'cart_item')]["+numberItemOnlist+"]/div[2]/div[2]/div")).hasText(itemPrice);
    }
    public void checkQuantityOfItem(int numberItemOnlist, String quantityOfItem) {
        assertThat(page.locator("//*[@id=\"cart_contents_container\"]/div/div[1]/div[contains(@class, 'cart_item')]["+numberItemOnlist+"]/div[contains(@class, 'cart_quantity')]")).hasText(quantityOfItem);
    }
}
