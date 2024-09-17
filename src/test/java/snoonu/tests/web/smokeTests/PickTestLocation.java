package snoonu.tests.web.smokeTests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.LocationScenario.*;

@Tag("smoke")
@Tag("pickLocation")

public class PickTestLocation extends TestBase {

    @Test
    void addLocation() {

        step("Open Web Page", () -> {
            open(Environment.webPage);
        });

        step("Select A Location", () -> {
            clickToSelectAddressButton();
        });

        step("Input Random Test Address", () -> {
            inputRandomTestAddressScenario();
        });

        step("Assert: Selected Location is displayed in the Header ", () -> {
            assertLocAppliedInHeader();
        });
    }
}

