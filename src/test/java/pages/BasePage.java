package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BasePage {
    private final Page page;
    private final Locator appLogo;
    private final Locator titlePage;
    private final Locator buttonOpenMenu;
    private final Locator dashboardMenu;
    private final Locator buttonResetAppState;
    private final Locator buttonCloseMenu;

    public BasePage(Page page) {
        this.page = page;
        this.appLogo =  page.locator("//*[@id=\"header_container\"]/div/div/div[contains(@class, 'app_logo')]");
        this.titlePage =  page.locator("//*[@id=\"header_container\"]/div[2]/span");
        this.buttonOpenMenu =  page.locator("//*[@id=\"react-burger-menu-btn\"]");
        this.dashboardMenu =  page.locator("//*[@id=\"menu_button_container\"]/div/div[2]");
        this.buttonResetAppState =  page.locator("//*[@id=\"reset_sidebar_link\"]");
        this.buttonCloseMenu =  page.locator("//*[@id=\"react-burger-cross-btn\"]");
    }
    public void resetAppState(){
        buttonResetAppState.click();
    }
    public void openMenu(){
        assertThat(dashboardMenu).isHidden();
        buttonOpenMenu.click();
        assertThat(dashboardMenu).isVisible();
    }
    public void checkTitleOfThePage(String titleOfPage){
        assertThat(titlePage).containsText(titleOfPage);
    }
    public void checkAppLogo(String textOfLogo) {
        assertThat(appLogo).containsText(textOfLogo);
    }
    public void closeMenu(){
        assertThat(dashboardMenu).isVisible();
        buttonCloseMenu.click();
        assertThat(dashboardMenu).isHidden();
    }
}