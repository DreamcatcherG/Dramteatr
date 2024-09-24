package snoonu.page_object.scenario;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static snoonu.page_object.elements.MerchantPageObjects.*;
import static snoonu.page_object.elements.ModalWindowsObjects.changeMyAddressButton;

public class MerchantPageScenario {
    private static SelenideElement foundProductCard;

    // Need to think how search on 2 page (pagination)
    public static void findAProduct(String productName) {
        int scrollAttempts = 0;
        boolean productFound = false;

        while (scrollAttempts < 5 && !productFound) {
            ElementsCollection productCards = productCardListView();
            foundProductCard = productCards.find(text(productName));
            productCards.first().scrollTo();
            if (foundProductCard != null) {
                productFound = true;
            } else {
            }
            if (foundProductCard == null) {
                throw new AssertionError("Product with name " + productName + " not found.");
            }
        }
    }

    public static void clickToAddBtn() {
        if (foundProductCard != null) {
            SelenideElement addBtn = productCardAddBtn(foundProductCard);
            addBtn.click();
        } else {
            throw new IllegalStateException("No product found to add to the cart. Call findAProduct() first.");
        }
    }

    public static void findClickSubcategoryCardInMerchant() {
        ElementsCollection subcategoryCards = subcategoryCardsInMerchant();
        if (!subcategoryCards.isEmpty()) {
            subcategoryCards.first().shouldBe(visible).click();
            subcategoryCards.first().shouldBe(disappear);
        } else {
            throw new AssertionError("Subcategory cards aren't on the page.");
        }
    }

    public static void findAProductCardInMerchantPage() {
        if (bestSellingProductCards().isEmpty() || !bestSellingProductCards().first().is(Condition.visible)) {
            throw new AssertionError("Product Cards not found.");
        }
    }

    public static void assertChangeMyAddressBtnAppears() {
        changeMyAddressButton().shouldBe(appear);
    }
}