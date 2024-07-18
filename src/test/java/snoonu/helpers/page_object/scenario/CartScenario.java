package snoonu.helpers.page_object.scenario;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static snoonu.helpers.page_object.elements.CartObjects.*;

public class CartScenario {

    public static void verifyProductInCart(String productName) {
        ElementsCollection productCards = mpProductCardsInCart();

        if (productCards.isEmpty()) {
            throw new AssertionError("No products found in the cart.");
        }

        boolean productFound = false;

        for (SelenideElement productCard : productCards) {
            ElementsCollection productTitles = mpProductCardTitlesInCart().filterBy(text(productName));
            if (!productTitles.isEmpty()) {
                productCard.shouldBe(visible);
                productFound = true;
                break;
            }
        }

        if (!productFound) {
            throw new AssertionError("Product with name " + productName + " not found in the cart.");
        }
    }

    public static void cartIsLoaded() {
        mpCardSceletonLoadingInCart().should(disappear);
    }

    public static void goToCheckoutBtn() {
        checkoutBtnInCart().click();
    }
}


