package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ShippingDetailsPage {
    private final Page page;
    private final Locator firstNameInput;
    private final Locator firstNameInputError;
    private final Locator lastNameInput;
    private final Locator lastNameInputError;
    private final Locator postalCodeInput;
    private final Locator postalCodeInputError;
    private final Locator buttonContinue;
    private final Locator buttonCancel;
    private final Locator errorMessage;

    public ShippingDetailsPage(Page page) {
        this.page = page;
        this.firstNameInput = page.locator("//*[@id=\"first-name\"]");
        this.firstNameInputError = page.locator("//*[@id=\"first-name\"][contains(@class, 'input_error form_input error')]");
        this.lastNameInput = page.locator("//*[@id=\"last-name\"]");
        this.lastNameInputError = page.locator("//*[@id=\"last-name\"][contains(@class, 'input_error form_input error')]");
        this.postalCodeInput = page.locator("//*[@id=\"postal-code\"]");
        this.postalCodeInputError = page.locator("//*[@id=\"postal-code\"][contains(@class, 'input_error form_input error')]");
        this.buttonContinue = page.locator("//*[@id=\"continue\"]");
        this.buttonCancel = page.locator("//*[@id=\"cancel\"]");
        this.errorMessage = page.locator("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3");
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

    public void checkErrorMessage(String message) {
        assertThat(firstNameInputError).isVisible();
        assertThat(lastNameInputError).isVisible();
        assertThat(postalCodeInputError).isVisible();
        assertThat(errorMessage).containsText(message);
    }
}
