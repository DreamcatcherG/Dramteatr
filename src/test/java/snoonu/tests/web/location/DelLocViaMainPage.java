package snoonu.tests.web.location;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.tests.TestBase;
import snoonu.utils_generate.Auth;
import snoonu.utils_generate.DataParamsDev;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("web")
@Tag("delLocal")

public class DelLocViaMainPage extends TestBase {

    @Test
    @DisplayName("Add a location")
    void successfulLoginTest() {

        step("Go to login page", ()-> {

            open("http://snoonu.com");

        });

        step("Fill the authorization form", ()-> {

            Auth.fillFormOrders();

        });

        step("Confirm the last selected location", ()-> {

            $(byTestId("deleteConfirmYes")).click();

        });

        step("Go to location button on the main page", ()-> {
//            Should add an Id for MAIN of location selection button
            $(byTestId("locationSelector")).click();


        });

        step("Go to a pencil button on the first address", ()-> {


            $(byTestId("addressEdit")).click();
        });

        step("Go to delete button / Go to Confirm deleting", ()-> {

            $(byTestId("deleteAddress")).shouldBe(visible).click();
            $(byTestId("deleteConfirmYes")).click();
        });
    }
}