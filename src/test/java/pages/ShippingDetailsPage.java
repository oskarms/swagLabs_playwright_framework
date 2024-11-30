package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ShippingDetailsPage {
    private final Page page;
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator postalCodeInput;
    private final Locator buttonContinue;
    private final Locator buttonCancel;

    public ShippingDetailsPage(Page page) {
        this.page = page;
        this.firstNameInput = page.locator("//*[@id=\"first-name\"]");
        this.lastNameInput = page.locator("//*[@id=\"last-name\"]");
        this.postalCodeInput = page.locator("//*[@id=\"postal-code\"]");
        this.buttonContinue = page.locator("//*[@id=\"continue\"]");
        this.buttonCancel = page.locator("//*[@id=\"cancel\"]");
    }

    public void checkInputsAreEmpty() {
        assertThat(firstNameInput).isEmpty();
        assertThat(lastNameInput).isEmpty();
        assertThat(postalCodeInput).isEmpty();
    }

    public void addFirstName(String firstName) {
        firstNameInput.fill(firstName);
    }

    public void addLastName(String lastName) {
        lastNameInput.fill(lastName);
    }

    public void addPostalCode(String postalCode) {
        postalCodeInput.fill(postalCode);
    }

    public void clickCancel() {
        buttonCancel.click();
    }
    public void clickContinue() {
        buttonContinue.click();
    }
}
