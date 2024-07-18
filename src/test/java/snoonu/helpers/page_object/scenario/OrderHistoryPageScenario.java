package snoonu.helpers.page_object.scenario;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static snoonu.helpers.page_object.elements.OrderHistoryPageObjects.ordersTitleInOrdersPage;
import static snoonu.helpers.page_object.elements.SuccessPageObjects.successTitle;
import static snoonu.helpers.page_object.elements.SuccessPageObjects.trackOrderBtn;

public class OrderHistoryPageScenario {

    public static void verifyOrdersTitle() {
        try {
            ordersTitleInOrdersPage().shouldHave(text("Orders"));
        } catch (AssertionError e) {

            throw new AssertionError("Orders History Page didn't open", e);
        }
    }
}




