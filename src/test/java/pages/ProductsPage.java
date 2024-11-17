package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductsPage {
    private final Page page;
    private final Locator appLogo;
    private final Locator inventoryItem;
    private final Locator inventoryItemLabel;
    private final Locator buttonAddToCartBackpack;
    private final Locator shoppingCartBadge;
    private final Locator titlePage;
    private final Locator iconCart;

    public ProductsPage(Page page) {
        this.page = page;
        this.appLogo = page.locator("//*[@id=\"header_container\"]/div/div/div[contains(@class, 'app_logo')]");
        this.inventoryItem = page.locator("//div[contains(@class, 'inventory_item')]");
        this.inventoryItemLabel = page.locator("//div[contains(@class, 'inventory_item_label')]");
        this.buttonAddToCartBackpack = page.locator("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
        this.shoppingCartBadge = page.locator("//*[@id=\"shopping_cart_container\"]/a/span");
        this.titlePage = page.locator("//*[@id=\"header_container\"]/div[2]/span");
        this.iconCart = page.locator("//*[@id=\"shopping_cart_container\"]/a");
    }

    public void checkAppLogo(String textOfLogo){
        assertThat(appLogo).containsText(textOfLogo);
    }
    public void checkNameOfThePage(String titleOfPage){
        assertThat(titlePage).containsText(titleOfPage);
    }
    public void addBackpackToBasket(){
        buttonAddToCartBackpack.click();
    }
    public void shoppingCartBadgeNotVisible(){
        assertThat(shoppingCartBadge).isHidden();
    }
    public void shoppingCartBadgeIsVisible(){
        assertThat(shoppingCartBadge).isVisible();
    }
    public void checkAmountOfItemsInShoppingCartBadge(String expectedAmountOfItemsInCardBadge){
        assertThat(shoppingCartBadge).hasText(expectedAmountOfItemsInCardBadge);
    }
    public void clickOnCart() {
        iconCart.click();
    }
}

