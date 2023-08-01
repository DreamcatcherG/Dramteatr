package snoonu.tests._other_patterns.page_objects.scenario.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import snoonu.utils_generate.DataGenerator;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.open;
import static snoonu.helpers.DriverHelper.byTestId;
import static snoonu.tests._other_patterns.super_difficult_component.extentions.SelenideExtentions.$;

public class LoginPageDev {

    private SelenideElement loginButton;
    private SelenideElement phoneNumberField;
    private SelenideElement continueButton;
    private final SelenideElement pinCodeField;

    public LoginPageDev() {
        loginButton = $(byTestId("loginButton"));
        phoneNumberField = $(byName("phoneNumber"));
        continueButton = $(byTestId("loginContinue"));
        pinCodeField = $(By.id("input[name='pin']"));
    }

    public LoginPageDev openPage() {
        open("https://it@snoonu.com:Iq2ci2SIQ5hpCqlUkZqd4bmb5kRHCY5B6ZTLPzHXnec=@development.snoonu.com");
        return this;
    }

    public LoginPageDev clickLoginButton() {
        loginButton.click();
        return this;
    }

    public LoginPageDev enterPhoneNumber(String phone) {
        phoneNumberField.setValue("21343286");
        return this;
    }

    public LoginPageDev clickContinueButton() {
        continueButton.click();
        return this;
    }

    public LoginPageDev enterPinCode(String pinCode) {
        pinCodeField.setValue(DataGenerator.otp);
        return this;
    }

    public MainPage submitForm() {
        // submit form
        return new MainPage();
    }

}
//    public MainPage submitForm() {
//        // логика отправки формы
//        return new MainPage();
//    }
//}

    //    @Step("Go to login page")
//    public void goToLoginPage() {
//        open("https://autotests.cloud");
//        $(byTestId("Header label")).shouldHave(text("Not authorized"));
//    }
//
//    @Step("Fill the authorization form")
//    public void fillAuthorizationForm(String login, String password) {
//        $(byTestId("Authorization form")).shouldBe(visible);
//        $(byTestId("Login input")).setValue(login);
//        $(byTestId("Password input")).setValue(password);
//        $(byTestId("Remember me checkbox")).click();
//        $(byTestId("Login button")).click();
