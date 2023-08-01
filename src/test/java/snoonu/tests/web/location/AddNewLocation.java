package snoonu.tests.web.location;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.tests.TestBase;
import snoonu.utils_generate.DataGenerator;
import snoonu.utils_generate.DataParams;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("web")
@Tag("login")


class AddNewLocation extends TestBase {


    @Test
    @DisplayName("Add a location")
    void successfulLoginTest() {

        step("Go to login page", ()-> {

            open(DataParams.urlDev);

        });

        step("Fill the authorization form", ()-> {

            $(byTestId("loginButton")).shouldBe(visible).click();
            $(byName("phoneNumber")).sendKeys("21343286");
            $(byTestId("loginContinue")).click();
            $("input[name='pin']").shouldBe(appear).sendKeys(DataGenerator.otp);
        });
//          Добавить зависимость If если нет кнопки подтверждения дефолтовой локации
        step("Confirm No for default location", ()-> {

            $(byTestId("deleteConfirmNo")).click();

        });

        step("Add a New Location", ()-> {

            $(byTestId("addNewAddress")).shouldBe(visible).click();
            $(byTestId("loginContinue")).shouldBe(visible);

                // Need add an Id for clear (x) button on the search location field of choosing location window
            $(byXpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]")).shouldBe(visible).click();
            $(byName("address")).sendKeys("Lusail");

               // Need add an Id for found result fields
            $(byXpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/p[1]")).shouldHave(text("Lusail")).click();
            $(byTestId("loginContinue")).shouldBe(visible).click();
            $(byName("apartment")).sendKeys("Office");
            $(byTestId("work")).click();
            $(byName("notes")).sendKeys("Here should be notes for Drivers");
            $(byTestId("saveAddress")).shouldBe(visible).click();

        });
    }
   @Test
   @AllureId("2755")
   @DisplayName("Selecting saved location(AutoTests)")
   @Epic("SNW-389 AutoTests")
   @Owner("mikhail")
   void AddLocal() {
       step("Click NO in the window of the proposed location with Order to this address? text", () -> {

       } );
               step("Click on the location selection widget");
       step("In the list that appears, there are saved user addresses");
       step("Choose a saved location from the list ");
   }

}