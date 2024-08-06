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
import static snoonu.tests.TestData.Restaurants;

@Tag("smoke")
@Tag("Categories")
class CategoryRestaurants extends TestBase {

    @Test
    void restaurants() {

        step("Open Web", () -> {
            open(Environment.webPage);
        });

        step("Close location popup", () -> {
            closeLocationPopup();
        });

        step("Expand service boxes", () -> {
            expandServiceBoxes();
        });

        step("Go to Food category", () -> {
            goToRestaurants();
        });

        step("Assert: URL contains 'restaurants'", () -> {
            assertPageOpened(Restaurants);
        });

        step("Assert: Merchant cards is visible on the category page", () -> {
            isMerchantCardVisible();
        });
    }
}