package snoonu.tests.web.smokeTests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.LocationScenario.*;
import static snoonu.page_object.scenario.LogInScenario.logginInNumberOtp;
import static snoonu.tests.TestData.Number208;

@Tag("smoke")

public class AddingAddressHasSavedAddress extends TestBase {

    @Test
    void addLocation() {

        step("Preconditions: Open Web Page / Log In with 208", () -> {
            open(Environment.webPage);
            logginInNumberOtp(Number208);
        });

        step("No Confirm Address in Location Popup", () -> {
            confirmNoLocationPopup();
        });

        step("Go to add new location button", () -> {
            addNewAddressButton();
        });

        step("Select Test Address", () -> {
            selectTestAddressOnMap();
        });

        step("Assert Location name is correct in Location Modal", () -> {
            isSelectedLocationCorrectInModal();
        });

        step("Filling the address forms with random values", () -> {
            randomFillAddressFields();
        });

        step("Save the location", () -> {
            clickSaveAddressBtn();
        });

        step("Assert Location was saved and applied", () -> {
            assertLocAppliedInHeader();
        });

        step("Post conditions: Remove saved location", () -> {
            removeNewSavedAddress();
        });

    }

}

