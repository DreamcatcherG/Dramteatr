package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.helpers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.tests.TestData.Number208;
import static snoonu.tests.page_objects.scenario.logInScenario.defaultProfile;
import static snoonu.tests.page_objects.scenario.mainPageScenario.assertSuccessAuth;


@Feature("Selenide_Web")
@Story("Smoke tests Web")
@Tag("smokeStage")
@Tag("onetest")


class Login extends TestBase {


    @Test
    void successfullyLogin() {

        step("Go to the web page", () -> {
            open(Environment.webPage);
        });

        step("Authorization", () -> {
            defaultProfile(Number208);
        });

        step("Assert: Log in is successful", () -> {
            assertSuccessAuth();
        });

    }

}
