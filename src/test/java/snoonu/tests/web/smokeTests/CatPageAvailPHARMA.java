package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Main Category pages")
@Tag("smoke")
class CatPageAvailPHARMA extends TestBase {


    @Test
    void catPageAvailPHARMA() {

        step("Opening the web page", () -> {

            open("http://snoonu.com");

        });

        step("Go to category of pharmacy", () -> {

            $(byAttribute("data-analytic-event-content", "pharmacy")).click();

        });

        step("Assert: URL contains 'pharmacy'", () -> {

            String expectedUrlPart = "https://snoonu.com/pharmacy";

            $("meta[property='og:url']").shouldHave(attribute("content", expectedUrlPart));

        });

        step("Assert: the page is opened", () -> {

            $("body").shouldHave(text("Health & Wellness"));
            $(byTestId("merchantCard")).shouldBe(appear);

        });

    }
}