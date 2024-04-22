package snoonu.tests.page_objects.scenario;

import snoonu.helpers.Environment;
import snoonu.tests.page_objects.pages.locationObjects;
import snoonu.tests.page_objects.pages.mainPageObjects;
import snoonu.utils_generate.AwtRobot;
import snoonu.utils_generate.LoadPage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class locationScenario {

    private static String lastEnteredAddress;

    public static void selectNewLocation() throws InterruptedException, IOException {
        locationObjects.selectLocationBtn().click();
        locationObjects.confirmLocBtn().shouldHave(text("Confirm location"));
        locationObjects.crossIconX().shouldBe(visible).click();
        lastEnteredAddress = AwtRobot.entLoc();
        locationObjects.addressPredictionField().shouldBe(visible);
        locationObjects.addressPredictionField().shouldHave(text(lastEnteredAddress));
        locationObjects.addressPredictionField().hover().click();
        sleep(1000);
        locationObjects.addressPredictionField().shouldNotBe(visible);
        locationObjects.confirmLocBtn().shouldBe(visible).click();
        String apiUrl = Environment.webPage.equals(Environment.stageUrl) ?
                "https://qa.snoonu.com/_next/data/VNfspcDq8WlGYscEAjpN7/en.json" :
                "https://snoonu.com/_next/data/uQARuxrLqw3lRG9VH-mpa/en.json";
        LoadPage.waitForApiResponse(apiUrl);
    }

    public static void assertLocApplied() throws InterruptedException {
        String buttonText = mainPageObjects.locationBtn().getText();
        assertNotEquals("Doha, Qatar", buttonText, "Location button text matches unexpected value");
        assertNotEquals("Al Najada, Doha, Doha, Qatar", buttonText, "Location button text matches unexpected value"); // тут допиши что еще не должно совпадать с Doha, Qatar
    }
}

