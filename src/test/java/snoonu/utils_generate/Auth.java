package snoonu.utils_generate;

import com.codeborne.selenide.SelenideElement;

import java.awt.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.helpers.DriverHelper.byTestId;

public class Auth {

    public static void fillFormOrders() {  // Auth.fillFormOrders();

        $(byTestId("loginButton")).shouldBe(visible).click();
        $(byName("phoneNumber")).sendKeys("21343285");
        $(byTestId("loginContinue")).click();
        SelenideElement pinInput = $(byName("pin"));

        String pinCode = DataGenerator.otp;

        try {
            Robot robot = new Robot();
            for (char c : pinCode.toCharArray()) {
                pinInput.sendKeys(Character.toString(c));
                robot.delay(100); // Задержка в 100 миллисекунд
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void fillFormOth() { //  Auth.fillFormOth();
        $(byTestId("loginButton")).shouldBe(visible).click();
        $(byName("phoneNumber")).sendKeys("21343285");
        $(byTestId("loginContinue")).click();
        SelenideElement pinInput = $(byName("pin"));

        String pinCode = DataGenerator.otp;

        try {
            Robot robot = new Robot();
            for (char c : pinCode.toCharArray()) {
                pinInput.sendKeys(Character.toString(c));
                robot.delay(100); // Задержка в 100 миллисекунд
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}


