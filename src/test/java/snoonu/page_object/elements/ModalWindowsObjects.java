package snoonu.page_object.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static snoonu.drivers.DriverHelper.byDataTestId;

public class ModalWindowsObjects {

    public static SelenideElement backIconBtn() {
        return $(byDataTestId("backIconBtn"));
    }
    public static SelenideElement crossIconBtn() {
        return $(byDataTestId("crossIconBtn"));
    }
    public static SelenideElement changeMyAddressButton() {
        return $(byDataTestId("changeMyAddressBtn"));
    }
}