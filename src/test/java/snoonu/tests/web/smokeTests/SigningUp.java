package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.helpers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.tests.TestData.Number272;
import static snoonu.tests.page_objects.scenario.logInScenario.defaultProfile;
import static snoonu.tests.page_objects.scenario.mainPageScenario.*;
import static snoonu.tests.page_objects.scenario.profileScenario.*;

@Feature("Selenide_Web")
@Story("Smoke tests Web")
@Tag("smokeStage")

public class SigningUp extends TestBase {

    @Test
    void signingUpProfile() {

        step("Preconditions: Open Web Page login and remove account", () -> {
            open(Environment.webPage);
            defaultProfile(Number272);
            assertSuccessAuth();
            assertIsOngoingOrders();
            goToProfile();
            goToMyAccount();
            goToDeleteAccount();
            confirmDeleteAccount();
            assertProfileDeleted();
        });

        step("Registration of New Profile", () -> {
            defaultProfile(Number272);
            registerNewProfile();
        });

        step("Assert Profile is created", () -> {
            assertSuccessAuth();
        });
    }
}
