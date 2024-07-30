package snoonu.tests.web.smokeTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.LocationScenario.*;

@Feature("Selenide_Web")
@Story("Smoke tests Web")
@Tag("smokeStage")

public class PickTestLocation extends TestBase {

    @Test
    void addLocation() {

        step("Open Web Page", () -> {
            open(Environment.webPage);
        });

        step("Select A Location", () -> {
            clickToSelectLocation();
        });

        step("Input Random Test Address", () -> {
            inputRandomTestAddressScenario();
        });

        step("Assert: Selected Location is displayed in the Header ", () -> {
            assertLocAppliedInHeader();
        });
    }
}

