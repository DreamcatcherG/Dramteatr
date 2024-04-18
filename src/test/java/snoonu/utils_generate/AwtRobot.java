package snoonu.utils_generate;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.awt.*;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.helpers.DriverHelper.byTestId;

public class AwtRobot {

    public static void entOtp() throws InterruptedException { // awtRobot.entOtp();

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

        Thread.sleep(2000);
        if ($(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/p[1]")).exists()) { // Wrong code

            $(("#modal-root > div > div > div > div > span.Icon_icon__DoDXU.Modal_back__rc_xF > span > img")).click();
            $(byTestId("loginContinue")).click();

            pinInput = $(byName("pin"));
            pinCode = DataGenerator.otp;

            try {
                Robot robot = new Robot();
                for (char c : pinCode.toCharArray()) {
                    pinInput.sendKeys(Character.toString(c));
                    robot.delay(100);
                }
            } catch (AWTException e) {
                e.printStackTrace();
            }
        } else {}

        Thread.sleep(2000);
        if ($(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/p[1]")).exists()) { // Wrong code
            SelenideElement selenideElement = $("#modal-root > div > div > div > div > span.Icon_icon__DoDXU.Modal_back__rc_xF > span > img")
                    .waitUntil(Condition.appear, 5000);
            $(("#modal-root > div > div > div > div > span.Icon_icon__DoDXU.Modal_back__rc_xF > span > img")).click();
            $(byTestId("loginContinue")).click();

            pinInput = $(byName("pin"));
            pinCode = DataGenerator.otp;

            try {
                Robot robot = new Robot();
                for (char c : pinCode.toCharArray()) {
                    pinInput.sendKeys(Character.toString(c));
                    robot.delay(100);
                }
            } catch (AWTException e) {
                e.printStackTrace();
            }
        } else {}
    }

    public static void entLoc() throws InterruptedException { //awtRobot.entLoc();
        SelenideElement addressInput = $(byName("address"));
        String addressName = TextGenerator.getRandomLoc(16, 17);

        try {
            Robot robot = new Robot();
            for (char c : addressName.toCharArray()) {
                String character = Character.toString(c);
                addressInput.sendKeys(character);
                robot.delay(20);
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }


    public static void LocKhasooma() throws InterruptedException { //awtRobot.LocKhasooma();
        SelenideElement addressInput = $(byName("address"));
        String addressName = TextGenerator.getKhasooma(16, 17);

        try {
            Robot robot = new Robot();
            for (char c : addressName.toCharArray()) {
                String character = Character.toString(c);
                addressInput.sendKeys(character);
                robot.delay(20);
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}





