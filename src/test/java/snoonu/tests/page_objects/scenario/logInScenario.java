package snoonu.tests.page_objects.scenario;

import snoonu.utils_generate.AwtRobot;
import snoonu.tests.page_objects.pages.logInObjects;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.helpers.DriverHelper.byTestId;
import static snoonu.tests.page_objects.pages.logInObjects.*;

public class logInScenario {

    private final logInObjects logInObjects = new logInObjects();

    public static void defaultProfile(String phoneNumber) throws InterruptedException {

        if (phoneNumberInput().exists()) {
            phoneNumberInput().sendKeys(phoneNumber);
            loginContinueBtn().click();
            AwtRobot.entOtp();
        } else {
            loginBtn().click();
            phoneNumberInput().click();
            phoneNumberInput().sendKeys(phoneNumber);
            loginContinueBtn().click();
            AwtRobot.entOtp();
        }
    }

    public void clickLogin() {
        loginBtn().click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberInput().sendKeys(phoneNumber);
    }

    public void clickLoginContinue() {
        loginContinueBtn().click();
    }
}
