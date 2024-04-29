package snoonu.tests.web.smokeTests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import snoonu.tests.TestBase;
import snoonu.tests.page_objects.scenario.logInScenario;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;
import static snoonu.tests.TestData.Number208;

@Feature("Selenide_Web")
@Story("Smoke tests Web")
@Tag("smoke")

public class Logout extends TestBase {

    @Test
    void successfullyLogout() {

        step("Pre-login", () -> {

            open("http://snoonu.com");
            logInScenario.defaultProfile(Number208);
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

