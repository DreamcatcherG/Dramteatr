package snoonu.tests.page_objects.scenario;

import snoonu.utils_generate.AwtRobot;

import static snoonu.tests.page_objects.pages.logInObjects.*;

public class logInScenario {


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
