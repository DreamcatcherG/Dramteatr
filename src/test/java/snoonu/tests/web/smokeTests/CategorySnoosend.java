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
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Main Category pages")
@Tag("smoke")
class CategorySnoosend extends TestBase {


    @Test
    void snoosend() {

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

        step("Go to category of snoosend", () -> {

            $(byXpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();

        });

        step("Assert: QR code is visible", () -> {

           $(byXpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]")).shouldHave(text("Your personal door-to-door delivery service"));
           $(byXpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]/img[1]")).shouldBe(visible);

        });



    }
}