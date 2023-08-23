package snoonu.tests.web.ordering;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import snoonu.tests.TestBase;
import snoonu.utils_generate.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("order")
@Tag("Web")
class MakeOrderCash extends TestBase {


    @Test
    @AllureId("4345")
    @DisplayName("Place an order with CASH (AutoTests)")
    @Epic("SNW-389 AutoTests")
    @Owner("mikhail")
    void successfulLoginTest() {


        step("Go to login page", () -> {

            open("http://snoonu.com");

        });


        step("Select Test Location", () -> {

            $(byTestId("selectLocation")).click();
            $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
            $(byTestId("crossIcon")).click();
            $(byName("address")).sendKeys("57F3+C2 Khasooma");
            $(byTestId("addressPrediction")).shouldHave(text("57F3+C2 Khasooma")).click();
            $(byName("address")).shouldHave(value("57F3+C2, 57F3+C2, Khasooma"));
            $(byTestId("crossIcon")).click();
            $(byTestId("loginContinue")).shouldHave(text("Confirm location")).click();

        });

        step("Find test merchant", () -> {

            $(byName("search")).sendKeys("test electronic");
            $(byName("search")).pressEnter();
            $(byText("Test Electronic Brand (Shouldn't DELETE / CHANGE / CLOSE)")).click();

        });

        step("Open product card / choose additional", () -> {

            $(byText("FeaturePhone")).shouldBe(appear);
            ElementsCollection elements = $$(byTestId("productButtonAdd"));
            elements.get(1).click();
            $(byId("1736477")).click();
            $(byId("1736479")).click();
            $(byId("1736481")).click();
            $(byId("1736483")).click();

        });

        step("Add to cart 3p", () -> {

            $(byTestId("plus")).shouldBe(appear).click();
            $(byTestId("plus")).shouldBe(appear).click();
            $(byTestId("plus")).shouldBe(appear).click();
            $(byTestId("minus")).shouldBe(appear).click();
            $(byText("Add to Cart")).click();   // Need add ID
        });

        step("Go to Checkout / Fill auth Form", () -> {

            $(byTestId("sw_checkout_button_pressed")).shouldBe(visible).click();
            $(byName("phoneNumber")).sendKeys("21343286");
            $(byTestId("loginContinue")).click();
            $(byName("pin")).click();
            awtRobot.entOtp();

        });

        step("Confirm saved location / Go to Checkout ", () -> {

            $(byTestId("deleteConfirmYes")).shouldBe(visible).click();
            $(byTestId("sw_checkout_button_pressed")).shouldBe(visible).click();

        });


        step("Select PayMethod", () -> {

            $(byTestId("selectPaymentMethod")).click();
            $(byId("cash")).click();
            $(byId("selectPaymentMethodId")).click();

        });

        step("Complete Checkout", () -> {

            $(byTestId("placeOrder")).click();

        });

            step("Order cancellation", ()-> {

                $(byTestId("cancelOrderButton")).click();
                $(byTestId("cancelOrderConfirm")).shouldBe(appear).click();
                ElementsCollection elements = $$(byTestId("checkboxCancellationReason"));
                elements.get(0).shouldBe(visible).click();
                elements.get(1).shouldBe(visible).click();
                elements.get(3).shouldBe(visible).click();
                $(byTestId("cancelOrderDone")).click();
                $(byTestId("feedbackConfirm")).shouldBe(visible).click();

            });

    }
}

