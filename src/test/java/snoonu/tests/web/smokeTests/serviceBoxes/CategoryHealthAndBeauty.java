package snoonu.tests.web.smokeTests.serviceBoxes;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.CategoryPageScenario.findAProductCardInCategoryPage;
import static snoonu.page_object.scenario.NativeScenario.assertPageOpened;
import static snoonu.tests.TestData.HealthAndBeauty;
import static snoonu.page_object.scenario.MainPageScenario.*;

@Feature("Selenide_Web")
@Story("Availability of Category Pages From Service Boxes")
@Tag("smokeProd")
@Tag("Categories")
class CategoryHealthAndBeauty extends TestBase {

    @Test
    void beauty() {

        step("Open Web and Login in", () -> {
            open(Environment.webPage);
        });

        step("Close location popup", () -> {
            closeLocationPopup();
        });

        step("Expand service boxes", () -> {
            expandServiceBoxes();
        });

        step("Go to Health & Beauty", () -> {
            goToHealthAndBeauty();
        });

        step("Assert: URL contains 'snoonu-market/health-and-beauty'", () -> {
            assertPageOpened(HealthAndBeauty);
        });

        step("Assert: Verify the page has product cards", () -> {
            findAProductCardInCategoryPage();
        });
    }
}