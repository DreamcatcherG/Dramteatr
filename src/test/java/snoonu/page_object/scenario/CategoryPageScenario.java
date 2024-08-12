package snoonu.page_object.scenario;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static snoonu.page_object.elements.CategoryPageObjects.merchantCard;
import static snoonu.page_object.elements.CategoryPageObjects.merchantCards;
import static snoonu.page_object.elements.MerchantPageObjects.bestSellingProductCards;

public class CategoryPageScenario {

    private static SelenideElement testMerchantCard;

    public static void findTestMerchant(String merchantName) {
        ElementsCollection merchantCards = merchantCards();
        testMerchantCard = merchantCards.filterBy(text(merchantName)).first();
        if (testMerchantCard.exists()) {
            testMerchantCard.shouldBe(visible);
        } else {
            throw new AssertionError("Merchant with name " + merchantName + " not found.");
        }
    }

    public static void openMerchantPage() {
        if (testMerchantCard != null) {
            testMerchantCard.click();
        } else {
            throw new AssertionError("Merchant card is not found. Make sure to call findTestMerchant first.");
        }
    }

    public static void isMerchantCardVisible() {
        try {
            merchantCard().shouldBe(visible);
        } catch (AssertionError e) {
            throw new AssertionError("Merchant cards aren't on the page", e);
        }
    }

    public static void findBestSellingCard() {
        int scrollAttempts = 0;
        boolean productFound = false;

        while (scrollAttempts < 5 && !productFound) {
            ElementsCollection productCards = bestSellingProductCards();

            if (!productCards.isEmpty()) {
                productCards.first().scrollTo();
                productFound = true;
            } else {
                executeJavaScript("window.scrollBy(0, document.body.scrollHeight)");
                scrollAttempts++;
            }
        }

        if (!productFound) {
            throw new AssertionError("Product Cards not found.");
        }
    }

}





