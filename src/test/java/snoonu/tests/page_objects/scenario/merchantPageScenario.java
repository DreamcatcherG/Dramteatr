package snoonu.tests.page_objects.scenario;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static snoonu.helpers.DriverHelper.byTestId;
import static snoonu.tests.page_objects.pages.merchantPageObjects.productCard;
import static snoonu.tests.page_objects.pages.merchantPageObjects.productCardAddBtn;

public class merchantPageScenario {


//    public static void findAndAddProduct(String productName) {
//        // Получаем первый элемент из коллекции (предполагаем, что их может быть несколько)
//        productCard().first().scrollTo()
//                .shouldHave(text(productName))
//                .shouldBe(visible)
//                .click();
//    }

//    public static void findAndAddProduct(String productName) {
//        ElementsCollection productCards = productCard();
//
//        for (SelenideElement productCard : productCards) {
//            productCard.scrollTo().shouldBe(visible);  // Ensure element is visible after scrolling
//            if (productCard.has(text(productName))) {
//                productCard.scrollTo().click();  // Scroll to the specific element and click
//                break;
//            }
//        }
//    }

        public static void findAndAddProduct(String productName) {
            ElementsCollection productCards = productCard();
            boolean productFound = false;

            for (SelenideElement productCard : productCards) {
                productCard.scrollTo().shouldBe(visible);  // Ensure element is visible after scrolling
                if (productCard.has(text(productName))) {
                    productCard.scrollTo().click();  // Scroll to the specific add button and click
                    productFound = true;
                    break;
                }
            }

            if (!productFound) {
                System.out.println("Product with name " + productName + " not found.");
            }
        }
}

