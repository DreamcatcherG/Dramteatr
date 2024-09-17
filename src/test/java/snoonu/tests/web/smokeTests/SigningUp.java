package snoonu.tests.web.smokeTests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.LogInScenario.enterNumberOtp;
import static snoonu.page_object.scenario.MainPageScenario.*;
import static snoonu.page_object.scenario.ProfileScenario.*;
import static snoonu.tests.TestData.Number272;

@Tag("smoke")
@Tag("signup")

public class SigningUp extends TestBase {

    @Test
    void signingUpProfile() {

        step("Preconditions: Open Web Page login and remove account", () -> {
            open(Environment.webPage);
            enterNumberOtp(Number272);
            assertSuccessAuth();
            assertIsOngoingOrders();
            goToProfile();
            goToMyAccount();
            goToDeleteAccount();
            confirmDeleteAccount();
            assertLoginBtnVisible();
        });

        step("Registration of New Profile", () -> {
            enterNumberOtp(Number272);
            registerNewProfile();
        });

        step("Assert Profile is created", () -> {
            assertSuccessAuth();
        });
    }
}
