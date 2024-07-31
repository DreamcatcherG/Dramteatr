package snoonu.page_object.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.drivers.DriverHelper.byTestId;
import static snoonu.drivers.DriverHelper.dataTestId;

public class LogInObjects {

    public static SelenideElement phoneNumberInput() {
        return $(byName("phoneNumber"));
    }

    public static SelenideElement loginContinueBtn() {
        return $(dataTestId("btnContinueLogin"));
    }
}