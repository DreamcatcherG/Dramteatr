package snoonu.tests.web.smokeTests.serviceBoxes;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.CategoryPageScenario.isMerchantCardVisible;
import static snoonu.page_object.scenario.MainPageScenario.*;
import static snoonu.page_object.scenario.NativeScenario.assertPageOpened;
import static snoonu.tests.TestData.Gifting;

@Tag("smoke")
@Tag("Categories")
class CategoryGifting extends TestBase {

    @Test
    void gifting() {

        step("Open Web", () -> {
            open(Environment.webPage);
        });

        step("Close location popup", () -> {
            closeLocationPopup();
        });

        step("Expand service boxes", () -> {
            expandServiceBoxes();
        });

        step("Go to Flowers & Chocolates", () -> {
            goToGifting();
        });

        step("Assert: URL contains 'flowers-and-gifts'", () -> {
            assertPageOpened(Gifting);
        });

        step("Assert: Verify the page has product cards", () -> {
            isMerchantCardVisible();
        });
    }
}