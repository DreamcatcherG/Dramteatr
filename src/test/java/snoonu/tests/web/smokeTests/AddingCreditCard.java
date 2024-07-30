package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.LogInScenario.logginInNumberOtp;
import static snoonu.page_object.scenario.ProfileScenario.*;
import static snoonu.tests.TestData.*;

@Feature("Selenide_Web")
@Story("Smoke tests Web")
@Tag("smokeStage")
class AddingCreditCard extends TestBase {

    @Test
    void addCreditCard() {

        step("Open Web and Login in", () -> {
            open(Environment.webPage);
        });

        step("Login in", () -> {
            logginInNumberOtp(Number208);
        });

        step("Open Saved Cards window)", () -> {
            goToSavedPaymentsCard();
        });

        step("Assert is a credit card if It Is, then Remove all", () -> {
            assertNoSavedCards();
        });

        step("Add new Payment card", () -> {
            addNewPayCard(CreditCard);
        });

        step("Complete adding for Payment Card", () -> {
            completePayCardAddingOn3DSPage();
        });

        step("Assert Added card is displayed in modal of saved cards", () -> {
            assertCardAdded();
        });

        step("Assert card was added and saved completely", () -> {
            assertCardAddedCompletely();
        });

    }
}

