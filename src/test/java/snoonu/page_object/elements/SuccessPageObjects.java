package snoonu.page_object.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static snoonu.drivers.DriverHelper.byDataTestId;

public class SuccessPageObjects {

    public static SelenideElement trackOrderBtn() {
        return $(byDataTestId("trackOrderBtn"));
    }

    public static SelenideElement backToHomeBtn() {
        return $(byAttribute("data-analytic-label","backToHomeButton"));
    }

    public static SelenideElement successModal() {
        return $(byDataTestId("successModal")); // "Success!"
    }

    public static SelenideElement snoonuLogoInOrdersPage() {
        return $(byDataTestId("snoonulogo"));
    }
}


