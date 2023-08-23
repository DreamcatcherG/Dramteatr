package snoonu.tests.web.location;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import snoonu.tests.TestBase;
import snoonu.utils_generate.Auth;
import snoonu.utils_generate.DataParamsDev;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;


@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("web")
@Tag("delLocal")
class DelLocViaAcMenu extends TestBase {

    @Test
    @DisplayName("Add a location")
    void successfulLoginTest() {

        step("Go to login page", () -> {

            open("http://snoonu.com");

        });

        step("Fill the authorization form", () -> {

            Auth.fillFormOth();

        });

        step("Confirm the last selected location", () -> {

            $(byTestId("deleteConfirmYes")).click();
            $(byTestId("userPreview")).click();
        });

        step("Go to Account button on the main page", () -> {

            $(byTestId("userPreview")).shouldBe(visible).click();
        });

        step("Go to my addresses", () -> {

            $(byTestId("myAddresses")).shouldBe(appear).click();

        });

        step("Go to a pencil button on the first address", () -> {

            $(byTestId("addressEdit")).click();

        });

        step("Go to delete button / Go to Confirm deleting", () -> {

            $(byTestId("deleteAddress")).shouldBe(visible).click();
            $(byTestId("deleteConfirmYes")).click();
        });
    }
}