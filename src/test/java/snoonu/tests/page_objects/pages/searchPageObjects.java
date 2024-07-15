package snoonu.tests.page_objects.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.helpers.DriverHelper.byTestId;

public class searchPageObjects {

    public static SelenideElement merchantCard() {
        return $(byTestId("merchantCard"));
    }

}