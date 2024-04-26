//package snoonu.tests.web.smokeTests;
//
//import com.codeborne.selenide.ElementsCollection;
//import io.qameta.allure.*;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.Keys;
//import snoonu.tests.TestBase;
//import snoonu.tests.page_objects.scenario.logInScenario;
//import snoonu.utils_generate.AwtRobot;
//import snoonu.utils_generate.TextGenerator;
//
//import static com.codeborne.selenide.Condition.*;
//import static com.codeborne.selenide.Selectors.*;
//import static com.codeborne.selenide.Selenide.*;
//import static io.qameta.allure.Allure.step;
//import static snoonu.helpers.DriverHelper.byTestId;
//import static snoonu.tests.TestData.Number208;
//import static snoonu.utils_generate.RandomIDSelector.getRandomID;
//
//@Feature("Selenide_Web")
//@Story("Smoke tests Web")
//@Tag("smoke")
//class OrderWithCash extends TestBase {
//
//
//    @Test
//       void orderCash() {
//
//        step("Go to the web page", () -> {
//
//            open("http://snoonu.com");
//
//        });
//
//        step("Select Test Location", () -> {
//
//            $(byTestId("selectLocation")).click();
//            $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
//            $(byTestId("crossIcon")).shouldBe(visible).click();
//            AwtRobot.LocKhasooma();
//            $(byTestId("addressPrediction")).shouldBe(visible);
//            $(byTestId("addressPrediction")).click();
//            sleep(1000);
//            $(byTestId("loginContinue")).shouldBe(visible).click();
//            $(byTestId("loginContinue")).shouldBe(disappear);
//
//        });
//
//        step("Find test merchant", () -> {
//
//            $(byName("search")).sendKeys("test electronic");
//            $(byName("search")).pressEnter();
//            $(byText("Test Electronic Brand (Shouldn't DELETE / CHANGE / CLOSE)")).click();
//
//        });
//
//        step("Open product card / choose addons", () -> {
//
//            $(byText("FeaturePhone")).shouldBe(appear);
//            ElementsCollection elements = $$(byTestId("productButtonAdd"));
//            elements.get(1).click();
//
//            $$(byName("Battery1")).get(1).click();
//            $$(byName("Platform0")).get(1).click();
//            $$(byTestId("checkboxAdditional")).get(0).click();
//            $$(byTestId("checkboxAdditional")).get(1).click();
//            $$(byTestId("checkboxAdditional")).get(3).click();
//
//
//        });
//
//        step("Add to cart 3p", () -> {
//
//            $(byTestId("plus")).shouldBe(appear).click();
//            $(byTestId("plus")).shouldBe(appear).click();
//            $(byTestId("plus")).shouldBe(appear).click();
//            $(byTestId("minus")).shouldBe(appear).click();
//            $(byText("Add to Cart")).click();   // Need add ID
//
//        });
//
//        step("Go to Checkout / Fill auth Form", () -> {
//
//            $(byTestId("sw_checkout_button_pressed")).shouldBe(visible).click();
//
//        });
//
//        step("Go to Checkout / Fill auth Form", () -> {
//
//            logInScenario.defaultProfile(Number208);
//        });
//
//        step("Confirm saved location / Go to Checkout ", () -> {
//
//            if ($(byTestId("deleteConfirmYes")).exists()) {
//
//                $(byTestId("deleteConfirmNo")).click();
//                $(byTestId("cardAddress")).hover();
//                $(byTestId("addressEdit")).shouldBe(appear).click();
//                $(byName("address")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
//                $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
//                AwtRobot.LocKhasooma();
//                $(byTestId("addressPrediction")).shouldBe(appear).click();
//                sleep(1000);
//                $(byTestId("loginContinue")).shouldHave(text("Confirm location")).click();
//
//                String randomText = TextGenerator.getRandomText(1, 10);
//                $(byName("apartment")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
//                $(byName("apartment")).setValue(randomText);
//                String randomNotes = TextGenerator.getRandomText(1, 10);
//                $(byName("notes")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
//                $(byName("notes")).setValue(randomNotes);
//
//                String[] testIds = {"custom", "work", "home"};
//
//                $(byTestId(getRandomID(testIds))).click();
//
//                if ($(byName("customName")).exists()) {
//
//                    $(byName("customName")).setValue(randomText);
//
//                } else {
//
//                }
//
//                $(byTestId("saveAddress")).shouldBe(visible).click();
//                $(byTestId("saveAddress")).shouldBe(disappear);
//                $(byTestId("locationSelector")).shouldBe(visible);
//                $(byTestId("sw_checkout_button_pressed")).shouldBe(visible).click();
//
//            } else {
//
//            }
//
//            $(byTestId("sw_checkout_button_pressed")).shouldBe(visible).click();
//
//        });
//
//        step("Select PayMethod", () -> {
//
//            $(byTestId("selectPaymentMethod")).click();
//            $(byId("cash")).click();
//            $(byId("selectPaymentMethodId")).click();
//
//        });
//
//        step("Complete Checkout", () -> {
//
//            $(byTestId("placeOrder")).click();
//
//        });
//
//        step("Order cancellation", () -> {
//
//            $(byTestId("cancelOrderButton")).click();
//            $(byTestId("cancelOrderConfirm")).shouldBe(appear).click();
//            ElementsCollection elements = $$(byTestId("checkboxCancellationReason"));
//            elements.get(0).shouldBe(visible).click();
//            elements.get(1).shouldBe(visible).click();
//            elements.get(3).shouldBe(visible).click();
//            $(byTestId("cancelOrderDone")).click();
//            $(byTestId("feedbackConfirm")).shouldBe(visible).click();
//            $(byTestId("userPreview")).shouldBe(visible);
//
//        });
//
//    }
//
//}
//
//
//
