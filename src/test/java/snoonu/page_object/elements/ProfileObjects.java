package snoonu.page_object.elements;

import com.codeborne.selenide.SelenideElement;
import snoonu.drivers.Css;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.drivers.DriverHelper.byTestId;
import static snoonu.drivers.DriverHelper.byDataTestId;

public class ProfileObjects {

    public static SelenideElement profileNameField() {
        return $(byDataTestId("nameInput"));
    }

    public static SelenideElement profileEmailField() {
        return $(byDataTestId("emailField"));
    }

    public static SelenideElement profilePhoneField() {
        return $(byDataTestId("phoneField"));
    }

    public static SelenideElement registerProfileBtn() {
        return $(byTestId("loginRegister"));
    }

    public static SelenideElement myAccount() {
        return $(byDataTestId("myAccountBtn"));
    }

    public static SelenideElement saveAccountBtn() {
        return $(byDataTestId("saveAccountBtn"));
    }

    public static SelenideElement deleteAccount() {
        return $(byTestId("deleteAccount"));
    }

    public static SelenideElement deleteAccountConfirm() {
        return $(Css.byId("delete-account-modal-confirm"));
    }

    public static SelenideElement paymentCards() {
        return $(byDataTestId("savedCardsBtn"));
    }

    public static SelenideElement savedAddresses() {
        return $(byDataTestId("myAddressesBtn"));
    }

    public static SelenideElement logOutBtn() {
        return $(byTestId("logout"));
    }

    public static SelenideElement confirmLogOutBtn() {
        return $(byTestId("yes"));
    }

    public static SelenideElement addPaymentCardBtn() {
        return $(byDataTestId("addNewCardBtn"));
    }

    public static SelenideElement cardNumberField() {
        return $(byDataTestId("payCardNumberField"));
    }

    public static SelenideElement expiryDateField() {
        return $(byDataTestId("payCardDateField"));
    }

    public static SelenideElement cvvField() {
        return $(byDataTestId("payCardCodeField"));
    }

    public static SelenideElement saveCardBtn() {
        return $(byDataTestId("saveCardBtn"));
    }

    public static SelenideElement deleteSavedCardBtn() {
        return $(byDataTestId("deleteCardBtn"));
    }

    public static SelenideElement savedPaymentCard() {
        return $(byDataTestId("savedCreditCard"));
    }

    public static SelenideElement listOfSavedCards() {
        return $(byDataTestId("savedCardsList"));
    }

    public static SelenideElement yesConfirmDeleteBtn() {
        return $(byDataTestId("yesBtn"));
    }

    public static SelenideElement verifyPaymentCardBtn() {
        return $(byDataTestId("verifyCardBtn"));
    }

    public static SelenideElement loaderInButtons() {
        return $(byDataTestId("loaderInBtn"));
    }

    public static SelenideElement Frame3ds() {
        return $(byId("challengeFrame"));
    }

    public static SelenideElement submitBtn3Ds() {
        return $("#acssubmit");
    }

    public static SelenideElement close3DS() {
        return $(byXpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[1]/span[1]/img[1]"));
    }

    public static SelenideElement checkDateError() {
        return $(byXpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/p[1]"));
    }

}

