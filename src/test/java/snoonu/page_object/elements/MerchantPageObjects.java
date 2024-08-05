package snoonu.page_object.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$$;
import static snoonu.drivers.DriverHelper.byDataTestId;

public class MerchantPageObjects {

    public static ElementsCollection productCardListView() {
        return $$(byDataTestId("cardOfProduct"));
    }

    public static ElementsCollection productCardBestSelling() {
        return $$(byAttribute("data-analytic-label", "bestSellingProduct"));
    }

    public static ElementsCollection subcategoryCardsInMerchant() {
        return $$(byAttribute("data-analytic-label", "subcategory"));
    }

    public static SelenideElement productCardAddBtn(SelenideElement productCard) {
        return productCard.$(byDataTestId("addBtnProductCard"));
    }
}