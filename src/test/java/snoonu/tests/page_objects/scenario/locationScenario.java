package snoonu.tests.page_objects.scenario;

import snoonu.tests.page_objects.pages.locationObjects;
import snoonu.tests.page_objects.pages.mainPageObjects;
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
import static snoonu.tests.page_objects.pages.mainPageObjects.profileIcon;
import static snoonu.tests.page_objects.pages.profileObjects.savedAddresses;
import static snoonu.utils_generate.RandomIDSelector.getRandomID;

public class locationScenario {

    private static String lastEnteredAddress;

    public static void selectTestLocation() throws InterruptedException, IOException {
        selectLocationBtn().click();
        confirmLocBtn().shouldHave(text("Confirm location"));
        crossIconX().shouldBe(visible).click();
        lastEnteredAddress = AwtRobot.entLoc();
        addressPredictionField().shouldBe(visible);
        addressPredictionField().shouldHave(text(lastEnteredAddress));
        addressPredictionField().hover().click();
        sleep(2000); // here should add checking api request instead of sleep Like:
        // String apiUrl = Environment.webPage.equals(Environment.stageUrl) ?
        // "https://qa.snoonu.com/_next/data/VNfspcDq8WlGYscEAjpN7/en.json" :
        // "https://snoonu.com/_next/data/uQARuxrLqw3lRG9VH-mpa/en.json";
        // LoadPage.waitForApiResponse(apiUrl);
        addressPredictionField().shouldNotBe(visible);
        confirmLocBtn().shouldBe(visible).click();

    }

    public static void assertLocApplied() throws InterruptedException, IOException {
        String buttonText = mainPageObjects.locationBtn().getText();
        assertNotEquals("Doha, Qatar", buttonText, "Location button text matches unexpected value");
        assertNotEquals("Al Najada, Doha, Doha, Qatar", buttonText, "Location button text matches unexpected value");
    }

    public static void assertLocNameCorrect() throws InterruptedException, IOException {
        String buttonText = locationObjects.addressInputField().getText();
        assertNotEquals("Doha, Qatar", buttonText, "Location button text matches unexpected value");
        assertNotEquals("Al Najada, Doha, Doha, Qatar", buttonText, "Location button text matches unexpected value");
    }

    public static void confirmNoMainPopup() {
        delConfirmNoBtn().shouldBe(appear);
        delConfirmNoBtn().click();
    }

    public static void addNewAddress() throws InterruptedException, IOException {
        $(byTestId("addNewAddress")).shouldBe(visible).click();
        confirmLocBtn().shouldHave(text("Confirm location"));
        crossIconX().shouldBe(visible).click();
        lastEnteredAddress = AwtRobot.entLoc();
        addressPredictionField().shouldBe(visible);
        addressPredictionField().shouldHave(text(lastEnteredAddress));
        addressPredictionField().hover().click();
        sleep(2000); // here should add checking api request instead of sleep Like:
        // String apiUrl = Environment.webPage.equals(Environment.stageUrl) ?
        // "https://qa.snoonu.com/_next/data/VNfspcDq8WlGYscEAjpN7/en.json" :
        // "https://snoonu.com/_next/data/uQARuxrLqw3lRG9VH-mpa/en.json";
        // LoadPage.waitForApiResponse(apiUrl);
        addressPredictionField().shouldNotBe(visible);
        confirmLocBtn().shouldBe(visible).click();
    }

    public static void fillAddressField() {
        String randomText = TextGenerator.getRandomAlphaNumeric(1, 10);
        apartmentInputField().setValue(randomText);

        String randomNotes = TextGenerator.getRandomText(1, 10);
        notesInputField().setValue(randomNotes);

        String[] testIds = {"custom", "work", "home"};
        $(byTestId(getRandomID(testIds))).click();

        if (customNameInputField().exists()) {
            randomText = TextGenerator.getRandomText(1, 10);
            customNameInputField().setValue(randomText);
        }
    }

    public static void clickSaveAddress() {
        saveAddressBtn().shouldBe(visible);
        saveAddressBtn().click();
    }

    public static void removeNewSavedAddress() throws InterruptedException {
        profileIcon().shouldBe(visible).click();
        savedAddresses().shouldBe(visible).click();
        cardAddressName().shouldBe(visible);

        String addressBeforeDeletion = cardAddressName().getText();
        System.out.println("Address before deletion: " + addressBeforeDeletion);
        pencilBtn().shouldBe(appear).click();
        deleteAddressBtn().shouldBe(appear).click();
        delConfirmYesBtn().shouldBe(appear).click();
        delConfirmYesBtn().shouldBe(disappear);
        sleep(1000); // waiting when address will removed
        String addressAfterDeletion = cardAddressName().getText(); // Получаем текст после удаления
        System.out.println("Address after deletion: " + addressAfterDeletion);
        assertEquals(addressBeforeDeletion, addressAfterDeletion, "The saved address was removed");
    }

}


