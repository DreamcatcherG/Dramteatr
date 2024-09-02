package snoonu.page_object.scenario;

import org.openqa.selenium.Keys;
import snoonu.page_object.elements.ProfileObjects;
import snoonu.utils_generate.TextGenerator;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static snoonu.page_object.elements.HeaderObjects.profileIcon;
import static snoonu.page_object.elements.ProfileObjects.*;
import static snoonu.tests.TestData.CreditCard;
import static snoonu.utils_generate.TextGenerator.*;

public class ProfileScenario {

    public static void registerNewProfile() {
        String randomName = getRandomAlphaNumeric(3, 8) + " WEBtEST!";
        String randomEmail = getRandomEmail(1, 10);
        profileNameField().setValue(randomName);
        profileEmailField().setValue(randomEmail);
        registerProfileBtn().click();
        profileIcon().shouldBe(appear);
    }

    public static void goToMyAccount() {
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
        profileNameField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        String randomName = getRandomAlphaNumeric(3, 8) + " WEBtEST!";
        profileNameField().setValue(randomName);
    }

    public static void saveProfileName() {
        saveAccountBtn().click();
        loaderInButtons().should(disappear);
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

    public static void goToProfileIcon() {
        profileIcon().click();
    }

    public static void goToSavedPaymentsCard() {
        paymentCards().click();
        assert addPaymentCardBtn().isDisplayed();
    }

    public static void assertNoSavedCards() {
        sleep(2000);
        if (savedPaymentCard().exists()) {
            deleteSavedCardBtn().click();
            yesConfirmDeleteBtn().shouldBe(enabled).click();
            loaderInButtons().should(disappear);
            assertNoSavedCards();
        } else {
            savedPaymentCard().shouldNot(exist);
        }
    }

    public static void addNewPayCard(String cardNumber) {
        addPaymentCardBtn().click();
        cardNumberField().setValue(cardNumber);
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
        loaderInButtons().should(disappear);
    }

    public static void completePayCardAddingOn3DSPage() {
        Frame3ds().shouldBe(visible);
        switchTo().frame(ProfileObjects.Frame3ds());
        submitBtn3Ds().click();
        sleep(2000);
        switchTo().defaultContent();
        close3DS().click();
    }

    public static void isCardVerified() {
        savedPaymentCard().shouldBe(appear);
        boolean isElementExists = verifyPaymentCardBtn().exists();
        if (isElementExists) {
            throw new AssertionError("Payment Card isn't verified");
        }
    }

    public static void assertCardAdded() {
        String lastFourDigits = CreditCard.substring(CreditCard.length() - 4);
        String displayedText = savedPaymentCard().getText();
        String displayedLastFourDigits = displayedText.substring(displayedText.length() - 4);
        assertEquals(lastFourDigits, displayedLastFourDigits, "Last four digits of the card do not match the added card");
    }
}





