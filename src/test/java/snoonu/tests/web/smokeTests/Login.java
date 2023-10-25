package snoonu.tests.web.smokeTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.tests.TestBase;
import snoonu.utils_generate.Auth;
import snoonu.utils_generate.AwtRobot;

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

        step("Go to the web page", () -> {

            open("http://snoonu.com");

        });

        step("Authorisation", () -> {

            Auth.fillForm230();

        });

        step("Assert: Log in is successful", () -> {

            $(byTestId("userPreview")).shouldBe(visible);

        });

    }
}
