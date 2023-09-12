package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import snoonu.tests.TestBase;
import snoonu.utils_generate.DataParamsDev;
import snoonu.utils_generate.LoadPage;
import snoonu.utils_generate.awtRobot;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("smoke")

class AddCreditCard extends TestBase {

    @Test
    void addCreditCard() {

        step("Go to login page", () -> {

            open(DataParamsDev.urlDev);
//            open("http://snoonu.com");


        });

        step("Click on the Login button", () -> {

            $(byTestId("loginButton")).shouldBe(visible).click();

        });

        step("Enter (phone number, otp (current date)", () -> {

            $(byName("phoneNumber")).sendKeys("21343333");
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
            $(byName("number")).setValue("4111 1111 1111 1111");
            $(byName("date")).setValue("0155");
            $(byName("code")).setValue("111");
            $(byTestId("saveCard")).click();
            LoadPage.pageInit();

        });

            step("Confirm adding", () -> {


                $("#acssubmit").click();
            sleep(9000);
//            $(byText("Successfully Added Credit/Debit Card ")).shouldBe(appear);
//            $(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[1]/span[1]/img[1]")).click();
//            sleep(9000);

        });

    }
}

