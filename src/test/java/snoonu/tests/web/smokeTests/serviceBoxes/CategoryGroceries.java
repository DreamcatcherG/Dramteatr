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
import static snoonu.tests.TestData.Groceries;

@Tag("smoke")
@Tag("categories")
class CategoryGroceries extends TestBase {

    @Test
    void grocery() {

        step("Open Web", () -> {
            open(Environment.webPage);
        });

        step("Close location popup", () -> {
            closeLocationPopup();
        });

        step("Go to Groceries", () -> {
            goToGroceries();
        });

        step("Assert: URL contains 'groceries'", () -> {
            assertPageOpened(Groceries);
        });

        step("Assert: Merchant cards is visible on the category page", () -> {
            isMerchantCardVisible();
        });
    }
}