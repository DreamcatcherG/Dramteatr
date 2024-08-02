package snoonu.page_object.elements;

import com.codeborne.selenide.SelenideElement;
import snoonu.drivers.extentions.SelenideExtentions;

import static com.codeborne.selenide.Selenide.$;
import static snoonu.drivers.DriverHelper.byDataTestId;

public class HeaderObjects {

    public static SelenideElement locationPopup() {
        return SelenideExtentions.$(byDataTestId("locationBtnOnHeader"));
    }

    public static SelenideElement loginBtn() {
        return $(byDataTestId("loginBtn"));
    }

    public static SelenideElement profileIcon() {
        return $(byDataTestId("profileIcon"));
    }

    public static SelenideElement cartBtn() {
        return $(byDataTestId("cartBtn"));
    }
}

