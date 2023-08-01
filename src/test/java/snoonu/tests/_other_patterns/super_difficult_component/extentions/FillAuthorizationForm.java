package snoonu.tests._other_patterns.super_difficult_component.extentions;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.WebElementSource;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.helpers.DriverHelper.byTestId;


class FillAuthorizationForm implements Command<ExtendedSelenideElement> {
    @Override
    public ExtendedSelenideElement execute(SelenideElement element, WebElementSource locator, Object[] args) {
        String login = (String) args[0];
        String password = (String) args[1];

        element.shouldBe(visible);
        $(byTestId("Login input")).setValue(login);
        $(byTestId("Password input")).setValue(password);
        $(byTestId("Remember me checkbox")).click();
        $(byTestId("Login button")).click();

        return (ExtendedSelenideElement) element;
    }
}
