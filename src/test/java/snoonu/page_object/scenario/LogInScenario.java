package snoonu.page_object.scenario;

import static snoonu.page_object.elements.MainPage.loginBtn;
import static snoonu.page_object.elements.MainPage.loginContinueBtn;
import static snoonu.page_object.elements.MainPage.phoneNumberInput;
import static snoonu.utils_generate.AwtRobot.entOtp;

public class LogInScenario {

    public static void enterNumberOtp(String phoneNumber) throws InterruptedException {
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

}
