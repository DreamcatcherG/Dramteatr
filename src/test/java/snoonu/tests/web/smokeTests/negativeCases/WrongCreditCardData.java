package snoonu.tests.web.smokeTests.negativeCases;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.LogInScenario.enterNumberOtp;
import static snoonu.page_object.scenario.ProfileScenario.*;
import static snoonu.tests.TestData.*;

@Tag("smoke")
@Tag("newPayCard")

class WrongCreditCardData extends TestBase {

    @Test
    void addCreditCard() {

        step("Open Web and Login in", () -> {
            open(Environment.webPage);
        });

        step("Login in", () -> {
            enterNumberOtp(Number272);
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

        step("Add wrong credit card number", () -> {
            enterWrongCreditCardNumber(WrongCreditCard);
        });
//
        step("Add wrong credit card date", () -> {
            enterWrongCreditCardDate();
        });
//
        step("Add wrong credit card cvv", () -> {
            enterWrongCreditCardCvv();
        });
//
        step("Click on Save button", () -> {
            clickSaveCardBtn();
        });

        step("Assert loader for save button isn't appeared", () -> {
            loaderInButtonsIsNotAppeared();
        });

        step("Assert 'Check Date' message is still displayed", () -> {
            isCheckDateTextDisplayed();
        });
    }
}

