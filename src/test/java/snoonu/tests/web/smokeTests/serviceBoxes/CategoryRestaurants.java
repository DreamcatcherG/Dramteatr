package snoonu.tests.web.smokeTests.serviceBoxes;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.page_object.scenario.CategoryPageScenario.isMerchantCardVisible;
import static snoonu.helpers.page_object.scenario.NativeScenario.assertPageOpened;
import static snoonu.tests.TestData.Restaurants;
import static snoonu.helpers.page_object.scenario.MainPageScenario.*;

@Feature("Selenide_Web")
@Story("Availability of Category Pages From Service Boxes")
@Tag("smokeProd")
@Tag("Categories")
class CategoryRestaurants extends TestBase {

    @Test
    void food() {

        step("Open Web and Login in", () -> {
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