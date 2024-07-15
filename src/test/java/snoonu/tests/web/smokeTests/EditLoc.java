//package snoonu.tests.web.smokeTests;
//
//import io.qameta.allure.Feature;
//import io.qameta.allure.Story;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//import snoonu.helpers.Environment;
//import snoonu.tests.TestBase;
//
//import static com.codeborne.selenide.Selenide.open;
//import static io.qameta.allure.Allure.step;
//import static snoonu.tests.TestData.Number272;
//import static snoonu.tests.page_objects.scenario.locationScenario.*;
//import static snoonu.tests.page_objects.scenario.logInScenario.defaultProfile;
//import static snoonu.tests.page_objects.scenario.mainPageScenario.assertSuccessAuth;
//
//@Feature("Selenide_Web")
//@Story("Smoke tests Web")
//@Tag("web")
//@Tag("smoke")
//class EditLoc extends TestBase {
//
//    @Test
//    @DisplayName("Edit a location")
//    void editLoc() {
//
//        step("Preconditions: Open Web Page login and remove account", () -> {
//            open(Environment.webPage);
//            defaultProfile(Number272);
//            assertSuccessAuth();
//        });
//
//        step(" Confirm or Save new address ", () -> {
//            confirmLastOrAddNewAddress();
//            assertLocApplied();
//        });
//
//        step("Edit saved location", () -> {
//            editSavedLocation();
//        });
//
//        step("Assert Address edited", () -> {
////            assertAddressEdited(); // проверить
//        });
//
//    }
//}