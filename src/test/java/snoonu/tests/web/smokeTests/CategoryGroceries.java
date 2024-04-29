package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.helpers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.tests.TestData.Groceries;
import static snoonu.tests.page_objects.scenario.mainPageScenario.*;

@Feature("Selenide_Web")
@Story("Main Category pages")
@Tag("smokeProd")
class CategoryGroceries extends TestBase {

    @Test
    void grocery() {

        step("Open Web and Login in", () -> {
            open(Environment.webPage);
        });

        step("Close location popup and expand servise boxes", () -> {
            closeLocationPopup();
            expandServiceBoxes();
        });

        step("Go to category of beauty and perfumes", () -> {
            goToGroceries();
        });

        step("Assert: URL contains 'beauty-and-perfumes'", () -> {
            assertPageOpened(Groceries);
        });
    }
}