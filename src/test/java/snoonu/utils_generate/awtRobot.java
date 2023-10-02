package snoonu.utils_generate;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.helpers.DriverHelper.byTestId;

public class awtRobot {

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

        Thread.sleep(3000);
        if ($(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/p[1]")).exists()) { //Wrong code

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
        } else {
            // Не выполнять шаг, если status равен false
        }
    }
}




