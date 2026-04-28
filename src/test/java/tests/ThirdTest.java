package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ThirdTest {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeMethod
    void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    } 

    @Test
    void testAssertions() {
        page.navigate("https://www.naukri.com/");
        Assert.assertTrue(page.title().toLowerCase().contains("jobs"));
    }

    @AfterMethod
    void teardown() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
