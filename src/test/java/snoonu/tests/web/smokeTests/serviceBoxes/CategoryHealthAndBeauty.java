package snoonu.tests.web.smokeTests.serviceBoxes;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.CategoryPageScenario.findBestSellingCard;
import static snoonu.page_object.scenario.MainPageScenario.*;
import static snoonu.page_object.scenario.NativeScenario.assertPageOpened;
import static snoonu.tests.TestData.HealthAndBeauty;

@Tag("smoke")
@Tag("Categories")
class CategoryHealthAndBeauty extends TestBase {

    @Test
    void healthAndBeauty() {

        step("Open Web", () -> {
            open(Environment.webPage);
        });

        step("Close location popup", () -> {
            closeLocationPopup();
        });

        step("Go to Health & Beauty", () -> {
            goToHealthAndBeauty();
        });

        step("Assert: URL contains 'snoonu-market/health-and-beauty'", () -> {
            assertPageOpened(HealthAndBeauty);
        });

        step("Assert: Verify the page has product cards", () -> {
            findBestSellingCard();
        });
    }
}