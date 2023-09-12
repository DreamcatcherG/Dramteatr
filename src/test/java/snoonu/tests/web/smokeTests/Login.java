package snoonu.tests.web.smokeTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.tests.TestBase;
import snoonu.utils_generate.awtRobot;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("smoke")
class Login extends TestBase {

    @Test
    void successfullyLogin() {

        step("Go to login page", () -> {

            open("http://snoonu.com");

        });

        step("Click on the Login button", () -> {

            $(byTestId("loginButton")).shouldBe(visible).click();

        });

        step("Enter (phone number, otp (current date)", () -> {

            $(byName("phoneNumber")).sendKeys("21343286");
            $(byTestId("loginContinue")).click();

        });

        step("Enter OTP (Actual date)", () -> {

            $(byName("pin")).click();
            awtRobot.entOtp();

        });

    }
}
