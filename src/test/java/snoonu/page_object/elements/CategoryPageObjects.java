package snoonu.page_object.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoryPageObjects {

    public static SelenideElement merchantCard() {
        return $(byAttribute("data-analytic-label","merchantCard"));
    }


    public static ElementsCollection merchantCards() {
        return $$(byAttribute("data-analytic-label","merchantCard"));
    }

}

