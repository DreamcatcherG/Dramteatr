package snoonu.tests.web.smokeTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import snoonu.tests.TestBase;
import snoonu.utils_generate.LoadPage;
import snoonu.utils_generate.RandomUtils;
import snoonu.utils_generate.awtRobot;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("smoke")

class EditProfile extends TestBase {

    @Test
    void editProfile() {


        step("Go to login page", () -> {

            open("http://snoonu.com");

        });

        step("Click on the Login button", () -> {

            $(byTestId("loginButton")).shouldBe(visible).click();

        });

        step("Enter (phone number, otp (current date)", () -> {

            $(byName("phoneNumber")).sendKeys("21343230");
            $(byTestId("loginContinue")).click();

        });

        step("Enter OTP (Actual date)", () -> {

            $(byName("pin")).click();
            awtRobot.entOtp();

        });

        step("Open account modal window)", () -> {

            $(byTestId("userPreview")).click();
            $(byTestId("myAccount")).shouldBe(appear).click();

        });

        step("Change name", () -> {

            $(byName("name")).shouldBe(appear);
            $(byName("name")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
            $(byName("name")).sendKeys(Keys.BACK_SPACE);
            $(byName("name")).setValue(RandomUtils.getRandomMessage(2, 8));
            $(byTestId("saveAccount")).click();

        });

    }
}
