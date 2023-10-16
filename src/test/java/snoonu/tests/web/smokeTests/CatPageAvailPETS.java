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
class CatPageAvailPETS extends TestBase {


    @Test
    void catPageAvailPETS() {

        step("Opening the web page", () -> {

            open("http://snoonu.com");

        });

        step("Go to category of pets", () -> {

            $(byAttribute("data-analytic-event-content", "pets")).click();

        });

        step("Assert: URL contains 'pets'", () -> {

            String expectedUrlPart = "https://snoonu.com/pets";

            $("meta[property='og:url']").shouldHave(attribute("content", expectedUrlPart));

        });

        step("Assert: the page is opened", () -> {

            $("body").shouldHave(text("Pets"));
            $(byTestId("merchantCard")).shouldBe(appear);

        });

    }
}