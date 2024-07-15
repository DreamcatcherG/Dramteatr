package snoonu.tests.web.smokeTests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import snoonu.helpers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;
import static snoonu.tests.TestData.Number208;
import static snoonu.tests.page_objects.scenario.logInScenario.defaultProfile;
import static snoonu.tests.page_objects.scenario.mainPageScenario.assertLoginBtnVisible;
import static snoonu.tests.page_objects.scenario.mainPageScenario.goToProfile;
import static snoonu.tests.page_objects.scenario.profileScenario.goToLogOutAndConfirm;

@Feature("Selenide_Web")
@Story("Smoke tests Web")
@Tag("smokeStage")

public class Logout extends TestBase {

    @Test
    void successfullyLogout() {

        step("Pre-Conditions Open Web Page and logging in", () -> {
            open(Environment.webPage);
            defaultProfile(Number208);
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

