package snoonu.tests.page_objects.scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import snoonu.utils_generate.AwtRobot;
import snoonu.utils_generate.TextGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static snoonu.helpers.DriverHelper.byTestId;
import static snoonu.tests._other_patterns.super_difficult_component.extentions.SelenideExtentions.$;
import static snoonu.tests.page_objects.pages.locationObjects.*;
import static snoonu.tests.page_objects.pages.mainPageObjects.locationBtn;
import static snoonu.tests.page_objects.pages.mainPageObjects.profileIcon;
import static snoonu.tests.page_objects.pages.profileObjects.savedAddresses;
import static snoonu.utils_generate.RandomIDSelector.getRandomID;

public class locationScenario {

    private static String lastEnteredAddress;

    public static void selectTestLocation() throws InterruptedException, IOException {
        selectLocationBtn().click();
        confirmBtnMapWindow().shouldHave(text("Confirm location"));
        inputAddress();
    }

    public static void inputAddress() throws InterruptedException, IOException {
        crossIconX().shouldBe(visible).click();
        lastEnteredAddress = AwtRobot.entLoc();
        addressPredictionField().shouldBe(appear);
        addressPredictionField().shouldHave(text(lastEnteredAddress));
        sleep(2000);
        addressPredictionField().shouldBe(enabled).click();
        addressPredictionField().shouldBe(disappear);
        sleep(2000); // here should add checking api request instead of sleep Like:
        // String apiUrl = Environment.webPage.equals(Environment.stageUrl) ?
        // "https://qa.snoonu.com/_next/data/VNfspcDq8WlGYscEAjpN7/en.json" :
        // "https://snoonu.com/_next/data/uQARuxrLqw3lRG9VH-mpa/en.json";
        // LoadPage.waitForApiResponse(apiUrl);
        confirmBtnMapWindow().shouldBe(visible).click();
    }

    public static void removeNewSavedAddress() throws InterruptedException {
        profileIcon().shouldBe(visible).click();
        savedAddresses().shouldBe(visible).click();
        cardAddressName().shouldBe(visible);
        sleep(2000);
        String addressBeforeDeletion = cardAddressName().getText();
        pencilBtn().shouldBe(appear).click();
        deleteAddressBtn().shouldBe(enabled).click();
        delConfirmYesBtn().shouldBe(enabled).click();
        delConfirmYesBtn().shouldBe(disappear);
        sleep(1000); // waiting when address name will update
        String addressAfterDeletion = cardAddressName().getText();
        assertNotEquals(addressBeforeDeletion, addressAfterDeletion, "The saved address was removed");
    }

    public static void assertLocApplied() throws InterruptedException, IOException {
        String buttonText = locationBtn().getText();
        assertNotEquals("Doha, Qatar", buttonText, "Location button text matches unexpected value");
        assertNotEquals("Al Najada, Doha, Doha, Qatar", buttonText, "Location button text matches unexpected value");
    }

    public static void assertLocNameCorrect() throws InterruptedException, IOException {
        String buttonText = addressInputField().getText();
        assertNotEquals("Doha, Qatar", buttonText, "Location button text matches unexpected value");
        assertNotEquals("Al Najada, Doha, Doha, Qatar", buttonText, "Location button text matches unexpected value");
    }

    public static void confirmNoMainPopup() {
        delConfirmNoBtn().shouldBe(appear).click();
    }

    public static void confirmLastOrAddNewAddress() throws InterruptedException, IOException {
        $(By.cssSelector(".Popup_popup__PEvWF.LocationBlock_popup__79Z9V")).shouldBe(appear);
        if (delConfirmYesBtn().exists())
        {
            delConfirmNoBtn().click();
        } else {
            selectTestLocation();
        }
    }

    public static void editSavedLocation() throws InterruptedException, IOException {
        pencilBtn().shouldBe(appear, visible);
        pencilBtn().click();
        addressInputField().click();
        inputAddress();
        fillAddressField();
        clickSaveAddress();
    }

    public static String fillAddressField() {
        String randomApartName = TextGenerator.getRandomAlphaNumeric(1, 10);
        apartmentInputField().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        apartmentInputField().setValue(randomApartName); // тут сохрани это значение и отправь его сюда  nameLocationCard().shouldHave(text(enteredAddressName));
        String randomNotes = TextGenerator.getRandomText(1, 10);
        notesInputField().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        notesInputField().setValue(randomNotes);
        String[] testIds = {"custom", "work", "home"};
        $(byTestId(getRandomID(testIds))).click();

        String enteredAddressName = randomApartName;
        if (customNameInputField().exists()) {
            randomApartName = TextGenerator.getRandomText(1, 10);
            customNameInputField().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
            customNameInputField().setValue(randomApartName);
        }
        return enteredAddressName;
    }

    public static void assertAddressEdited()  {
        String enteredAddressName = fillAddressField();
        if (cardSavedAddress().exists()) {
            nameLocationCard().shouldHave(text(enteredAddressName));
        }else{
            locationBtn().click();
            nameLocationCard().shouldHave(text(enteredAddressName));
        }
    }

    public static void addNewAddress() throws InterruptedException, IOException {
        addNewAddressBtn().shouldBe(visible).click();
        confirmBtnMapWindow().shouldHave(text("Confirm location"));
        inputAddress();
    }

    public static void clickSaveAddress() {
        saveAddressBtn().shouldBe(visible);
        saveAddressBtn().click();
    }
}


