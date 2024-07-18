package snoonu.helpers.page_object.elements;

import static com.codeborne.selenide.Selectors.byAttribute;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static snoonu.drivers.DriverHelper.byTestId;

public class LogInObjects {

    public static SelenideElement phoneNumberInput() {
        return $(byAttribute("name","phoneNumber"));
    }

    public static SelenideElement loginContinueBtn() {
        return $(byTestId("loginContinue"));
    }

}