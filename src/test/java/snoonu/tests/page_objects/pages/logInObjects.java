package snoonu.tests.page_objects.pages;

import static com.codeborne.selenide.Selectors.byName;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.helpers.DriverHelper.byTestId;

public class logInObjects {

    public SelenideElement phoneNumberInput() {
        return $(byName("phoneNumber"));
    }

    public SelenideElement loginContinueBtn() {
        return $(byTestId("loginContinue"));
    }

    public SelenideElement loginBtn() {
        return $(byTestId("loginBtn"));
    }
}