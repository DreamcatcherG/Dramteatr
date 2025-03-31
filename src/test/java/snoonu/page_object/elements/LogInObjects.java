package snoonu.page_object.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static snoonu.drivers.DriverHelper.byDataTestId;

public class LogInObjects {
    public static SelenideElement pinField() {
        return $(byDataTestId("pinInput"));
    }

    public static SelenideElement wrongPinText() {
        return $(byDataTestId("wrongPinText"));
    }
} 