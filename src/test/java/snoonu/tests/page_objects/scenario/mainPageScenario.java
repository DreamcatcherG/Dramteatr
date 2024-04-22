package snoonu.tests.page_objects.scenario;

import snoonu.tests.page_objects.pages.mainPageObjects;

import static com.codeborne.selenide.Condition.visible;

public class mainPageScenario {

    private static final snoonu.tests.page_objects.pages.mainPageObjects mainPageObjects = new mainPageObjects();

    public static void assertSuccessAuth() {
        mainPageObjects.profileIcon().shouldBe(visible);
    }
}
