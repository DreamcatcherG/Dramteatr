package snoonu.tests.web.smokeTests.serviceBoxes;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.CategoryPageScenario.isMerchantCardVisible;
import static snoonu.page_object.scenario.NativeScenario.assertPageOpened;
import static snoonu.tests.TestData.Pharmacy;
import static snoonu.page_object.scenario.MainPageScenario.*;

@Tag("smoke")
@Tag("Categories")
class CategoryPharmacy extends TestBase {

    @Test
    void pharmacy() {

        step("Open Web", () -> {
            open(Environment.webPage);
        });

        step("Close location popup", () -> {
            closeLocationPopup();
        });

        step("Go to Pharmacy", () -> {
            goToPharmacy();
        });

        step("Assert: URL contains 'pharmacy'", () -> {
            assertPageOpened(Pharmacy);
        });

        step("Assert: Merchant cards is visible on the category page", () -> {
            isMerchantCardVisible();
        });
    }
}