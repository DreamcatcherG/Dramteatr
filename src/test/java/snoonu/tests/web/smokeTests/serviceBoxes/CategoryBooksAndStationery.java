package snoonu.tests.web.smokeTests.serviceBoxes;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.helpers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.tests.TestData.BooksAndStationery;
import static snoonu.tests.TestData.Snoomart;
import static snoonu.tests.page_objects.scenario.mainPageScenario.*;

@Feature("Selenide_Web")
@Story("Availability of Category Pages From Service Boxes")
@Tag("smokeProd")
class CategoryBooksAndStationery extends TestBase {

    @Test
    void snoomart() {

        step("Open Web and Login in", () -> {
            open(Environment.webPage);
        });

        step("Close location popup and expand service boxes", () -> {
            closeLocationPopup();
            expandServiceBoxes();
        });

        step("Go to Books And Stationery", () -> {
            goToBooksAndStationery();
        });

        step("Assert: URL contains 'snoonu-market/books-and-stationery'", () -> {
            assertPageOpened(BooksAndStationery);
        });
    }
}