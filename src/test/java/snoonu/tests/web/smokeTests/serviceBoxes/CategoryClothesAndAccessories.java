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
import static snoonu.tests.TestData.ClothesAndAccessories;

@Tag("smoke")
@Tag("categories")
class CategoryClothesAndAccessories extends TestBase {

    @Test
    void clothesAndAccessories() {

        step("Open Web", () -> {
            open(Environment.webPage);
        });

        step("Close location popup", () -> {
            closeLocationPopup();
        });

        step("Go to Clothes And Accessories", () -> {
            goToClothesAndAccessories();
        });

        step("Assert: URL contains 'snoonu-market/clothes-and-accessories'", () -> {
            assertPageOpened(ClothesAndAccessories);
        });

        step("Assert: Verify the page has product cards", () -> {
            findBestSellingCard();
        });
    }
}