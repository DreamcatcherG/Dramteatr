package snoonu.page_object.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static snoonu.drivers.DriverHelper.byDataTestId;

public class CheckoutPageObjects {

    public static SelenideElement chooseMethodBtn() {
        return $(byDataTestId("choosePayMethodBtn"));
    }

    public static SelenideElement cashPaymentMethod() {
        return $(byDataTestId("cashBtn"));
    }

    public static SelenideElement paymentMethodsDoneBtn() {
        return $(byDataTestId("doneInPayMethodModal"));
    }

    public static SelenideElement loaderFullScreen() {
        return $(byAttribute("class","LoaderFullscreen_spinner__etJvR"));
    }

    public static SelenideElement placeOrderBtn() {
        return $(byDataTestId("placeOrderBtn"));
    }
}

