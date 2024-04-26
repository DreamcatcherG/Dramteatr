package snoonu.tests.page_objects.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import snoonu.helpers.Css;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.helpers.DriverHelper.byTestId;

public class profileObjects {

    public static SelenideElement profileNameField() {
        return $(byName("name"));
    }

    public static SelenideElement profileEmailField() {
        return $(byName("email"));
    }

    public static SelenideElement profilePhoneField() {
        return $(byName("phone"));
    }

    public static SelenideElement registerProfileBtn() {
        return $(byTestId("loginRegister"));
    }

    public static SelenideElement myAccount() {
        return $(byTestId("myAccount"));
    }

    public static SelenideElement saveAccountBtn() {
        return $(byTestId("saveAccount"));
    }

    public static SelenideElement deleteAccount() {
        return $(byTestId("deleteAccount"));
    }

    public static SelenideElement deleteAccountConfirm() {
        return $(Css.byId("delete-account-modal-confirm"));
    }

    public static SelenideElement paymentCards() {
        return $(byTestId("savedCards"));
    }

    public static SelenideElement savedAddresses() {
        return $(byTestId("myAddresses"));
    }

    public static SelenideElement isPaymentCard() {
        return $(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/p[1]"));
    }

    public static SelenideElement addPaymentCardBtn() {
        return $(byTestId("addNewCard"));
    }

    public static SelenideElement cardNumberField(String сardNumber) {
        return $(By.name("number")).setValue(сardNumber);
    }

    public static SelenideElement expiryDateField() {
        return $(By.name("date"));
    }

    public static SelenideElement cvvField() {
        return $(By.name("code"));
    }

    public static SelenideElement saveCardBtn() {
        return $(byTestId("saveCard"));
    }

    public static SelenideElement deleteSavedCardBtn() {
        return $(Css.byId("delete-card-btn"));
    }

    public static SelenideElement confirmDeleteBtn() {
        return $(byTestId("yes"));
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

    public static SelenideElement savedPayCardField() {
        return $(Css.byId("credit-card-list-credit-card-number"));
    }
}

