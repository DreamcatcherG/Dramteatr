package snoonu.tests.page_objects.pages;

import static com.codeborne.selenide.Selectors.byName;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static snoonu.helpers.DriverHelper.byTestId;

public class logInObjects {

    public static SelenideElement phoneNumberInput() {
        return $(byName("phoneNumber"));
    }

    public static SelenideElement loginContinueBtn() {
        return $(byTestId("loginContinue"));
    }

    public static SelenideElement loginBtn() {
        return $(byTestId("loginButton"));
    }
}