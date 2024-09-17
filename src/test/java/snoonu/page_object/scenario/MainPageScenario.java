package snoonu.page_object.scenario;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import snoonu.utils_generate.TextGenerator;

import static com.codeborne.selenide.Condition.*;
import static snoonu.page_object.elements.HeaderObjects.*;
import static snoonu.page_object.elements.LogInObjects.wrongPinText;
import static snoonu.page_object.elements.MainPageObjects.*;

public class MainPageScenario {

    public static void goToProfile() {
        profileIcon().shouldBe(visible).click();
    }

    public static void assertSuccessAuth() {
        profileIcon().shouldBe(visible);
    }

    public static void assertOtpWrong() {
        wrongPinText().shouldBe(appear);
    }

    public static void wrongGlobalSearchRequest() {
        searchField().shouldBe(enabled).setValue("Капибара");
        searchFieldButton().click();
    }

    public static void assertNothingFoundResult() {
        nothingFoundText().shouldBe(visible).shouldHave(text("Nothing has been found"));
    }

    public static void goToWriteToUsBtn() {
        emptySearchWriteToUsBTN().shouldBe(visible).click();
        writeToUsCommentField().shouldBe(enabled);
        writeToUsCommentField().sendKeys(TextGenerator.getRandomText(1, 50));
        sendFeedbackBtn().shouldBe(enabled).click();
        sendFeedbackBtn().shouldBe(disappear);
    }

    public static void writeAndSendRequest() {
        emptySearchWriteToUsBTN().shouldBe(visible).click();
        writeToUsCommentField().shouldBe(enabled);
        writeToUsCommentField().sendKeys(TextGenerator.getRandomText(1, 50));
        sendFeedbackBtn().shouldBe(enabled).click();
        sendFeedbackBtn().shouldBe(disappear);
    }

    public static void goToRestaurants() {
        categoryIcon().findBy(text("Restaurants")).click();
    }

    public static void goToSnoomart() {
        categoryIcon().findBy(text("Snoomart")).click();
    }

    public static void goToGroceries() {
        categoryIcon().findBy(text("Grocery")).click();
    }

    public static void goToGifting() {
        categoryIcon().findBy(text("Gifting")).click();
    }

    public static void goToPharmacy() {
        categoryIcon().findBy(text("Pharmacy")).click();
    }

    public static void goToHealthAndBeauty() {
        categoryIcon().findBy(text("Health & Beauty")).click();
    }

    public static void goToElectronics() {
        categoryIcon().findBy(text("Electronics")).click();
    }

    public static void goToBabyAndKids() {
        categoryIcon().findBy(text("Baby & Kids")).click();
    }

    public static void goToPets() {
        categoryIcon().findBy(text("Pets")).click();
    }

    public static void goToHouseholdAndGarden() {
        categoryIcon().findBy(text("Household & Garden")).click();
    }

    public static void goToBooksAndStationery() {
        categoryIcon().findBy(text("Books & Stationery")).click();
    }

    public static void goToSportsAndOutdoors() {
        categoryIcon().findBy(text("Sports & Outdoor")).click();
    }

    public static void goToClothesAndAccessories() {
        categoryIcon().findBy(text("Clothes & Accessories")).click();
    }

    public static void closeLocationPopup() {
        locationPopup().shouldBe(visible).click();
    }

    public static void expandServiceBoxes() {
        showMoreOnServiseBoxes().shouldBe(visible).click();
        showMoreOnServiseBoxes().shouldHave(text("Less"));
    }

    public static void assertIsOngoingOrders() {
        if (orderWidget().exists() && orderWidget().isDisplayed()) {
            Assertions.fail("User has ongoing order! Deleting the profile impossible!");
        }
    }

    public static void assertLoginBtnVisible() {
        loginBtn().shouldBe(visible, enabled);
    }

    public static void searchTestMerchant() {
        searchField().shouldBe(enabled).sendKeys("Fake Devices Store");
        searchField().pressEnter();

    }
}



