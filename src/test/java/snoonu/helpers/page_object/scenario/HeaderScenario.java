package snoonu.helpers.page_object.scenario;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static snoonu.helpers.page_object.elements.HeaderObjects.*;

public class HeaderScenario {

    public static void clickToCart() {
        cartBtn().click();
    }
}


