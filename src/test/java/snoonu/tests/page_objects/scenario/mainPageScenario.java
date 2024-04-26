package snoonu.tests.page_objects.scenario;

import org.bouncycastle.util.test.TestFailedException;
import org.junit.jupiter.api.Assertions;
import snoonu.tests.page_objects.pages.mainPageObjects;

import static com.codeborne.selenide.Condition.*;
import static snoonu.tests.page_objects.pages.locationObjects.locationPopup;
import static snoonu.tests.page_objects.pages.logInObjects.loginBtn;
import static snoonu.tests.page_objects.pages.mainPageObjects.*;

public class mainPageScenario {

    private static final snoonu.tests.page_objects.pages.mainPageObjects mainPageObjects = new mainPageObjects();

    public static void goToProfile() {
        profileIcon().shouldBe(visible).click();
    }

    public static void assertSuccessAuth() {
        profileIcon().shouldBe(visible);
    }

    public static void goToBeautyPerfumes() {
        beautyPerfumesCategory().shouldBe(visible).click();
    }

    public static void goToElectronics() {
        electronicsCategory().shouldBe(visible).click();
    }

    public static void goToFlowersAnsGifts() {
        flowersAnsGiftsCategory().shouldBe(visible).click();
    }

    public static void goToHealthAndWellness() {
        healthAndWellnessCategory().shouldBe(visible).click();
    }

    public static void goToKidsAndStationery() {
        kidsAndStationery().shouldBe(visible).click();
    }

    public static void goToPets() {
        pets().shouldBe(visible).click();
    }

    public static void goToShops() {
        shops().shouldBe(visible).click();
    }

    public static void goToSnoomart() {
        snoomart().shouldBe(visible).click();
    }

    public static void goToGroceries() {
        groceries().shouldBe(visible).click();
    }

    public static void goToFood() {
        food().shouldBe(visible).click();
    }

    public static void goToSnoosend() {
        snoosend().shouldBe(visible).click();
    }

    public static void closeLocationPopup() {
        locationPopup().shouldBe(visible).click();
    }

    public static void expandServiceBoxes() {
        moreCategoryBtn().shouldBe(visible).click();
        lessCategoryBtn().shouldHave(text("Less"));
    }

    public static void assertPageOpened(String expectedUrlPart) {
        cssUrl().shouldHave(attribute("content", expectedUrlPart));
    }

    public static void assertSnoosendPopupOpened() {
        snoosendPopupText().shouldHave(text("Your personal door-to-door delivery service"));
    }

    public static void assertIsOngoingOrders() {
        if (orderWidget().exists() && orderWidget().isDisplayed()) {
            Assertions.fail("User has ongoing order! Deleting the profile impossible!");
        }
    }

    public static void assertProfileDeleted() {
        loginBtn().shouldBe(visible, enabled);
    }
}



