package snoonu.tests.web.location;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
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

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("web")
@Tag("delLocal")

public class DelLocViaMainPage extends TestBase {

    @Test
    @DisplayName("Delete a location via MainPage")
    void delLocViaMainPage() {

        step("Go to login page", () -> {

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
            $(byTestId("loginContinue")).shouldBe(disappear);

        });

        step("Fill the authorization form", () -> {

            logInScenario.defaultProfile(Number208);

        });

        step("No Confirm the last selected location", () -> {

            if ($(byTestId("deleteConfirmYes")).exists()) {

                $(byTestId("deleteConfirmNo")).click();

            } else {

                $(byTestId("locationSelector")).shouldBe(visible).click();
                $(byTestId("deleteConfirmNo")).click();

            }

        });

        step("Add a location if it doesn't available", () -> {

            if (!$(byTestId("addressEdit")).exists()) {

                $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
                $(byName("address")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                AwtRobot.entLoc();
                $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
                $(byTestId("addressPrediction")).click();
                sleep(1000);
                $(byTestId("loginContinue")).shouldHave(text("Confirm location")).click();

                String randomText = TextGenerator.getRandomFlatName(1, 10);
                $(byName("apartment")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                $(byName("apartment")).setValue(randomText);
                String randomNotes = TextGenerator.getRandomFlatName(1, 10);
                $(byName("notes")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                $(byName("notes")).setValue(randomNotes);

                String[] testIds = {"custom", "work", "home"};
                $(byTestId(getRandomID(testIds))).click();

                if ($(byName("customName")).exists()) {

                    $(byName("customName")).setValue(randomText);

                } else {

                }

                $(byTestId("saveAddress")).shouldBe(visible).click();
                $(byTestId("saveAddress")).shouldBe(disappear);
                $(byTestId("locationSelector")).shouldBe(visible).click();

            } else {

            }

        });

        step("Go to delete button and Confirm deleting", () -> {

            $(byTestId("addNewAddress")).shouldBe(appear);
            $(byTestId("cardAddress")).hover();
            $(byTestId("addressEdit")).click();
            $(byTestId("deleteAddress")).shouldBe(visible).click();
            $(byTestId("deleteConfirmYes")).click();
            $(byTestId("deleteConfirmYes")).shouldBe(disappear);
            $(byTestId("locationSelector")).shouldBe(visible);

        });

    }

}