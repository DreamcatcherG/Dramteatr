package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.helpers.Environment;
import snoonu.tests.TestBase;
import snoonu.tests.TestData;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.tests.TestData.sNumber336;
import static snoonu.tests.page_objects.scenario.logInScenario.defaultProfile;
import static snoonu.tests.page_objects.scenario.profileScenario.*;

@Feature("Selenide_Web")
@Story("Smoke tests Web")
@Tag("smokeStage")
class AddCreditCard extends TestBase {

    @Test
    void addCreditCard() {

        step("Open Web and Login in", () -> {
            open(Environment.webPage);
        });

        step("Login in", () -> {
            defaultProfile(sNumber336);
        });

        step("Open Saved Cards window)", () -> {
            goToSavedPaymentsCard();
        });

        step("Assert is a credit card if Is Remove them", () -> {
            assertNoSavedCards();
        });

        step("Add new Payment card", () -> {
            addNewPayCard(TestData.CreditCard);
        });

        step("Complete adding for Payment Card", () -> {
            completePayCardAddingOn3DSPage();
        });

        step("Assert Added card is displayed in modal of saved cards", () -> {
            assertCardMatched();
        });

        step("Assert card was added and saved completely", () -> {
            assertCardAddedCompletely();
        });

    }
}

