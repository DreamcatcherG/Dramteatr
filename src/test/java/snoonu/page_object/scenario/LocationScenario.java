package snoonu.page_object.scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import snoonu.utils_generate.AwtRobot;
import snoonu.utils_generate.TextGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static snoonu.drivers.DriverHelper.byDataTestId;
import static snoonu.drivers.extentions.SelenideExtentions.$;
import static snoonu.page_object.elements.HeaderObjects.locationPopup;
import static snoonu.page_object.elements.HeaderObjects.profileIcon;
import static snoonu.page_object.elements.LocationObjects.*;
import static snoonu.page_object.elements.ProfileObjects.loaderInButtons;
import static snoonu.page_object.elements.ProfileObjects.savedAddresses;
import static snoonu.utils_generate.RandomIDSelector.getRandomID;

public class LocationScenario {

    private static String lastEnteredAddress;

    public static void clickToSelectAddressButton() {
        selectLocationButton().click();
    }

    public static void inputRandomTestAddressScenario() throws InterruptedException, IOException {
        loaderInButtons().shouldBe(disappear);
        crossIconX().shouldBe(visible).click();
        lastEnteredAddress = AwtRobot.entLoc();
        addressPredictionField().shouldBe(appear);
        addressPredictionField().shouldHave(text(lastEnteredAddress));
        sleep(2000);
        addressPredictionField().shouldBe(enabled).click();
        addressPredictionField().shouldBe(disappear);
        sleep(2000);
        /*
        here should add checking api request instead of "sleep" Like:
        String apiUrl = Environment.webPage.equals(Environment.stageUrl) ?
        "https://qa.snoonu.com/_next/data/VNfspcDq8WlGYscEAjpN7/en.json" :
        "https://snoonu.com/_next/data/uQARuxrLqw3lRG9VH-mpa/en.json";
        LoadPage.waitForApiResponse(apiUrl);
         */
        loaderInButtons().shouldBe(disappear);
        confirmBtnOnMap().shouldBe(enabled).click();
    }

    public static void removeNewSavedAddress() throws InterruptedException {
        profileIcon().shouldBe(visible).click();
        savedAddresses().shouldBe(visible).click();
        savedAddressCard().shouldBe(visible);
        sleep(2000);
        String addressBeforeDeletion = savedAddressCard().getText();
        pencilBtn().shouldBe(appear).click();
        deleteAddressBtn().shouldBe(enabled).click();
        yesDeleteAddressConfirmBtn().shouldBe(enabled).click();
        loaderInButtons().shouldBe(disappear);
        sleep(3000);
        /*
         waiting when address name will update
         */
        String addressAfterDeletion = savedAddressCard().getText();
        assertNotEquals(addressBeforeDeletion, addressAfterDeletion, "The saved address was not removed");
    }

    public static void assertLocAppliedInHeader() {
        String buttonText = locationPopup().getText();
        assertNotEquals("Doha, Qatar", buttonText, "Location button text matches unexpected value");
        assertNotEquals("Al Najada, Doha, Doha, Qatar", buttonText, "Location button text matches unexpected value");
    }

    public static void isSelectedLocationCorrectInModal() {
        String buttonText = addressInputField().getText();
        assertNotEquals("Doha, Qatar", buttonText, "Location button text matches unexpected value");
        assertNotEquals("Al Najada, Doha, Doha, Qatar", buttonText, "Location button text matches unexpected value");
    }

    public static void confirmNoLocationPopup() {
        dontDeleteAddressConfirmBtn().shouldBe(appear).click();
    }

    public static void confirmLastOrAddNewAddress() throws InterruptedException, IOException {
        $(By.cssSelector(".Popup_popup__PEvWF.LocationBlock_popup__79Z9V")).shouldBe(appear);
        if (yesDeleteAddressConfirmBtn().exists()) {
            dontDeleteAddressConfirmBtn().click();
        } else {
            inputRandomTestAddressScenario();
        }
    }

    public static void editSavedLocation() throws InterruptedException, IOException {
        pencilBtn().shouldBe(appear, visible);
        pencilBtn().click();
        addressInputField().click();
        inputRandomTestAddressScenario();
        randomFillAddressFields();
        clickSaveAddressBtn();
    }

    public static String randomFillAddressFields() {
        String randomApartName = TextGenerator.getRandomAlphaNumeric(1, 10);
        apartmentInputField().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        apartmentInputField().setValue(randomApartName);
        String randomNotes = TextGenerator.getRandomText(1, 10);
        driverNotesInputField().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        driverNotesInputField().setValue(randomNotes);
        String[] testIds = {"customBtn", "workBtn", "homeBtn"};
        $(byDataTestId(getRandomID(testIds))).click();

        String enteredAddressName = randomApartName;
        if (customNameInputField().exists()) {
            randomApartName = TextGenerator.getRandomText(1, 10);
            customNameInputField().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
            customNameInputField().setValue(randomApartName);
        }
        return enteredAddressName;
    }

    public static void assertAddressEdited() {
        String enteredAddressName = randomFillAddressFields();
        if (cardSavedAddress().exists()) {
            nameLocationCard().shouldHave(text(enteredAddressName));
        } else {
            locationPopup().click();
            nameLocationCard().shouldHave(text(enteredAddressName));
        }
    }

    public static void addNewAddressButton() {
        addNewAddressBtn().shouldBe(visible).click();
    }

    public static void selectTestAddressOnMap() throws InterruptedException, IOException {
        confirmBtnOnMap().shouldHave(text("Confirm location"));
        inputRandomTestAddressScenario();
    }

    public static void clickSaveAddressBtn() {
        saveAddressBtn().shouldBe(enabled);
        saveAddressBtn().click();
    }
}


