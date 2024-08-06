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
import static snoonu.tests.TestData.BooksAndStationery;

@Tag("smoke")
@Tag("Categories")
class CategoryBooksAndStationery extends TestBase {

    @Test
    void booksAndStationery() {

        step("Open Web", () -> {
            open(Environment.webPage);
        });

        step("Close location popup", () -> {
            closeLocationPopup();
        });

        step("Expand service boxes", () -> {
            expandServiceBoxes();
        });

        step("Go to Books And Stationery", () -> {
            goToBooksAndStationery();
        });

        step("Assert: URL contains 'snoonu-market/books-and-stationery'", () -> {
            assertPageOpened(BooksAndStationery);
        });

        step("Assert: Verify the page has product cards", () -> {
            findBestSellingCard();
        });
    }
}