package snoonu.tests.web.smokeTests.serviceBoxes;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.CategoryPageScenario.findBestSellingCard;
import static snoonu.page_object.scenario.NativeScenario.assertPageOpened;
import static snoonu.tests.TestData.SportsAndOutdoors;
import static snoonu.page_object.scenario.MainPageScenario.*;

@Tag("smoke")
@Tag("Categories")
class CategorySportsAndOutdoors extends TestBase {

    @Test
    void sportsAndOutdoors() {

        step("Open Web", () -> {
            open(Environment.webPage);
        });

        step("Close location popup", () -> {
            closeLocationPopup();
        });

        step("Expand service boxes", () -> {
            expandServiceBoxes();
        });

        step("Go to Sports And Outdoors", () -> {
            goToSportsAndOutdoors();
        });

        step("Assert: URL contains 'snoonu-market/sport-and-outdoors'", () -> {
            assertPageOpened(SportsAndOutdoors);
        });

        step("Assert: Verify the page has product cards", () -> {
            findBestSellingCard();
        });
    }
}