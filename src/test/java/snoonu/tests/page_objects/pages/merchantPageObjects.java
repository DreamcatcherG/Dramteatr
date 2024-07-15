package snoonu.tests.page_objects.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static snoonu.helpers.DriverHelper.byTestId;

public class merchantPageObjects {

    public static ElementsCollection productCard() {
        return $$(byClassName("ProductCardHorizontal_name__z0EMu"));
    }

    public static SelenideElement productCardAddBtn(SelenideElement productCard) {
        return productCard.$(byAttribute("data-analytic-label","productButtonAdd"));
    }
}