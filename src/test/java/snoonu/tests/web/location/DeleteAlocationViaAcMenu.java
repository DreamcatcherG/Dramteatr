package snoonu.tests.web.location;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import snoonu.tests.TestBase;
import snoonu.utils_generate.DataGenerator;
import snoonu.utils_generate.DataParams;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;


@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("web")
@Tag("login")
class DeleteAlocationViaAcMenu extends TestBase {

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

        step("Confirm the last selected location", ()-> {

            $(byTestId("deleteConfirmYes")).click();
            $(byTestId("userPreview")).click();
        });

        step("Go to Account button on the main page", ()-> {

            $(byTestId("userPreview")).shouldBe(visible).click();
        });

        step("Go to my addresses", ()-> {

            $(byTestId("myAddresses")).shouldBe(appear).click();
        });

        step("Go to a pencil button on the first address", ()-> {

//                    Should add an Id for editing (pencil)  of main location selection button
            $(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/span[1]/span[1]/img[1]")).shouldBe(visible).click();
        });

        step("Go to delete button / Go to Confirm deleting", ()-> {

            $(byTestId("deleteAddress")).shouldBe(visible).click();
            $(byTestId("deleteConfirmYes")).click();
        });
    }
}