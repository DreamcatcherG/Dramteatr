package snoonu.tests.web.smokeTests.negativeCases;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static java.lang.Thread.sleep;
import static snoonu.page_object.scenario.CartScenario.*;
import static snoonu.page_object.scenario.CategoryPageScenario.findTestMerchant;
import static snoonu.page_object.scenario.CategoryPageScenario.openMerchantPage;
import static snoonu.page_object.scenario.CheckoutPageScenario.*;
import static snoonu.page_object.scenario.HeaderScenario.clickToCart;
import static snoonu.page_object.scenario.LocationScenario.*;
import static snoonu.page_object.scenario.LogInScenario.enterNumberOtp;
import static snoonu.page_object.scenario.MainPageScenario.goToRestaurants;
import static snoonu.page_object.scenario.MerchantPageScenario.*;
import static snoonu.page_object.scenario.NativeScenario.assertPageOpened;
import static snoonu.page_object.scenario.NativeScenario.switchToNewTab;
import static snoonu.page_object.scenario.OrderHistoryPageScenario.verifyOrderIsInHistory;
import static snoonu.page_object.scenario.SuccessPageScenario.*;
import static snoonu.tests.TestData.Number272;
import static snoonu.tests.TestData.Restaurants;

@Tag("order")
@Tag("smoke")
class AddingUnavailableProduct extends TestBase {

    @Test
    void buySimpleFoodProductByCash() throws InterruptedException {

        step("Open Web Page", () -> {
            open(Environment.webPage);
        });

        step("Select A Location", () -> {
            clickToSelectAddressButton();
        });

        step("Input Random Test Address", () -> {
            inputRandomTestAddressScenario();
        });

        step("Assert: Selected Location is displayed in the Header ", () -> {
            assertLocAppliedInHeader();
        });

        step("Go to Restaurant category from Service Boxes", () -> {
            goToRestaurants();
        });

        step("Assert: URL contains '/restaurants'", () -> {
            assertPageOpened(Restaurants);
        });

        step("Find Test Merchant if not show message 'MerchantName not found'", () -> {
            findTestMerchant("Fake Dinner Cafe");
        });

        step("Open Selected Test Merchant page", () -> {
            openMerchantPage();
        });

        step("Switch to opened Tab", () -> {
            switchToNewTab();
        });

        step("Go to location popup in the header", () -> {
            goToAddressPopup();
        });

        step("Confirm No saved location", () -> {
            noConfirmLocationPopup();
        });

        step("Add address where the merchant unavailable (Center of Doha)", () -> {
            inputAddressOfCenterOfDoha();

        });

        step("Find a simple product with 'Product Name' if there isn't show message 'Product Not found'", () -> {
            findAProduct("Fresh S");
        });

        step("Click Add button", () -> {
            clickToAddBtn();
        });

        step("Assert Merchant out of coverage", () -> {
            assertChangeMyAddressBtnAppears();
        });

    }
}


