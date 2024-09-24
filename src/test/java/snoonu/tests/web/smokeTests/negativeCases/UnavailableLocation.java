//package snoonu.tests.web.smokeTests.negativeCases;
//
//import com.codeborne.selenide.Condition;
//import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.Selenide;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import snoonu.drivers.CustomWebDriver;
//import snoonu.drivers.DriverHelper;
//import snoonu.drivers.Environment;
//import snoonu.tests.TestBase;
//
//import static com.codeborne.selenide.Selenide.open;
//import static io.qameta.allure.Allure.step;
//import static java.lang.Thread.sleep;
//import static snoonu.drivers.extentions.SelenideExtentions.$;
//import static snoonu.page_object.scenario.LocationScenario.*;
//
//@Tag("smoke")
//@Tag("negativeTesting")
//@Tag("pickLocation")
//
//public class UnavailableLocation extends TestBase {
//
//    @Test
//    void addLocation() {
//        Configuration.browser = CustomWebDriver.class.getName();
//
//        step("Open Web Page", () -> {
//            open(Environment.webPage);
//        });
//
//        step("Select A Location", () -> {
//            clickToSelectAddressButton();
//
//            sleep(5000);
//            clickToSelectAddressButton();
//
//
//        });
//
//        step("Input Random Test Address", () -> {
////            inputRandomTestAddressScenario();
//            sleep(5000);
//
//
//
//            $(By.className("Map_geoLocation__RG5q3")).shouldBe(Condition.appear).click();
//            sleep(2000);
//        });
//
//        step("Assert: Selected Location is displayed in the Header ", () -> {
//            sleep(100000);
////
////            assertLocAppliedInHeader();
//        });
//    }
//}
//
