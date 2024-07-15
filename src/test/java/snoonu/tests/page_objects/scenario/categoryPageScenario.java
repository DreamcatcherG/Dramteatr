package snoonu.tests.page_objects.scenario;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.switchTo;
import static snoonu.tests.page_objects.pages.categoryPageObjects.merchantCard;

public class categoryPageScenario {


    public static void findTestMerchant() {

        ElementsCollection merchantCards = $$("[data-analytic-label='merchantCard']");
        SelenideElement testMerchantCard = merchantCards.filter(attribute("href", "https://snoonu.com/restaurants/test-cafe-brand")).first();
        testMerchantCard.shouldBe(visible).click();

    }
}




