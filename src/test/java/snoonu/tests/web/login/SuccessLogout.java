package snoonu.tests.web.login;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.core.annotation.Order;
import snoonu.tests.TestBase;
import snoonu.utils_generate.Auth;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("web")
@Tag("signIn")


public class SuccessLogout extends TestBase {

    @Test
    @Order(1)
    void successfullyLogout() {

        step("Pre-login", () -> {

            open("http://snoonu.com");
            Auth.fillForm230();

        });

        step("Click on the profile icon", () -> {

            $(byTestId("userPreview")).click();

        });

        step("Click on the Logout button", () -> {

            $(byTestId("logout")).click();

        });

        step("Confirm Logout", () -> {

            $(byTestId("yes")).click();
            $(byTestId("yes")).shouldBe(disappear);

        });

    }
}


