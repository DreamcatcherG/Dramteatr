package snoonu.utils_generate;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.helpers.DriverHelper.byTestId;


public class Auth {

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
}
