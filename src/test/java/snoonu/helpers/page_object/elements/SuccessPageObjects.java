package snoonu.helpers.page_object.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SuccessPageObjects {

    public static SelenideElement trackOrderBtn() {
        return $(byAttribute("data-analytic-label","trackOrder"));
    }

    public static SelenideElement backToHomeBtn() {
        return $(byAttribute("data-analytic-label","backToHomeButton"));
    }

    public static SelenideElement successTitle() {
        return $(byAttribute("class","Typography_h2__Gzo5Y StatusCard_title__OHZh_")); // "Success!"
    }

    public static SelenideElement snoonuLogoInOrdersPage() {
        return $(byAttribute("data-analytic-label","logo"));
    }
}


