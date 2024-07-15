package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.helpers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.tests.TestData.Number208;
import static snoonu.tests.page_objects.scenario.locationScenario.*;
import static snoonu.tests.page_objects.scenario.logInScenario.defaultProfile;

@Feature("Selenide_Web")
@Story("Smoke tests Web")
@Tag("smokeStage")

public class AddNewAddressHasSavedAddress extends TestBase {

    @Test
    void addLocation() {

        step("Preconditions: Open Web Page / Log In", () -> {
            open(Environment.webPage);
            defaultProfile(Number208);
        });

        step("No Confirm and Go to add new location", () -> {
            confirmNoMainPopup();
            addNewAddress();
        });

        step("Assert Location name is correct", () -> {
            assertLocNameCorrect();
        });

        step("Filling the address forms with random values", () -> {
            fillAddressField();
        });

        step("Save the location", () -> {
            clickSaveAddress();
        });

        step("Assert Location was saved and applied", () -> {
            assertLocApplied();
        });

        step("Post conditions: Remove saved locations", () -> {
            removeNewSavedAddress();
        });

    }

}

