package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.helpers.Environment;
import snoonu.tests.TestBase;
import snoonu.tests.page_objects.scenario.locationScenario;
import snoonu.tests.page_objects.scenario.logInScenario;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.tests.TestData.Number208;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("smoke")

public class AddNewAddressHasSavedAddress extends TestBase {

    @Test
    void addLocation() {

        step("Open Web Page", () -> {
            open(Environment.webPage);
        });

        step("Fill the authorization form", () -> {
            logInScenario.defaultProfile(Number208);
        });

        step("No Confirm and add new location", () -> {


        });


        step("Assert Location was applied", () -> {
            locationScenario.assertLocApplied();
        });
//
//        step("No Confirm and add new location", () -> {
//
//            if (!$(byTestId("deleteConfirmYes")).exists()) {
//
//                $(byTestId("locationSelector")).click();
//
//            } else {
//
//            }
//
//            $(byTestId("deleteConfirmNo")).shouldBe(visible).click();
//            if ($(byTestId("addNewAddress")).exists()) {
//
//                $(byTestId("addNewAddress")).click();
//
//            } else {
//
//            }
//
//            $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
//            $(byName("address")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
//            AwtRobot.entLoc();
//            $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
//            $(byTestId("addressPrediction")).click();
//            sleep(1000);
//            $(byTestId("loginContinue")).shouldHave(text("Confirm location")).click();
//
//        });
//
//
//        step("Filling the address forms with random values", () -> {
//
//            String randomText = TextGenerator.getRandomFlatName(1, 10);
//            $(byName("apartment")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
//            $(byName("apartment")).setValue(randomText);
//            String randomNotes = TextGenerator.getRandomFlatName(1, 10);
//            $(byName("notes")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
//            $(byName("notes")).setValue(randomNotes);
//
//            String[] testIds = {"custom", "work", "home"};
//            $(byTestId(getRandomID(testIds))).click();
//
//            if ($(byName("customName")).exists()) {
//
//                $(byName("customName")).setValue(randomText);
//            } else {
//
//            }
//
//        });
//
//        step("Save the location", () -> {
//
//            $(byTestId("saveAddress")).shouldBe(visible).click();
//            $(byTestId("saveAddress")).shouldBe(disappear);
//
//        });
    }

}

