package snoonu.tests.web.location;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.tests.TestBase;
import snoonu.utils_generate.Auth;
import snoonu.utils_generate.LoadPage;
import snoonu.utils_generate.AwtRobot;

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
    void selLocWithoutAuth() {


        step("Open Web Page", () -> {

            open("http://snoonu.com");

        });

        step("Select Test Location", () -> {

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

    }

}
