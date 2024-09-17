package snoonu.tests.web.smokeTests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.LogInScenario.logginInNumberOtp;
import static snoonu.page_object.scenario.NativeScenario.isProdEnvironment;
import static snoonu.page_object.scenario.ProfileScenario.*;
import static snoonu.tests.TestData.*;

@Tag("smoke")
@Tag("newPayCard")

class AddingCreditCard extends TestBase {

    @Test
    void addCreditCard() {

        step("Open Web and Login in", () -> {
            open(Environment.webPage);
        });

        step("Login in", () -> {
            logginInNumberOtp(Number272);
        });

        step("Go to Profile Icon", () -> {
            goToProfileIcon();
        });

        step("Open Saved Cards window)", () -> {
            goToSavedPaymentsCard();
        });

        step("Assert is there a credit card if It Is, then Remove all", () -> {
            assertNoSavedCards();
        });

        step("Add new Payment card", () -> {
            addNewPayCard(CreditCard);
        });

        step("Assert is it Prod then show message if Stage pass the test", () -> {
            isProdEnvironment();
        });

        step("Complete adding for Payment Card", () -> {
            completePayCardAddingOn3DSPage();
        });

        step("Assert card verified", () -> {
            isCardVerified();
        });

        step("Assert Added card is displayed in modal of saved cards", () -> {
            assertCardAdded();
        });
    }
}

