package snoonu.tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.tests.TestBase;
import snoonu.utils_generate.DataParamsDev;
import snoonu.utils_generate.LoadPage;
import snoonu.utils_generate.XPathUtil;
import snoonu.utils_generate.awtRobot;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("")

class DelCreditCard extends TestBase {

    @Test
    void delCreditCard() {

        step("Go to login page", () -> {

            open(DataParamsDev.urlDev);
//            open("http://snoonu.com");


        });

        step("Click on the Login button", () -> {

            $(byTestId("loginButton")).shouldBe(visible).click();

        });

        step("Enter (phone number, otp (current date)", () -> {

            $(byName("phoneNumber")).sendKeys("21343336");
//            $(byName("phoneNumber")).sendKeys("21343230");
            $(byTestId("loginContinue")).click();
            LoadPage.pageInit();

        });

        step("Enter OTP (Actual date)", () -> {

            $(byName("pin")).click();
            awtRobot.entOtp();

        });

        step("Open account modal window)", () -> {

            $(byTestId("userPreview")).click();

        });

        step("Open saved card window and delete a credit card)", () -> {

            $(byTestId("savedCards")).click();
            LoadPage.pageInit();
            XPathUtil.PayСardField();
            XPathUtil.СardDelBut();
            $(byTestId("yes")).shouldBe(appear).click();
            LoadPage.pageInit();

        });

    }
}

