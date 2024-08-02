package snoonu.page_object.scenario;

import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import snoonu.utils_generate.TextGenerator;

import static com.codeborne.selenide.Condition.*;
import static snoonu.page_object.elements.HeaderObjects.*;
import static snoonu.page_object.elements.MainPageObjects.*;

public class MainPageScenario {

    public static void goToProfile() {
        profileIcon().shouldBe(visible).click();
    }

    public static void assertSuccessAuth() {
        profileIcon().shouldBe(visible);
    }

    public static void wrongGlobalSearchRequest() {
        searchField().shouldBe(enabled).setValue("Капибара");
        searchField().sendKeys(Keys.ENTER);
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
        snoomart().shouldBe(visible).click();
    }

    public static void goToGroceries() {
        groceries().shouldBe(visible).click();
    }

    public static void goToGifting() {
        gifting().shouldBe(visible).click();
    }

    public static void goToPharmacy() {
        pharmacy().shouldBe(visible).click();
    }

    public static void goToHealthAndBeauty() {
        healthAndBeauty().shouldBe(visible).click();
    }

    public static void goToElectronics() {
        electronics().shouldBe(visible).click();
    }

    public static void goToBabyAndKids() {
        babyAndKids().shouldBe(visible).click();
    }

    public static void goToPets() {
        pets().shouldBe(visible).click();
    }

    public static void goToHouseholdAndGarden() {
        houseAndGarden().shouldBe(visible).click();
    }

    public static void goToBooksAndStationery() {
        booksAndStationery().shouldBe(visible).click();
    }

    public static void goToSportsAndOutdoors() {
        sportsAndOutdoors().shouldBe(visible).click();
    }

    public static void goToClothesAndAccessories() {
        clothesAndAccessories().shouldBe(visible).click();
    }

    public static void closeLocationPopup() {
        locationPopup().shouldBe(visible).click();
    }

    public static void expandServiceBoxes() {
        moreServiceBoxesBtn().shouldBe(visible).click();
        lessCategoryBtn().shouldHave(text("Less"));
    }

    public static void assertSnoosendPopupOpened() {
        snoosendPopupText().shouldHave(text("Your personal door-to-door delivery service"));
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



