package snoonu.page_object.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckoutPageObjects {

    public static SelenideElement selectPaymentBtn() {
        return $(byAttribute("data-analytic-label","selectPaymentMethod"));
    }

    public static ElementsCollection paymentMethods() {
        return $$(byAttribute("class","PaymentRadio_method__K2D1h"));
    }

    public static SelenideElement paymentMethodsDoneBtn() {
        return $(byAttribute("id","selectPaymentMethodId"));
    }

    public static SelenideElement loaderFullScreen() {
        return $(byAttribute("class","LoaderFullscreen_spinner__etJvR"));
    }

    public static SelenideElement placeOrderBtn() {
        return $(byAttribute("data-analytic-label","placeOrder"));
    }
}

