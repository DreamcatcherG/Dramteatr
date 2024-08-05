package snoonu.page_object.scenario;

import com.codeborne.selenide.Condition;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static snoonu.page_object.elements.HeaderObjects.*;
import static snoonu.page_object.elements.ProfileObjects.loaderInButtons;

public class HeaderScenario {

    public static void clickToCart() {
        loaderInButtons().should(Condition.disappear);
        cartBtn().click();
    }
}


