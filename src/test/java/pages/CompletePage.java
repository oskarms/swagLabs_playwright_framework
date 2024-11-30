package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CompletePage {
    private final Page page;
    private final Locator imageCompleteOrder;
    private final Locator buttonBackHome;
    private final Locator completeHeader;

    public CompletePage(Page page) {
        this.page = page;
        this.imageCompleteOrder = page.locator("//*[@id=\"checkout_complete_container\"]/img");
        this.buttonBackHome = page.locator("//*[@id=\"back-to-products\"]");
        this.completeHeader = page.locator("//*[@id=\"checkout_complete_container\"]/h2");
    }

    public void checkImageComplete() {
        assertThat(imageCompleteOrder).isVisible();
    }

    public void checkCompleteHeader() {
        assertThat(completeHeader).hasText("Thank you for your order!");
    }

    public void clickBackHome() {
        buttonBackHome.click();
    }
}
