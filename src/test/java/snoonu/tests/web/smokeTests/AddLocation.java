package snoonu.tests.web.smokeTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.tests.TestBase;
import snoonu.utils_generate.Auth;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("smoke")

public class AddLocation extends TestBase {

    @Test
    void addLocation() {

        step("Open Web Page", () -> {

            open("http://snoonu.com");

        });

        step("Fill the authorization form", () -> {

            Auth.fillFormOth();

        });

        step("No Confirm the last selected location", () -> {

            $(byTestId("deleteConfirmNo")).click();

        });

        step("Add a New Location", () -> {

            $(byTestId("addNewAddress")).click();
            $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
            $(byTestId("crossIcon")).click();
            $(byName("address")).sendKeys("532M+GG, 532M+GG, Al Ruwais ");
            $(byTestId("addressPrediction")).shouldHave(text("532M+GG Al Ruwais")).click();
            $(byName("address")).shouldHave(value("532M+GG, 532M+GG, Al Ruwais"));

        });

        step("Confirm the location", () -> {

            $(byTestId("loginContinue")).shouldHave(text("Confirm location")).click();

        });

        step("Fill in the address form", () -> {

            $(byName("apartment")).sendKeys("Al Ruwais");
            $(byTestId("home")).click();
            $(byName("notes")).sendKeys("Here should be notes for Drivers");

        });

        step("Save the location", () -> {

            $(byTestId("saveAddress")).shouldBe(visible).click();

        });
    }


}

