package snoonu.tests.web.smokeTests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.LogInScenario.enterNumberOtp;
import static snoonu.page_object.scenario.MainPageScenario.assertLoginBtnVisible;
import static snoonu.page_object.scenario.MainPageScenario.goToProfile;
import static snoonu.page_object.scenario.ProfileScenario.goToLogOutAndConfirm;
import static snoonu.tests.TestData.Number208;

@Tag("smoke")
@Tag("logout")

public class Logout extends TestBase {

    @Test
    void successfullyLogout() {

        step("Pre-Conditions Open Web Page and logging in", () -> {
            open(Environment.webPage);
            enterNumberOtp(Number208);
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

