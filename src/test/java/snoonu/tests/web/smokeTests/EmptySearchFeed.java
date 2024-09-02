package snoonu.tests.web.smokeTests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.MainPageScenario.*;

@Tag("smoke")

class EmptySearchFeed extends TestBase {

    @Test
    void emptySearchFeed() {

        step("Go to web page", () -> {
            open(Environment.webPage);
        });

        step("Search fake product", () -> {
            wrongGlobalSearchRequest();
        });

        step("Assert Nothing found", () -> {
            assertNothingFoundResult();
        });

        step("Go to 'Write to us' and send a request", () -> {
            goToWriteToUsBtn();
        });
    }
}

