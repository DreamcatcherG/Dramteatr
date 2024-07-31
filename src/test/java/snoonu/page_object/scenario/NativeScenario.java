package snoonu.page_object.scenario;

import com.codeborne.selenide.Selenide;
import snoonu.drivers.Environment;

import static com.codeborne.selenide.Condition.attributeMatching;
import static snoonu.page_object.elements.NativeObjects.cssUrl;

public class NativeScenario {

    public static void switchToNewTab() {
        Selenide.switchTo().window(1);
    }

    public static void assertPageOpened(String expectedUrlPart) {
        try {
            cssUrl().shouldHave(attributeMatching("content", ".*" + expectedUrlPart + ".*"));
        } catch (AssertionError e) {
            throw new AssertionError("URL does not contain the expected part: " + expectedUrlPart);
        }
    }

    public static void assertIsProdEnvironment() {
        if (Environment.environment.equals("prod")) {
            throw new AssertionError("This case can't be checked in production");
        }
    }
}
