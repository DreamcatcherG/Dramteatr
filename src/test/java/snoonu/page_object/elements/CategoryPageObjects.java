package snoonu.page_object.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static snoonu.drivers.DriverHelper.byDataTestId;

public class CategoryPageObjects {

    public static SelenideElement merchantCard() {
        return $(byDataTestId("merchantCardInCategory"));
    }

    public static ElementsCollection merchantCards() {
        return $$(byDataTestId("merchantCardInCategory"));
    }

}

