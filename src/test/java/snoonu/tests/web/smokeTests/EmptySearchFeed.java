package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.page_object.scenario.MainPageScenario.*;

@Feature("Selenide_Web")
@Story("Smoke tests Web")
@Tag("smokeStage")
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

        step("Entering and sending a request", () -> {
            writeAndSendRequest();
        });
    }
}

