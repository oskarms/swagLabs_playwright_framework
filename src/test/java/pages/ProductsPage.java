package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductsPage{
    private final Page page;
    private final Locator buttonAddBackpackToCart;
    private final Locator buttonRemoveBackpackFromCart;
    private final Locator buttonAddLightBikeToCart;
    private final Locator buttonRemoveLightBikeFromCart;
    private final Locator buttonAddTShirtToCart;
    private final Locator buttonRemoveTShirtFromCart;
    private final Locator shoppingCartBadge;
    private final Locator titlePage;
    private final Locator iconCart;

    public ProductsPage(Page page) {
        this.page = page;
        this.buttonAddBackpackToCart = page.locator("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
        this.buttonRemoveBackpackFromCart = page.locator("//*[@id=\"remove-sauce-labs-backpack\"]");
        this.buttonAddTShirtToCart = page.locator("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]");
        this.buttonRemoveTShirtFromCart = page.locator("//*[@id=\"remove-sauce-labs-bolt-t-shirt\"]");
        this.buttonAddLightBikeToCart = page.locator("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");
        this.buttonRemoveLightBikeFromCart = page.locator("//*[@id=\"remove-sauce-labs-bike-light\"]");
        this.shoppingCartBadge = page.locator("//*[@id=\"shopping_cart_container\"]/a/span");
        this.titlePage = page.locator("//*[@id=\"header_container\"]/div[2]/span");
        this.iconCart = page.locator("//*[@id=\"shopping_cart_container\"]/a");
    }

    public void checkNameOfThePage(String titleOfPage) {
        assertThat(titlePage).containsText(titleOfPage);
    }

    public void addBackpackToBasket() {
        buttonRemoveBackpackFromCart.isHidden();
        buttonAddBackpackToCart.click();
        buttonRemoveBackpackFromCart.isVisible();
    }

    public void removeBackpackFromCart() {
        buttonRemoveBackpackFromCart.isVisible();
        buttonRemoveBackpackFromCart.click();
        buttonRemoveBackpackFromCart.isHidden();
        buttonAddBackpackToCart.isVisible();
    }

    public void addLightBikeToCart() {
        buttonRemoveLightBikeFromCart.isHidden();
        buttonAddLightBikeToCart.click();
        buttonRemoveLightBikeFromCart.isVisible();
    }

    public void addTShirtToCart() {
        buttonRemoveTShirtFromCart.isHidden();
        buttonAddTShirtToCart.click();
        buttonRemoveTShirtFromCart.isVisible();
    }

    public void removeLightBikeFromCart() {
        buttonRemoveLightBikeFromCart.isVisible();
        buttonRemoveLightBikeFromCart.click();
        buttonRemoveLightBikeFromCart.isHidden();
        buttonRemoveLightBikeFromCart.isVisible();
    }

    public void shoppingCartBadgeIsHidden() {
        assertThat(shoppingCartBadge).isHidden();
    }

    public void shoppingCartBadgeIsVisible() {
        assertThat(shoppingCartBadge).isVisible();
    }

    public void checkAmountOfItemsInShoppingCartBadge(String expectedAmountOfItemsInCardBadge) {
        assertThat(shoppingCartBadge).hasText(expectedAmountOfItemsInCardBadge);
    }

    public void clickOnCart() {
        iconCart.click();
    }
}

