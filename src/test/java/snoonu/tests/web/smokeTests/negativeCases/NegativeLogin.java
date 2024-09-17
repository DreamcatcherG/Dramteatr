package snoonu.tests.web.smokeTests.negativeCases;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.LogInScenario.enterNumberOtp;
import static snoonu.page_object.scenario.LogInScenario.negativeEnterNumberOtp;
import static snoonu.page_object.scenario.MainPageScenario.assertOtpWrong;
import static snoonu.tests.TestData.Number208;
import static snoonu.tests.TestData.Number276;
import static snoonu.utils_generate.AwtRobot.wrongEntOtp;

@Tag("smoke")
@Tag("login")

class NegativeLogin extends TestBase {

    @Test
    void successfullyLogin() {

        step("Go to the web page", () -> {
            open(Environment.webPage);
        });

        step("Authorization", () -> {
            negativeEnterNumberOtp(Number276);
        });

        step("Enter wrong OTP", () -> {
            wrongEntOtp();
        });

        step("Assert: Otp is wrong, show a message", () -> {
            assertOtpWrong();
        });
    }
}
