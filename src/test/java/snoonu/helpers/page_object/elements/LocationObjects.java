package snoonu.helpers.page_object.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static snoonu.drivers.DriverHelper.byTestId;
import static snoonu.helpers._other_patterns.super_difficult_component.extentions.SelenideExtentions.$;

public class LocationObjects {

    public static SelenideElement selectLocationBtn() {
        return $(byTestId("selectLocation"));
    }

    public static SelenideElement pencilBtn() { return $(byTestId("addressEdit")); }

    public static SelenideElement deleteAddressBtn() { return $(byTestId("deleteAddress")); }

    public static SelenideElement cardSavedAddress() { return $(byTestId("cardAddress")); }

    public static SelenideElement nameLocationCard() { return $(By.cssSelector("p.Typography_p8__gvA_C.CardAddress_notes__b6xbO")); }

    public static SelenideElement cardAddressName() { return $(byAttribute("class","Typography_p8__bwpG6 CardAddress_notes__Hx8C0")); }

    public static SelenideElement confirmBtnMapWindow() {
        return $(byTestId("loginContinue"));
    }

    public static SelenideElement crossIconX() {
        return $(byTestId("crossIcon"));
    }

    public static SelenideElement addressPredictionField() {
        return $(byTestId("addressPrediction"));
    }

    public static SelenideElement delConfirmYesBtn() {
        return $(byTestId("deleteConfirmYes"));
    }

    public static SelenideElement delConfirmNoBtn() {
        return $(byTestId("deleteConfirmNo"));
    }

    public static SelenideElement addNewAddressBtn() {
        return $(byTestId("addNewAddress"));
    }

    public static SelenideElement addressInputField() {
        return $(byName("address"));
    }

    public static SelenideElement apartmentInputField() {
        return $(byName("apartment"));
    }

    public static SelenideElement notesInputField() {
        return $(byName("notes"));
    }

    public static SelenideElement customNameInputField() {
        return $(byName("customName"));
    }

    public static SelenideElement saveAddressBtn() {
        return $(byTestId("saveAddress"));
    }
}
