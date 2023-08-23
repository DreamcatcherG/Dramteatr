package snoonu.tests.web.location;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import snoonu.tests.TestBase;
import snoonu.utils_generate.Auth;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("web")
@Tag("addLocal")

public class SelLocWithoutAuth extends TestBase {


    @Test
    void SelLocWithoutAuth() {


        step("Open Web Page", () -> {

            open("http://snoonu.com");

        });

        step("Select Test Location", () -> {

            $(byTestId("selectLocation")).click();
            $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
            $(byTestId("crossIcon")).click();
            $(byName("address")).sendKeys("532M+GG, Al Ruwais");
            $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
            $(byTestId("addressPrediction")).shouldHave(text("532M+GG Al Ruwais")).click();
            $(byName("address")).shouldHave(value("532M+GG, 532M+GG, Al Ruwais"));
            $(byTestId("crossIcon")).click();
            $(byTestId("loginContinue")).shouldHave(text("Confirm location")).click();

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
            $(byName("address")).sendKeys("57F3+C2 Khasooma");
            $(byTestId("addressPrediction")).shouldHave(text("57F3+C2 Khasooma")).click();
            $(byName("address")).shouldHave(value("57F3+C2, 57F3+C2, Khasooma"));

        });

        step("Confirm the location", () -> {

            $(byTestId("loginContinue")).shouldHave(text("Confirm location")).click();

        });

        step("Fill in the address form", () -> {

            $(byName("apartment")).sendKeys("Office");
            $(byTestId("work")).click();
            $(byName("notes")).sendKeys("Here should be notes for Drivers");
        });

        step("Save the location", () -> {

            $(byTestId("saveAddress")).shouldBe(visible).click();
            sleep(5000);

        });

    }

}
