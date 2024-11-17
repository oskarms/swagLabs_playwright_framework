package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartPage {

    private final Page page;

    private final Locator titlePage;
    private final Locator cartItem;

    public CartPage(Page page) {
        this.page = page;
        this.titlePage = page.locator("//*[@id=\"header_container\"]/div[2]/span");
        this.cartItem = page.locator("//*[@id=\"cart_contents_container\"]/div/div[1]/div[contains(@class, 'cart_item')]");
    }

    public void checkNameOfThePage(String titleOfPage){
        assertThat(titlePage).containsText(titleOfPage);
    }

    public void checkHowManyItemsInCart(int numberOfItemsInCart) {
        assertThat(cartItem).hasCount(numberOfItemsInCart);
    }
}