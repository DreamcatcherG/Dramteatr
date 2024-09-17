package snoonu.page_object.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static snoonu.drivers.DriverHelper.byTestId;
import static snoonu.drivers.DriverHelper.byDataTestId;
import static snoonu.drivers.extentions.SelenideExtentions.$;

public class LocationObjects {

    public static SelenideElement selectLocationButton() {
        return $(byDataTestId("selectAddressBtn"));
    }

    public static SelenideElement pencilBtn() { return $(byDataTestId("pencilEditBtn")); }

    public static SelenideElement deleteAddressBtn() { return $(byDataTestId("deleteAddressBtn")); }

    public static SelenideElement cardSavedAddress() { return $(byTestId("cardAddress")); }

    public static SelenideElement nameLocationCard() { return $(By.cssSelector("p.Typography_p8__gvA_C.CardAddress_notes__b6xbO")); }

    public static SelenideElement savedAddressCard() { return $(byDataTestId("cardSavedAddress")); }

    public static SelenideElement confirmBtnOnMap() {
        return $(byDataTestId("confirmLocationBtn"));
    }

    public static SelenideElement crossIconX() {
        return $(byDataTestId("crossXBtn"));
    }

    public static SelenideElement addressPredictionField() {
        return $(byDataTestId("addressSuggest"));
    }

    public static SelenideElement confirmYesAddressBtn() {
        return $(byDataTestId("confirmYesBtn"));
    }

    public static SelenideElement confirmRemoveAddressYesBtn() {
        return $(byDataTestId("yesDeleteConfirmBtn"));
    }

    public static SelenideElement confirmDontDeleteAddressBtn() {
        return $(byDataTestId("dontDeleteBtn"));
    }

    public static SelenideElement confirmNoAddressBtn() {
        return $(byDataTestId("confirmNoBtn"));
    }

    public static SelenideElement addNewAddressBtn() {
        return $(byTestId("addNewAddress"));
    }

    public static SelenideElement addressInputField() {
        return $(byDataTestId("addressInputField"));
    }

    public static SelenideElement apartmentInputField() {
        return $(byDataTestId("apartmentField"));
    }

    public static SelenideElement driverNotesInputField() {
        return $(byDataTestId("driverNote"));
    }

    public static SelenideElement customNameInputField() {
        return $(byDataTestId("customNameField"));
    }

    public static SelenideElement saveAddressBtn() {
        return $(byDataTestId("saveAddressBtn"));
    }
}
