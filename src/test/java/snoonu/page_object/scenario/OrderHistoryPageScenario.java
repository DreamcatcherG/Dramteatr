package snoonu.page_object.scenario;

import static com.codeborne.selenide.Condition.appear;
import static snoonu.page_object.elements.OrderHistoryPageObjects.productCardInOrdersPage;

public class OrderHistoryPageScenario {

    public static void verifyOrderIsInHistory() {
        try {
            productCardInOrdersPage().should(appear);
        } catch (AssertionError e) {

            throw new AssertionError("Orders History Page does not have any order", e);
        }
    }
}




