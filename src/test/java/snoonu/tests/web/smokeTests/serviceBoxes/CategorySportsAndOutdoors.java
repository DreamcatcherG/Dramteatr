package snoonu.tests.web.smokeTests.serviceBoxes;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.NativeScenario.assertPageOpened;
import static snoonu.tests.TestData.SportsAndOutdoors;
import static snoonu.page_object.scenario.MainPageScenario.*;

@Feature("Selenide_Web")
@Story("Availability of Category Pages From Service Boxes")
@Tag("smokeProd")
@Tag("Categories")
class CategorySportsAndOutdoors extends TestBase {

    @Test
    void sportsAndOutdoors() {

        step("Open Web and Login in", () -> {
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
    }
}