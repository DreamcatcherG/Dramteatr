package snoonu.utils_generate;

import com.codeborne.selenide.SelenideElement;

import java.awt.*;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class awtRobot {

    public static void entOtp() {

            // Найти элемент для ввода пин-кода
            SelenideElement pinInput = $(byName("pin"));

// Текст пин-кода, который нужно ввести
            String pinCode = DataGenerator.otp;

// Медленный ввод текста с задержкой в 100 миллисекунд между символами
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
