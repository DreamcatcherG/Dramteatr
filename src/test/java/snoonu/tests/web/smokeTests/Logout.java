package snoonu.tests.web.smokeTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.tests.TestData.Number208;
import static snoonu.page_object.scenario.LogInScenario.logginInNumberOtp;
import static snoonu.page_object.scenario.MainPageScenario.assertLoginBtnVisible;
import static snoonu.page_object.scenario.MainPageScenario.goToProfile;
import static snoonu.page_object.scenario.ProfileScenario.goToLogOutAndConfirm;

@Feature("Selenide_Web")
@Story("Smoke tests Web")
@Tag("smokeStage")

public class Logout extends TestBase {

    @Test
    void successfullyLogout() {

        step("Pre-Conditions Open Web Page and logging in", () -> {
            open(Environment.webPage);
            logginInNumberOtp(Number208);
        });

        step("Go To Profile", () -> {
            goToProfile();
        });

        step("Go To Logout button and Confirm", () -> {
            goToLogOutAndConfirm();
        });

        step("Assert Logout was completed", () -> {
            assertLoginBtnVisible();
        });

    }

}

