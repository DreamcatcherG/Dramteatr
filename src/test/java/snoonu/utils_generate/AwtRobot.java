package snoonu.utils_generate;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.awt.*;
import java.awt.event.KeyEvent;

import static snoonu.page_object.elements.LocationObjects.addressInputField;
import static snoonu.page_object.elements.LogInObjects.pinField;
import static snoonu.page_object.elements.LogInObjects.wrongPinText;
import static snoonu.tests.TestData.CenterDoha;

public class AwtRobot {

    public static void entOtp() throws InterruptedException {
        pinField().shouldBe(Condition.visible);
        SelenideElement pinInput = pinField();
        String pinCode = DataGenerator.otp;
        int maxAttempts = 5;
        int attempts = 0;

        try {
            Robot robot = new Robot();
            while (attempts < maxAttempts) {
                for (char c : pinCode.toCharArray()) {
                    pinInput.sendKeys(Character.toString(c));
                    robot.delay(100);
                }
                Thread.sleep(2000);
                if (wrongPinText().exists()) {
                    attempts++;
                    if (attempts >= maxAttempts) {
                        throw new AssertionError("Wrong Otp after 5 attempts");
                    }
                    pinInput.doubleClick();
                } else {
                    break;
                }
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void wrongEntOtp() throws InterruptedException {
        pinField().shouldBe(Condition.visible);
        SelenideElement pinInput = pinField();
        String pinCode = "123456";

        try {
            Robot robot = new Robot();
            pinInput.click();

            for (char c : pinCode.toCharArray()) {
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
                robot.delay(100);
            }

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static String entLoc() throws InterruptedException {
        SelenideElement addressInput = addressInputField();
        String addressName = TextGenerator.getTestRandomLoc();

        try {
            Robot robot = new Robot();
            for (char c : addressName.toCharArray()) {
                String character = Character.toString(c);
                addressInput.sendKeys(character);
                robot.delay(50);
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return addressName;
    }

    public static String entCenterOfDoha() throws InterruptedException {
        SelenideElement addressInput = addressInputField();
        String addressName = CenterDoha;

        try {
            Robot robot = new Robot();
            for (char c : addressName.toCharArray()) {
                String character = Character.toString(c);
                addressInput.sendKeys(character);
                robot.delay(50);
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return addressName;
    }

    public static String entWrongLoc() throws InterruptedException {
        SelenideElement addressInput = addressInputField();
        String addressName = TextGenerator.getWrongRandomLoc();

        try {
            Robot robot = new Robot();
            for (char c : addressName.toCharArray()) {
                String character = Character.toString(c);
                addressInput.sendKeys(character);
                robot.delay(50);
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return addressName;
    }
}





