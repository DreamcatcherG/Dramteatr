package snoonu.page_object.scenario;

import static snoonu.page_object.elements.HeaderObjects.loginBtn;
import static snoonu.page_object.elements.LogInObjects.loginContinueBtn;
import static snoonu.page_object.elements.LogInObjects.phoneNumberInput;
import static snoonu.utils_generate.AwtRobot.entOtp;

public class LogInScenario {


    public static void logginInNumberOtp(String phoneNumber) throws InterruptedException {

        if (phoneNumberInput().exists()) {
            phoneNumberInput().sendKeys(phoneNumber);
            loginContinueBtn().click();
            entOtp();
        } else {
            loginBtn().click();
            phoneNumberInput().click();
            phoneNumberInput().sendKeys(phoneNumber);
            loginContinueBtn().click();
            entOtp();
        }
    }

    public static void clickLogin() {
        loginBtn().click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberInput().sendKeys(phoneNumber);
    }

    public void clickLoginContinue() {
        loginContinueBtn().click();
    }
}
