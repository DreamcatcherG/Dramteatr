package snoonu.tests.web.login;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.tests.TestBase;
import snoonu.utils_generate.Auth;
import snoonu.utils_generate.AwtRobot;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("web")
@Tag("login")

class SuccessLogin extends TestBase {

    @Test
    void successLogin() {

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
