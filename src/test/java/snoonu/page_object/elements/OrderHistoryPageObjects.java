package snoonu.page_object.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static snoonu.drivers.DriverHelper.byDataTestId;

public class OrderHistoryPageObjects {

    public static SelenideElement productCardInOrdersPage() {
        return $(byDataTestId("orderHistoryCard"));
    }
}


