package snoonu.tests.web.smokeTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Main Category pages")
@Tag("smoke")
class CatPageAvailREST extends TestBase {


    @Test
    void catPageAvailREST() {

        step("Opening the web page", () -> {

            open("http://snoonu.com");

        });

        step("Go to category of restaurants", () -> {

            $(byAttribute("data-analytic-event-content", "restaurants")).click();

        });

        step("Assert: URL contains 'restaurants'", () -> {

            String expectedUrlPart = "https://snoonu.com/restaurants";

            $("meta[property='og:url']").shouldHave(attribute("content", expectedUrlPart));

        });

        step("Assert: the page is opened", () -> {

            $("body").shouldHave(text("Restaurants & Cafes"));
            $(byTestId("merchantCard")).shouldBe(appear);

        });

    }
}