package snoonu.tests.web.smokeTests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.LogInScenario.logginInNumberOtp;
import static snoonu.page_object.scenario.MainPageScenario.assertSuccessAuth;
import static snoonu.tests.TestData.Number208;

@Tag("smoke")
@Tag("onetest")

class Login extends TestBase {

    @Test
    void successfullyLogin() {

        step("Go to the web page", () -> {
            open(Environment.webPage);
        });

        step("Authorization", () -> {
            logginInNumberOtp(Number208);
        });

        step("Assert: Log in is successful (Profile Icon is visible)", () -> {
            assertSuccessAuth();
        });
    }
}
