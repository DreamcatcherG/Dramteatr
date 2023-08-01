package snoonu.tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import snoonu.tests.TestBase;
import snoonu.utils_generate.DataGenerator;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("web")
@Tag("login")

class LoginTests extends TestBase {

    @Test
    @DisplayName("Successful login in Web app. Testid-strategy")
    void successfulLoginTest() {

        step("Go to login page", ()-> {

            open("http://snoonu.com");

        });

        step("Fill the authorization form", ()-> {

            $(byTestId("loginButton")).shouldBe(visible).click();
            $(byName("phoneNumber")).sendKeys("21343286");
            $(byTestId("loginContinue")).click();
            $("input[name='pin']").shouldBe(appear).sendKeys(DataGenerator.otp);

        });

        step("Confirm Khasooma location / Choosing the Test Brand", ()-> {

            $(byTestId("deleteConfirmYes")).click();
            $(byName("search")).shouldBe(visible).val("test");
            $(byTestId("searchMerchant")).click();

        });

        step("Add to the cart", ()-> {

            $(byTestId("productButtonAdd")).shouldBe(visible).click();
//            $x("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/button[2]/span[1]/span[1]/img[1]").click();
//            $x("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/button[2]/span[1]/span[1]/img[1]").click();
//            $x("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/button[2]/span[1]/span[1]/img[1]").click();
            $(byTestId("cartButton")).click();

        });

        step("Go to Checkout / and Choose payment method", ()-> {

            $(byTestId("sw_checkout_button_pressed")).shouldBe(visible).click();
            $(byTestId("selectPaymentMethod")).click();
            $(byId("cash")).click();
            $(byId("submit")).click();
//            $x("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/button[2]").shouldBe(visible).click();

        });

//        step("Complete Checkout", ()-> {
//
//            $(byTestId("placeOrder")).shouldBe(visible).click();
//
//        });
//
//        step("Order cancellation", ()-> {
//
//            $(byTestId("cancelOrderButton")).click();
//            $(byTestId("cancelOrderConfirm")).shouldBe(visible).click();
//            $(byTestId("checkboxCancellationReason")).click();
//            $(byTestId("cancelOrderDone")).click();
//            $(byTestId("feedbackConfirm")).shouldBe(visible).click();
//
//        });

    }
}

