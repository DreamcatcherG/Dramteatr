package snoonu.utils_generate;

import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.Wait;

public class LoadPage {

    public static void pageInit() { // LoadPage.pageInit();

        Wait().until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));

    }
}
