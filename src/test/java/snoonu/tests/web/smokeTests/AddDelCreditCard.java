package snoonu.tests.web.smokeTests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.core.annotation.Order;
import snoonu.helpers.Css;
import snoonu.tests.TestBase;
import snoonu.utils_generate.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;
import static snoonu.tests.TestData.sNumber208;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("smoke")

class AddDelCreditCard extends TestBase {

    @Test
    void addCreditCard() {

        step("Go to login page", () -> {

            open(DataParamsDev.urlDev);
//            open("http://snoonu.com");

        });

        step("Click on the Login button", () -> {

            $(byTestId("loginButton")).shouldBe(visible).click();

        });

        step("Enter (phone number, otp (current date)", () -> {

            Auth.defaultProfile(sNumber208);
        });

        step("Open account modal window)", () -> {

            $(byTestId("userPreview")).click();

        });

        step("Open saved card window and adding a credit card", () -> {

            $(byTestId("savedCards")).shouldBe(appear).click();
            $(byTestId("addNewCard")).shouldBe(visible);

            if ($(Css.byId("credit-card-list-credit-card-number"))
                    .should(Condition.exist)
                    .shouldHave(text("•••• 1111"))
                    .exists()) {

                $(Css.byId("delete-card-btn")).click();
                $(byTestId("yes")).shouldBe(appear).click();
                $(byTestId("yes")).shouldBe(disappear);

            } else {

            }

            $(byTestId("addNewCard")).click();
//            $(byName("number")).setValue("4242 4242 4242 4242");
            $(byName("number")).setValue("4111 1111 1111 1111");
            $(byName("date")).setValue(TextGenerator.getRandomCardData(4, 4));
            $(byName("code")).setValue(TextGenerator.getRandomCardCvv(3, 3));
            $(byTestId("saveCard")).click();
            $(byTestId("saveCard")).should(disappear);

        });

        step("Confirm adding", () -> {

            switchTo().frame($(byId("challengeFrame")));
            $("#acssubmit").click();
//            $("h2").shouldHave(text("Successfully Added Credit/Debit Card"));
            sleep(1000);
            switchTo().defaultContent();
            Xpath.Close3DS();
            $(Css.byId("credit-card-list-credit-card-number")).shouldHave(text("•••• 1111"));

        });

    }
}

