package snoonu.tests.page_objects.scenario;

import org.openqa.selenium.Keys;
import snoonu.tests.TestData;
import snoonu.tests.page_objects.pages.profileObjects;
import snoonu.utils_generate.TextGenerator;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static snoonu.tests.page_objects.pages.mainPageObjects.profileIcon;
import static snoonu.tests.page_objects.pages.profileObjects.*;
import static snoonu.utils_generate.TextGenerator.*;

public class profileScenario {

    public static void registerNewProfile() {
        String randomName = getRandomAlphaNumeric(3, 8) + " WEBtEST!";
        String randomEmail = getRandomEmail(1, 10);
        profileNameField().setValue(randomName);
        profileEmailField().setValue(randomEmail);
        registerProfileBtn().click();
        profileIcon().shouldBe(appear);
    }

    public static void goToMyAccount() {
        profileIcon().shouldBe(visible).click();
        myAccount().shouldBe(visible).click();
    }

    public static void goToLogOutAndConfirm() {
        logOutBtn().shouldBe(enabled).click();
        confirmLogOutBtn().shouldBe(visible).click();
    }

    public static String originalProfileName;

    public static void changeProfileName() {
        originalProfileName = profileNameField().getValue();
        profileNameField().click();
        profileNameField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        String randomName = getRandomAlphaNumeric(3, 8) + " WEBtEST!";
        profileNameField().setValue(randomName);
        saveAccountBtn().click();
    }

    public static void assertProfileNameChanged() {
        myAccount().shouldBe(visible).click();
        String changedProfileName = profileNameField().getValue();
        assertNotEquals(originalProfileName, changedProfileName, "Profile name has not been changed successfully");
    }

    public static void assertEmailPhoneWontChanged() {
        profileEmailField().shouldBe(disabled);
        profilePhoneField().shouldBe(disabled);
    }

    public static void goToDeleteAccount() {
        deleteAccount().shouldBe(enabled).click();
    }

    public static void confirmDeleteAccount() {
        deleteAccountConfirm().shouldBe(enabled).click();
    }

    public static void goToSavedPaymentsCard() {
        profileIcon().click();
        paymentCards().click();
        assert addPaymentCardBtn().isDisplayed();
    }

    public static void assertNoSavedCards() {
        sleep(3000);
        if (deleteSavedCardBtn().exists()) {
            while (deleteSavedCardBtn().exists()) {
                deleteSavedCardBtn().click();
                confirmDeleteBtnYes().shouldBe(enabled).click();
                confirmDeleteBtnYesLoader().should(disappear);
            }
        } else {
            sleep(2000);
            isPaymentCard().shouldHave(text("You do not have any saved cards at the moment"));
        }
    }

    public static void addNewPayCard(String cardNumber) {
        addPaymentCardBtn().click();
        cardNumberField(cardNumber);
//      Date
        int month = TextGenerator.getRandomNumber(1, 12);
        int year = TextGenerator.getRandomNumber(28, 99);
        String formattedMonth = String.format("%02d", month);
        String formattedYear = String.format("%02d", year);
        expiryDateField().setValue(formattedMonth + formattedYear);
//      Cvv
        int randomCvv = TextGenerator.getRandomNumber(1, 999);
        cvvField().setValue(String.format("%03d", randomCvv));

        saveCardBtn().click();
        saveCardBtn().should(disappear);
    }

    public static void completePayCardAddingOn3DSPage() {
        Frame3ds().shouldBe(visible);
        switchTo().frame(profileObjects.Frame3ds());
        submitBtn3Ds().click();
        sleep(2000);
        switchTo().defaultContent();
        close3DS().click();
    }

    public static void assertCardMatched() {
        String lastFourDigits = TestData.CreditCard.substring(TestData.CreditCard.length() - 4);
        String displayedText = $(byAttribute("data-test-id", "credit-card-list-credit-card-number")).getText();
        String displayedLastFourDigits = displayedText.substring(displayedText.length() - 4);
        assertEquals(lastFourDigits, displayedLastFourDigits, "Last four digits of the card do not match the displayed text");
    }

    public static void assertCardAddedCompletely() {
        boolean isElementExists = $(byAttribute("class", "CreditCard_verify__bRzvU")).exists();
        if (isElementExists) {
            throw new AssertionError("The Credit Card Not added completely");
        }
    }
}





