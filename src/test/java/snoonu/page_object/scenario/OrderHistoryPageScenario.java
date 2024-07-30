package snoonu.page_object.scenario;

import static com.codeborne.selenide.Condition.text;
import static snoonu.page_object.elements.OrderHistoryPageObjects.ordersTitleInOrdersPage;

public class OrderHistoryPageScenario {

    public static void verifyOrdersTitle() {
        try {
            ordersTitleInOrdersPage().shouldHave(text("Orders"));
        } catch (AssertionError e) {

            throw new AssertionError("Orders History Page didn't open", e);
        }
    }
}




