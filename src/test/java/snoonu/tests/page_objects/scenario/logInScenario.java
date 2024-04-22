package snoonu.tests.page_objects.scenario;

import snoonu.utils_generate.AwtRobot;
import snoonu.tests.page_objects.pages.logInObjects;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.helpers.DriverHelper.byTestId;

public class logInScenario {

    private final logInObjects logInObjects = new logInObjects();

    public static void defaultProfile(String phoneNumber) throws InterruptedException {

        if ($(byName("phoneNumber")).exists()) {
            $(byName("phoneNumber")).sendKeys(phoneNumber);
            $(byTestId("loginContinue")).click();
            AwtRobot.entOtp();
        } else {
            $(byTestId("loginButton")).click();
            $(byName("phoneNumber")).click();
            $(byName("phoneNumber")).sendKeys(phoneNumber);
            $(byTestId("loginContinue")).click();
            AwtRobot.entOtp();
        }
    }

    public void clickLogin() {
        logInObjects.loginBtn().click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        logInObjects.phoneNumberInput().sendKeys(phoneNumber);
    }
    public void clickLoginContinue() {
        logInObjects.loginContinueBtn().click();
    }
}
