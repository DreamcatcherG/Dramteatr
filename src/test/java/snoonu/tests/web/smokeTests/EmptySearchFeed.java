package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.springframework.core.annotation.Order;
import snoonu.tests.TestBase;
import snoonu.utils_generate.RandomUtils;
import snoonu.utils_generate.TextGenerator;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(21)
@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("smoke")
class EmptySearchFeed extends TestBase {

    @Test
    void emptySearchFeed() {

        step("Go to web page", () -> {

            open("http://snoonu.com");


        });

        step("Search fake product", () -> {

            $(byName("search")).shouldBe(visible).setValue("капибара");
            $(byClassName("SearchButton_button__8GVDU")).click();

        });

        step("Go to 'Write to us'", () -> {

            $(By.cssSelector("h2.EmptyResult_title__cfJZp")).shouldHave(exactText("Nothing has been found"));
            $(byXpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/h5[1]")).click();

        });

        step("Entering request", () -> {

            $(byName("comments")).sendKeys(TextGenerator.getRandomText(1, 15));
            $(byTestId("sendFeedback")).click();
            $(By.cssSelector("h2.EmptyResult_title__cfJZp")).shouldHave(exactText("Nothing has been found"));

        });

    }
}

