package snoonu.helpers.page_object.scenario;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static snoonu.helpers.page_object.elements.CheckoutPageObjects.*;
import static snoonu.helpers.page_object.elements.SuccessPageObjects.*;

public class SuccessPageScenario {

    public static void orderPlacesSuccessful() {
        try {
            successTitle().shouldHave(text("Success!"));
        } catch (AssertionError e) {
            throw new AssertionError("Order didn't placed. Expected title: 'Success!'", e);
        }
    }

    public static void isVisibleTrackYourOrderBtn() {
        trackOrderBtn().shouldBe(visible);
    }

    public static void clickToTrackYourOrderBtn() {
        trackOrderBtn().click();
    }

    public static void goToSnoonuLogoOnOrdersPage() {
        snoonuLogoInOrdersPage().click();
    }
}




