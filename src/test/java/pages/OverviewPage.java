package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OverviewPage {
    private final Page page;
    private final Locator totalPriceWithoutTax;
    private final Locator taxPrice;
    private final Locator totalPriceWithTax;
    private final Locator buttonFinish;
    private final Locator buttonCancel;

    public OverviewPage(Page page) {
        this.page = page;
        this.totalPriceWithoutTax = page.locator("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]");
        this.taxPrice = page.locator("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
        this.totalPriceWithTax = page.locator("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]");
        this.buttonFinish = page.locator("//*[@id=\"finish\"]");
        this.buttonCancel = page.locator("//*[@id=\"cancel\"]");
    }

    public void checkTotalPriceWithoutTax(String totalPriceWithoutTaxExpected) {
        assertThat(totalPriceWithoutTax).hasText("Item total: $" + totalPriceWithoutTaxExpected);
    }

    public void checkTax(String tax) {
        assertThat(taxPrice).hasText("Tax: $" + tax);
    }

    public void checkTotalPriceWithTax(String totalPriceWithTaxExpected) {
        assertThat(totalPriceWithTax).hasText("Total: $" + totalPriceWithTaxExpected);
    }

    public void clickFinish() {
        buttonFinish.click();
    }

    public void clickCancel() {
        buttonCancel.click();
    }
}
