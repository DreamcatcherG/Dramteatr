package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.helpers.Environment;
import snoonu.tests.TestBase;
import snoonu.tests.TestData;
import snoonu.tests.page_objects.scenario.logInScenario;
import snoonu.tests.page_objects.scenario.profileScenario;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.tests.TestData.sNumber336;

@Feature("Selenide_Web")
@Story("Smoke tests Web")
@Tag("smokeStage")
class AddDelCreditCard extends TestBase {

    @Test
    void addCreditCard() {

        step("Open Web and Login in", () -> {
            open(Environment.webPage);
        });

        step("Login in", () -> {
            logInScenario.defaultProfile(sNumber336);
        });

        step("Open Saved Cards window)", () -> {
            profileScenario.goToSavedPaymentsCard();
        });

        step("Assert is a credit card", () -> {
            profileScenario.assertNoSavedCards();
        });

        step("Add new Payment card", () -> {
            profileScenario.addNewPayCard(TestData.CreditCard);
        });

        step("Complete adding for Payment Card", () -> {
            profileScenario.completePayCardAdding();
        });

        step("Assert card was added", () -> {
            profileScenario.assertCardMatched(); // check it
        });

    }
}

