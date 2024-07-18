package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.page_object.scenario.MainPageScenario.goToProfile;
import static snoonu.tests.TestData.Number272;
import static snoonu.helpers.page_object.scenario.LogInScenario.logginInNumberOtp;
import static snoonu.helpers.page_object.scenario.MainPageScenario.assertSuccessAuth;
import static snoonu.helpers.page_object.scenario.ProfileScenario.*;

@Feature("Selenide_Web")
@Story("Smoke tests Web")
@Tag("smokeStage")

class EditingProfile extends TestBase {

    @Test
    void editProfile() {

        step("Go to the web page", () -> {
            open(Environment.webPage);
        });

        step("Authorization", () -> {
            logginInNumberOtp(Number272);
        });

        step("Assert: Logging in is successful (Profile icon is visible)", () -> {
            assertSuccessAuth();
        });

        step("Go to Profile Icon", () -> {
            goToProfile();
        });

        step("Go to my Account", () -> {
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
