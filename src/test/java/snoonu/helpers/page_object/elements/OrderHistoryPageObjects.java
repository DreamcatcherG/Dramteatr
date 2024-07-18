package snoonu.helpers.page_object.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class OrderHistoryPageObjects {

    public static SelenideElement ordersTitleInOrdersPage() {
        return $(byAttribute("class", "Typography_h1__cT2UT Title_title__qEI4Z"));
    }
}


