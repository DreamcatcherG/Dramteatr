package snoonu.page_object.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static snoonu.drivers.DriverHelper.byDataTestId;

public class MainPage {
    public static SelenideElement loginBtn() {
        return $(byDataTestId("loginButton"));
    }

    public static SelenideElement loginContinueBtn() {
        return $(byDataTestId("loginContinueButton"));
    }

    public static SelenideElement phoneNumberInput() {
        return $(byDataTestId("phoneNumberInput"));
    }

    public static SelenideElement productCardInCart() {
        return $(byDataTestId("cardOfProductInCart"));
    }
}

