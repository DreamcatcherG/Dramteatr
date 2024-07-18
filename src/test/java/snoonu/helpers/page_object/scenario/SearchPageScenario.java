package snoonu.helpers.page_object.scenario;

import static com.codeborne.selenide.Condition.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static snoonu.helpers.page_object.elements.SearchPageObjects.merchantCard;

public class SearchPageScenario {


    public static void findMerchantCard() {
        merchantCard().shouldHave(text("Fake Devices Store (Only for Autotests)"));
        merchantCard().click();
    }


}


