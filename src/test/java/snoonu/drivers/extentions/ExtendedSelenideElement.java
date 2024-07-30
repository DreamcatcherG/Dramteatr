package snoonu.drivers.extentions;

import com.codeborne.selenide.SelenideElement;


public interface ExtendedSelenideElement extends SelenideElement {
    ExtendedSelenideElement fillAuthorizationForm(String login, String password);
}
