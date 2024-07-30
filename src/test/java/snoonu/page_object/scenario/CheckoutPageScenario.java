package snoonu.page_object.scenario;

import static com.codeborne.selenide.Condition.*;
import static snoonu.page_object.elements.CheckoutPageObjects.*;

public class CheckoutPageScenario {

    public static void paymentMethodIsDisplayed() {
        selectPaymentBtn().isDisplayed();
    }

    public static void selectPaymentMethodScenario(String paymentMethod) {
        selectPaymentBtn().click();
        paymentMethods().findBy(text(paymentMethod)).click();
        paymentMethodsDoneBtn().click();
    }

    public static void clickToPlaceOrderBtn() {
        placeOrderBtn().click();
    }
}


