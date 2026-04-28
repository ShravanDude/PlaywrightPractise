package tests;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class SecondTest {

    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeMethod
    void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }
    @Test(enabled = false)
    void testFillForm() {
        page.navigate("https://demo.playwright.dev/todomvc");
        page.fill("#new-todo", "Learn Playwright");
        page.press("#new-todo", "Enter");
    }

    @Test
    void testAssertions() {
        page.navigate("https://google.com");
        Assert.assertTrue(page.title().toLowerCase().contains("google"));
    }

    @AfterMethod
    void teardown() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}