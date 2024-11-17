package core;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.BrowserException;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected String url = "https://www.saucedemo.com/";

    @BeforeClass
    @Parameters({"browserParameter"})
    protected void init(@Optional("chrome") String browserParameter) throws BrowserException {
        playwright = Playwright.create();
        System.out.println(browserParameter);
        browser = runInExpectedBrowser(browserParameter);
    }

    private Browser runInExpectedBrowser(String browserParameter) throws BrowserException {
        switch (browserParameter) {
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                throw new BrowserException("Browser is not recognize");
        }
        return browser;
    }

    @AfterClass
    protected void close() {
        browser.close();
    }
}
