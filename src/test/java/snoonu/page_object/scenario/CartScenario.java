package snoonu.page_object.scenario;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static snoonu.page_object.elements.CartObjects.*;
import static snoonu.page_object.elements.ProfileObjects.loaderInButtons;

public class CartScenario {

    public static void isProductInCart() {
        loaderInButtons().should(disappear);
        productCardInCart().should(appear);

        if (productCardsInCart().isEmpty()) {
            throw new AssertionError("No products found in the cart.");

        }
    }

        public static void isSelectedProductInCart(String productName) {
            ElementsCollection productCards = productCardsInCart();
            boolean productFound = false;

            for (SelenideElement productCard : productCards) {
                ElementsCollection productTitles = productTitlesInCart().filterBy(text(productName));
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

    public static void goToCheckoutBtn() {
        checkoutBtnInCart().click();
    }
}




