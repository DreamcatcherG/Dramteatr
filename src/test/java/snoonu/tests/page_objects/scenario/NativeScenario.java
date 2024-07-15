package snoonu.tests.page_objects.scenario;

import com.codeborne.selenide.Selenide;
import snoonu.utils_generate.AwtRobot;

import static snoonu.tests.page_objects.pages.logInObjects.*;

public class NativeScenario {

    public static void switchToNewTab() {
        Selenide.switchTo().window(1);
        // Close previous tab
//        Selenide.switchTo().window(0).close();

    }

}
