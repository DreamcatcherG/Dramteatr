package snoonu.tests.web.smokeTests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.core.annotation.Order;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Main Category pages")
@Tag("smoke")
class CategoryKids extends TestBase {


    @Test
    void kids() {

        step("Opening the web page", () -> {

            open("http://snoonu.com");

        });

        step("Close location popup and open category list", () -> {

            if ($(byTestId("selectLocation")).exists()) {

                $(byTestId("locationSelector")).click();


            } else {

            }

            $(byClassName("ShowMore_wrapper__cbfzq")).click();
            $("p.Typography_p10__teZqm.ShowMore_label__56Abc").shouldHave(Condition.text("Less"));

        });

        step("Go to category of kids and stationery", () -> {

            $(byAttribute("data-analytic-event-content", "kids-and-stationery")).click();

        });

        step("Assert: URL contains 'kids-and-stationery'", () -> {

            String expectedUrlPart = "https://snoonu.com/kids-and-stationery";

            $("meta[property='og:url']").shouldHave(attribute("content", expectedUrlPart));

        });

        step("Assert: the page is opened", () -> {

            $("body").shouldHave(text("Kids & Stationery"));
            $(byTestId("merchantCard")).shouldBe(appear);

        });

    }
}