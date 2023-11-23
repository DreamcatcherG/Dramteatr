package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.helpers.Css;
import snoonu.tests.TestBase;
import snoonu.utils_generate.Auth;
import snoonu.utils_generate.TextGenerator;
import snoonu.utils_generate.Xpath;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("smoke")

public class DelSignupAcc extends TestBase {

    @Test
    void deleteSignupAcc() {

        step("Go to login page", () -> {

            open("http://snoonu.com");

        });

        step("Click on the Login button", () -> {

            $(byTestId("loginButton")).shouldBe(visible).click();

        });

        step("Enter (phone number, otp (current date)", () -> {

            Auth.fillform276();

        });

        step("Open account modal window", () -> {

            $(byTestId("userPreview")).click();
            $(byTestId("myAccount")).shouldBe(appear).click();

        });

        step("Deleting the Account", () -> {

            $(byTestId("deleteAccount")).click();
            $(byCssSelector("h3.Typography_h3__odKq_.Modal_title__phnDp")).shouldHave(text("Are you sure you want to delete your account?"));
            $(Css.byId("delete-account-modal-confirm")).click();

        });

        step("Create an Account / Authorisation", () -> {

            Auth.fillform276();

        });

        step("Enter Credentials", () -> {

            String randomName = TextGenerator.getRandomName(3, 10);
            $(byName("name")).setValue(randomName);
            $(byName("email")).setValue("web@Autotests.cc");
            $(byTestId("loginRegister")).click();
            $(byTestId("userPreview")).shouldBe(appear);

        });

    }

}
