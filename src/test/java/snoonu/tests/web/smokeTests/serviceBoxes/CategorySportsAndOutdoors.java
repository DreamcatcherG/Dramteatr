package snoonu.tests.web.smokeTests.serviceBoxes;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.helpers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.tests.TestData.SportsAndOutdoors;
import static snoonu.tests.page_objects.scenario.mainPageScenario.*;

@Feature("Selenide_Web")
@Story("Availability of Category Pages From Service Boxes")
@Tag("smokeProd")
class CategorySportsAndOutdoors extends TestBase {

    @Test
    void sportsAndOutdoors() {

        step("Open Web and Login in", () -> {
            open(Environment.webPage);
        });

        step("Close location popup and expand service boxes", () -> {
            closeLocationPopup();
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