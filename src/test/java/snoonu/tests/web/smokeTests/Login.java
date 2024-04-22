package snoonu.tests.web.smokeTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.helpers.Environment;
import snoonu.tests.TestBase;
import snoonu.tests.page_objects.scenario.mainPageScenario;
import snoonu.tests.page_objects.scenario.logInScenario;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.tests.TestData.Number208;


@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("smokeStage")

class Login extends TestBase {


    @Test
    void successfullyLogin() {

        step("Go to the web page", () -> {
            open(Environment.webPage);
        });

        step("Authorization", () -> {
            logInScenario.defaultProfile(Number208);
        });

        step("Assert: Log in is successful", () -> {
            mainPageScenario.assertSuccessAuth();
        });

    }

}
