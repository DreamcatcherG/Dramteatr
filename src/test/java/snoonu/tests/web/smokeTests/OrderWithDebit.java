package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.tests.TestBase;
import snoonu.utils_generate.DataParamsDev;
import snoonu.utils_generate.LoadPage;
import snoonu.utils_generate.XPathUtil;
import snoonu.utils_generate.awtRobot;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

public class OrderWithDebit {
    @Feature("Selenide-appium web, iOS and Android tests")
    @Story("Login tests. Web")
    @Tag("smoke")
    class AddDelCreditCard extends TestBase {

        @Test
        void orderWithDebit() {

            step("Go to login page", () -> {

                open(DataParamsDev.urlDev);
//            open("http://snoonu.com");


            });

            step("Click on the Login button", () -> {

                $(byTestId("loginButton")).shouldBe(visible).click();

            });

            step("Enter (phone number, otp (current date)", () -> {

                $(byName("phoneNumber")).sendKeys("21343336");
//            $(byName("phoneNumber")).sendKeys("21343230");
                LoadPage.pageInit();
                $(byTestId("loginContinue")).click();

            });

            step("Enter OTP (Actual date)", () -> {

                $(byName("pin")).click();
                LoadPage.pageInit();
                awtRobot.entOtp();

            });

            step("Open account modal window)", () -> {

                $(byTestId("userPreview")).click();

            });

            step("Open saved card window and adding a credit card", () -> {

                $(byTestId("savedCards")).shouldBe(appear).click();
                LoadPage.pageInit();
                $(byTestId("addNewCard")).click();
//            $(byName("number")).setValue("4242 4242 4242 4242");
                $(byName("number")).setValue("4111 1111 1111 1111");
                $(byName("date")).setValue("0155");
                $(byName("code")).setValue("111");
                $(byTestId("saveCard")).click();
                $(byTestId("saveCard")).should(disappear);

            });

            step("Confirm adding", () -> {

                switchTo().frame($(byId("challengeFrame")));
                $("#acssubmit").click();
                $("h2").shouldHave(text("Successfully Added Credit/Debit Card"));
                switchTo().defaultContent();
                $(byXpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[1]/span[1]/img[1]")).click(); // Close btn on the 3ds page
                XPathUtil.СardDelBut(); // Delete btn on the adding cards window
                $(byTestId("yes")).shouldBe(visible).click();


            });

        }
    }


}
