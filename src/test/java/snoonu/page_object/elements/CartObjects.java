package snoonu.page_object.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static snoonu.drivers.DriverHelper.byDataTestId;

public class CartObjects {

    public static SelenideElement productCardInCart() {
        return $(byDataTestId("cardOfProductInCart"));
    }

    public static ElementsCollection productCardsInCart() {
        return $$(byDataTestId("cardOfProductInCart"));
    }

    public static ElementsCollection productTitlesInCart() {
        return $$(byDataTestId("productTitleInCart"));
    }

    public static SelenideElement checkoutBtnInCart() {
        return $(byDataTestId("checkoutBtn"));
    }
}

