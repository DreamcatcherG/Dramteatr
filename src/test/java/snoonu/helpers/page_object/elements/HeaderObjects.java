package snoonu.helpers.page_object.elements;

import com.codeborne.selenide.SelenideElement;
import snoonu.helpers._other_patterns.super_difficult_component.extentions.SelenideExtentions;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.drivers.DriverHelper.byTestId;

public class HeaderObjects {

    public static SelenideElement locationPopup() {
        return SelenideExtentions.$(byTestId("locationSelector"));
    }

    public static SelenideElement loginBtn() {
        return $(byTestId("loginButton"));
    }

    public static SelenideElement profileIcon() {
        return $(byTestId("userPreview"));
    }

    public static SelenideElement cartBtn() {
        return $(byAttribute("data-analytic-label","cartButton"));
    }
}

