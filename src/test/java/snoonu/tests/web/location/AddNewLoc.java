package snoonu.tests.web.location;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import snoonu.tests.TestBase;
import snoonu.tests.page_objects.scenario.logInScenario;
import snoonu.utils_generate.*;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;
import static snoonu.tests.TestData.Number208;
import static snoonu.utils_generate.RandomIDSelector.getRandomID;

@Feature("Selenide_Web")
@Story("Smoke tests Web")
@Tag("web")
@Tag("addLocal")

public class AddNewLoc extends TestBase {

    @Test
    void addLocation() {

        step("Open Web Page", () -> {

            open("http://snoonu.com");

        });

        step("Select A Location", () -> {

            $(byTestId("selectLocation")).click();
            $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
            $(byTestId("crossIcon")).shouldBe(visible).click();
            AwtRobot.entLoc();
            $(byTestId("addressPrediction")).shouldBe(visible);
            $(byTestId("addressPrediction")).click();
            sleep(1000);
            $(byTestId("loginContinue")).shouldBe(visible).click();
            LoadPage.pageInit();

        });

        step("Fill the authorization form", () -> {

            logInScenario.defaultProfile(Number208);

        });

        step("No Confirm and add new location", () -> {

            if (!$(byTestId("deleteConfirmYes")).exists()) {

                $(byTestId("locationSelector")).click();

            } else {

            }

            $(byTestId("deleteConfirmNo")).shouldBe(visible).click();
            if ($(byTestId("addNewAddress")).exists()) {

                $(byTestId("addNewAddress")).click();

            } else {

            }

            $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
            $(byName("address")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            AwtRobot.entLoc();
            $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
            $(byTestId("addressPrediction")).click();
            sleep(1000);
            $(byTestId("loginContinue")).shouldHave(text("Confirm location")).click();

        });


        step("Filling the address forms with random values", () -> {

            String randomText = TextGenerator.getRandomText(1, 10);
            $(byName("apartment")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            $(byName("apartment")).setValue(randomText);
            String randomNotes = TextGenerator.getRandomText(1, 10);
            $(byName("notes")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            $(byName("notes")).setValue(randomNotes);

            String[] testIds = {"custom", "work", "home"};
            $(byTestId(getRandomID(testIds))).click();

            if ($(byName("customName")).exists()) {

                $(byName("customName")).setValue(randomText);
            } else {

            }

        });

        step("Save the location", () -> {

            $(byTestId("saveAddress")).shouldBe(visible).click();
            $(byTestId("saveAddress")).shouldBe(disappear);

        });
    }

}

