package snoonu.tests.web.smokeTests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.core.annotation.Order;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(10)
@Feature("Selenide-appium web, iOS and Android tests")
@Story("Main Category pages")
@Tag("smoke")
class CategoryFood extends TestBase {


    @Test
    void food() {

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