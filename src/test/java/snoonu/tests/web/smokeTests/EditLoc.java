package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.springframework.core.annotation.Order;
import snoonu.tests.TestBase;
import snoonu.utils_generate.Auth;
import snoonu.utils_generate.AwtRobot;
import snoonu.utils_generate.LoadPage;
import snoonu.utils_generate.TextGenerator;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;
import static snoonu.tests.TestData.sNumber208;
import static snoonu.utils_generate.RandomIDSelector.getRandomID;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(5)
@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("web")
@Tag("smoke")
class EditLoc extends TestBase {

    @Test
    @DisplayName("Edit a location")
    void editLoc() {

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
            LoadPage.pageInit();

        });

        step("Fill the authorization form", () -> {

            Auth.defaultProfile(sNumber208);
        });

        step("No Confirm the last selected location if available", () -> {

            if ($(byTestId("deleteConfirmYes")).exists()) {

                $(byTestId("deleteConfirmYes")).click();

            } else {

                $(byTestId("locationSelector")).shouldBe(visible).click();
                $(byTestId("deleteConfirmYes")).click();

            }

        });

        step("Go to Account button on the main page", () -> {

            $(byTestId("userPreview")).shouldBe(visible).click();
        });

        step("Go to my addresses", () -> {

            $(byTestId("myAddresses")).shouldBe(visible).click();

        });

        step("Go to a pencil button on the first address", () -> {

            if (!$(byTestId("addressEdit")).exists()) {

                $(byTestId("addAddress")).click();
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

                $(byTestId("saveAddress")).click();
                $(byTestId("addNewAddress")).shouldBe(visible);

            } else {

            }

        });

        step("Editing the location", () -> {

            $(byTestId("cardAddress")).hover();
            $(byTestId("addressEdit")).shouldBe(appear).click();
            $(byName("address")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
            AwtRobot.entLoc();
            $(byTestId("addressPrediction")).shouldBe(appear).click();
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

        });

        step("Saving the location", () -> {

            $(byTestId("saveAddress")).shouldBe(visible).click();
            $(byTestId("addNewAddress")).shouldBe(visible);

        });
    }
}