package snoonu.page_object.scenario;

import static snoonu.page_object.elements.CheckoutPageObjects.*;

public class CheckoutPageScenario {

    public static void paymentMethodIsDisplayed() {
        chooseMethodBtn().isDisplayed();
    }

    public static void openPayMethodModal() {
        chooseMethodBtn().click();
    }

    public static void selectPaymentMethodScenario() {
        cashPaymentMethod().click();
        paymentMethodsDoneBtn().click();
    }

    public static void clickToPlaceOrderBtn() {
        placeOrderBtn().click();
    }
}


