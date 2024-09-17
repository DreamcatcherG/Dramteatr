package snoonu.tests.web.smokeTests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.LogInScenario.enterNumberOtp;
import static snoonu.page_object.scenario.MainPageScenario.assertSuccessAuth;
import static snoonu.page_object.scenario.MainPageScenario.goToProfile;
import static snoonu.page_object.scenario.ProfileScenario.*;
import static snoonu.tests.TestData.Number272;

@Tag("smoke")
@Tag("editProfile")

class EditingProfile extends TestBase {

    @Test
    void editProfile() {

        step("Go to the web page", () -> {
            open(Environment.webPage);
        });

        step("Authorization", () -> {
            enterNumberOtp(Number272);
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

        step("Assert Email and Phone won't be changed", () -> {
            assertEmailPhoneWontChanged();
        });

        step("Save Profile name", () -> {
            saveProfileName();
        });

        step("Assert Profile name changed", () -> {
            assertProfileNameChanged();
        });

    }
}
