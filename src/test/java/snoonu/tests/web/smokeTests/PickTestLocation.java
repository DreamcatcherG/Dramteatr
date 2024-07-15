package snoonu.tests.web.smokeTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.helpers.Environment;
import snoonu.tests.TestBase;
import snoonu.tests.page_objects.scenario.locationScenario;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.tests.page_objects.scenario.locationScenario.assertLocApplied;
import static snoonu.tests.page_objects.scenario.locationScenario.selectTestLocation;

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
            selectTestLocation();
        });

        step("Assert Location was applied", () -> {
            assertLocApplied();
        });
    }
}

