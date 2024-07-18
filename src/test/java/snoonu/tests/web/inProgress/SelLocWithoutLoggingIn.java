//package snoonu.tests.web.location;
//
//import io.qameta.allure.*;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//import snoonu.tests.TestBase;
//import snoonu.utils_generate.AwtRobot;
//
//import static com.codeborne.selenide.Condition.*;
//import static com.codeborne.selenide.Selenide.*;
//import static io.qameta.allure.Allure.step;
//import static snoonu.drivers.DriverHelper.byTestId;
//
//@Feature("Selenide_Web")
//@Story("Smoke tests Web")
//@Tag("web")
//@Tag("addLocal")
//
//public class SelLocWithoutLoggingIn extends TestBase {
//
//
//    @Test
//    void selLocWithoutAuth() {
//
//
//        step("Open Web Page", () -> {
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
//            AwtRobot.entLoc();
//            $(byTestId("addressPrediction")).shouldBe(visible);
//            $(byTestId("addressPrediction")).click();
//            sleep(1000);
//            $(byTestId("loginContinue")).shouldBe(visible).click();
//            $(byTestId("loginContinue")).shouldBe(disappear);
//
//        });
//
//    }
//
//}
