package snoonu.tests.web.smokeTests.serviceBoxes;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.MerchantPageScenario.findAProductCardInMerchantPage;
import static snoonu.page_object.scenario.MerchantPageScenario.findClickSubcategoryCardInMerchant;
import static snoonu.page_object.scenario.NativeScenario.assertPageOpened;
import static snoonu.tests.TestData.Snoomart;
import static snoonu.page_object.scenario.MainPageScenario.*;

@Tag("smoke")
@Tag("categories")
class CategorySnoomart extends TestBase {

    @Test
    void snoomart() {

        step("Open Web", () -> {
            open(Environment.webPage);
        });

        step("Close location popup", () -> {
            closeLocationPopup();
        });

        step("Go to Snoomart", () -> {
            goToSnoomart();
        });

        step("Assert: URL contains 'groceries/snoomart'", () -> {
            assertPageOpened(Snoomart);
        });

        step("Find and Click to a subcategory card", () -> {
            findClickSubcategoryCardInMerchant();
        });

        step("Assert: Product cars is appeared", () -> {
            findAProductCardInMerchantPage();
        });

    }
}