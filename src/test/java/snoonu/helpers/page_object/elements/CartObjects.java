package snoonu.helpers.page_object.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartObjects {

    public static ElementsCollection mpProductCardsInCart() {
        return $$(byAttribute("class", "CartProduct_wrapper__nFipV CartProduct_marketplace__1hbJL"));
    }

    public static ElementsCollection mpProductCardTitlesInCart() {
        return $$(byAttribute("class", "Typography_p11__Zpcyp CartProduct_name__zlfe_"));
    }

    public static SelenideElement mpCardSceletonLoadingInCart() {
        return $(byAttribute("class", "CartLoading_wrapper__AydaS"));
    }

    public static SelenideElement checkoutBtnInCart() {
        return $(byAttribute("class", "MarketplaceCart_checkoutButton__AXBof"));
    }
}

