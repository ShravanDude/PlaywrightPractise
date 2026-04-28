package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void launchBrowserTest() {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
            );

            Page page = browser.newPage();
            page.navigate("https://google.com");

            System.out.println("Title is: " + page.title());

            browser.close();
        }
    }
}