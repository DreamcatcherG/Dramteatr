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
import static snoonu.tests.page_objects.scenario.mainPageScenario.assertSuccessAuth;
import static snoonu.tests.page_objects.scenario.profileScenario.*;

@Feature("Selenide_Web")
@Story("Smoke tests Web")
@Tag("smokeStage")

class EditProfile extends TestBase {

    @Test
    void editProfile() {

        step("Go to the web page", () -> {
            open(Environment.webPage);
        });

        step("Authorization", () -> {
            defaultProfile(Number272);
        });

        step("Assert: Logging in is successful", () -> {
            assertSuccessAuth();
        });

        step("Go to Profile)", () -> {
            goToMyAccount();
        });

        step("Change Profile name", () -> {
            changeProfileName();
        });

        step("Assert Profile name changed", () -> {
            assertProfileNameChanged();
        });

        step("Assert Email and Phone won't be changed", () -> {
            assertEmailPhoneWontChanged();
        });

    }
}
