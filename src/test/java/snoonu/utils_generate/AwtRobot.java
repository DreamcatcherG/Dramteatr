package snoonu.utils_generate;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.awt.*;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.drivers.DriverHelper.byDataTestId;
import static snoonu.drivers.DriverHelper.byTestId;
import static snoonu.page_object.elements.LocationObjects.addressInputField;

public class AwtRobot {

    public static void entOtp() throws InterruptedException { // awtRobot.entOtp();
        $(byAttribute("id", "modalContent")).shouldBe(Condition.visible);
        SelenideElement pinInput = $(byName("pin"));
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
                if ($(byDataTestId("wrong-code")).exists()) {
                    attempts++;
                    if (attempts >= maxAttempts) {
                        throw new AssertionError("Wrong Otp after 5 attempts");
                    }
                    $(byDataTestId("backIconBtn")).shouldBe(Condition.enabled);
                    $(byDataTestId("backIconBtn")).click();
                    $(byTestId("loginContinue")).click();
                } else {
                    break;
                }
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

//    public static void LocKhasooma() throws InterruptedException { //awtRobot.LocKhasooma();
//        SelenideElement addressInput = $(byName("address"));
////        String addressName = TextGenerator.getKhasooma(16, 17);
//
//        try {
//            Robot robot = new Robot();
//            for (char c : addressName.toCharArray()) {
//                String character = Character.toString(c);
//                addressInput.sendKeys(character);
//                robot.delay(20);
//            }
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//    }
}





