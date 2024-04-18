package snoonu.tests.web.smokeTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.Keys;
import org.springframework.core.annotation.Order;
import snoonu.tests.TestBase;
import snoonu.utils_generate.Auth;
import snoonu.utils_generate.TextGenerator;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;
import static snoonu.tests.TestData.sNumber208;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("smoke")
@Order(3)

class EditProfile extends TestBase {

    @Test
    void editProfile() {

        step("Go to login page", () -> {

            open("http://snoonu.com");

        });

        step("Authorisation", () -> {

            Auth.defaultProfile(sNumber208);
        });

        step("Open account modal window)", () -> {

            $(byTestId("userPreview")).click();
            $(byTestId("myAccount")).shouldBe(appear).click();

        });

        step("Change name", () -> {

            $(byName("name")).shouldBe(appear);
            $(byName("name")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            $(byName("name")).sendKeys(TextGenerator.getRandomName(2, 8));
            $(byTestId("saveAccount")).click();
            $(byTestId("saveAccount")).shouldBe(disappear);

        });

    }
}
