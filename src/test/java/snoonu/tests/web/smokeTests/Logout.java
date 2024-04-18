package snoonu.tests.web.smokeTests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.springframework.core.annotation.Order;
import snoonu.tests.TestBase;
import snoonu.utils_generate.Auth;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;
import static snoonu.tests.TestData.sNumber208;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("smoke")
@Order(2)

public class Logout extends TestBase {

    @Test
    void successfullyLogout() {

        step("Pre-login", () -> {

            open("http://snoonu.com");
            Auth.defaultProfile(sNumber208);
        });

        step("Click on the profile icon", () -> {

            $(byTestId("userPreview")).click();

        });

        step("Click on the Logout button", () -> {

            $(byTestId("logout")).click();

        });

        step("Confirm Logout", () -> {

            $(byTestId("yes")).click();
            $(byTestId("loginButton")).shouldBe(Condition.visible);

        });

    }

}

