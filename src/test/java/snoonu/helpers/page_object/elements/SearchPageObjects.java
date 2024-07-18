package snoonu.helpers.page_object.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static snoonu.drivers.DriverHelper.byTestId;

public class SearchPageObjects {

    public static SelenideElement merchantCard() {
        return $(byTestId("merchantCard"));
    }

}