package snoonu.utils_generate;

import com.codeborne.selenide.SelenideElement;

import java.awt.*;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class awtRobot {

    public static void entOtp() { // awtRobot.entOtp();


            SelenideElement pinInput = $(byName("pin"));


            String pinCode = DataGenerator.otp;


            try {
                Robot robot = new Robot();
                for (char c : pinCode.toCharArray()) {
                    pinInput.sendKeys(Character.toString(c));
                    robot.delay(100);
                }
            } catch (AWTException e) {
                e.printStackTrace();

            }

        }
}
