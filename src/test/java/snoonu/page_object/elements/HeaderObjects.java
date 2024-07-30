package snoonu.page_object.elements;

import com.codeborne.selenide.SelenideElement;
import snoonu.drivers.extentions.SelenideExtentions;

import static com.codeborne.selenide.Selenide.$;
import static snoonu.drivers.DriverHelper.byTestId;
import static snoonu.drivers.DriverHelper.dataTestId;

public class HeaderObjects {

    public static SelenideElement locationPopup() {
        return SelenideExtentions.$(byTestId("locationSelector"));
    }

    public static SelenideElement loginBtn() {
        return $(dataTestId("loginBtn"));
    }

    public static SelenideElement profileIcon() {
        return $(dataTestId("profileIcon"));
    }

    public static SelenideElement cartBtn() {
        return $(dataTestId("cartBtn"));
    }
}

