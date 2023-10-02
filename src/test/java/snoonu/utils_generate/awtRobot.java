package snoonu.utils_generate;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.awt.*;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
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
//
//
//    public static void entOtp() {
//        $(By.name("pin")).sendKeys("021122");
//
//        int status = 0;
//
//        if ($(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/p[1]")).exists()) {
//            status = 1;
//        }
//
//        if (status == 1) {
//            // Выполнить нужный шаг, если status равен 1
//            $(By.name("pin")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
//            $(By.name("pin")).sendKeys(Keys.BACK_SPACE);
//            $(By.name("pin")).sendKeys("021023");
//        } else {
//            // Не выполнять шаг, если status не равен 1
//            // ...
//        }
//    }
//}