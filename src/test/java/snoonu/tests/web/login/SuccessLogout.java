package snoonu.tests.web.login;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import snoonu.tests.TestBase;
import snoonu.utils_generate.Auth;
import snoonu.utils_generate.awtRobot;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("web")
@Tag("login")

public class SuccessLogout extends TestBase {

    @Test
    @AllureId("4242")
    @DisplayName("Logout functionality(AutoTests)")
    @Epic("SNW-389 AutoTests")
    @Owner("mikhail")

    void successfullyLogout() {

        step("Pre-login");

            open("http://snoonu.com");
            Auth.fillFormOth();

        step("Click on the profile icon");

            $(byTestId("userPreview")).click();

        step("Click on the Logout button");

            $(byTestId("logout")).click();

        step("Confirm Logout");

            $(byTestId("yes")).click();

    }
}

