package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Main Category pages")
@Tag("smoke")
class CatPageAvailSNOOFLOW extends TestBase {


    @Test
    void catPageAvailSNOOFLOW() {

        step("Opening the web page", () -> {

            open("http://snoonu.com");

        });

        step("Go to category of snooflower", () -> {

            $(byAttribute("data-analytic-event-content", "snooflower-new")).click();

        });

        step("Assert: URL contains 'flowers-and-gifts/snooflower-new'", () -> {

            String expectedUrlPart = "https://snoonu.com/flowers-and-gifts/snooflower-new";

            $("meta[property='og:url']").shouldHave(attribute("content", expectedUrlPart));

        });

        step("Assert: the page is opened", () -> {

            $("body").shouldHave(text("Snooflower"));
            $(byTestId("subcategory")).shouldBe(appear);

        });

    }
}