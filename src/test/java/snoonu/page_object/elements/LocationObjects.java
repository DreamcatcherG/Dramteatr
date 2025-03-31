package snoonu.page_object.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static snoonu.drivers.DriverHelper.byDataTestId;

public class LocationObjects {
    public static SelenideElement addressInputField() {
        return $(byDataTestId("addressInput"));
    }
} 