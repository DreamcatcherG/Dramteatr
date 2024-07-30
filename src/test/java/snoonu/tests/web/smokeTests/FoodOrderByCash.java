package snoonu.tests.web.smokeTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.drivers.Environment;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static snoonu.page_object.scenario.CartScenario.*;
import static snoonu.page_object.scenario.CategoryPageScenario.findTestMerchant;
import static snoonu.page_object.scenario.CategoryPageScenario.openMerchantPage;
import static snoonu.page_object.scenario.CheckoutPageScenario.*;
import static snoonu.page_object.scenario.HeaderScenario.clickToCart;
import static snoonu.page_object.scenario.LocationScenario.*;
import static snoonu.page_object.scenario.LogInScenario.logginInNumberOtp;
import static snoonu.page_object.scenario.MainPageScenario.goToRestaurants;
import static snoonu.page_object.scenario.MerchantPageScenario.clickToAddBtn;
import static snoonu.page_object.scenario.MerchantPageScenario.findAProduct;
import static snoonu.page_object.scenario.NativeScenario.assertPageOpened;
import static snoonu.page_object.scenario.NativeScenario.switchToNewTab;
import static snoonu.page_object.scenario.OrderHistoryPageScenario.verifyOrdersTitle;
import static snoonu.page_object.scenario.SuccessPageScenario.*;
import static snoonu.tests.TestData.Number208;
import static snoonu.tests.TestData.Restaurants;

@Feature("Selenide_Web")
@Story("Buy simple food product by cash")
@Tag("smokeStage")
@Tag("Order")
class FoodOrderByCash extends TestBase {

    @Test
    void buySimpleFoodProductByCash() throws InterruptedException {

        step("Open Web Page", () -> {
            open(Environment.webPage);
        });

        step("Select A Location", () -> {
            clickToSelectLocation();
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
            findTestMerchant("Test Cafe Brand");
        });

        step("Open Selected Test Merchant page", () -> {
            openMerchantPage();
        });

        step("Switch to opened Tab", () -> {
            switchToNewTab();
        });

//        step("Assert: Merchant Page opened", () -> {
//            assertPageOpened(TestCafeBrand);
//        });

        step("Find a simple product with 'Product Name' if there isn't show message 'Product Not found'", () -> {
            findAProduct("Simple Product");
        });

        step("Click Add button", () -> {
            clickToAddBtn();
        });

        step("Click to the Cart Button on the Header", () -> {
            clickToCart();
        });

        step("Assert: Cart is loaded", () -> {
            cartIsLoaded();
        });

        step("Assert: Selected product in the cart", () -> {
            verifyProductInCart("Simple Product");
        });

        step("Click to Checkout button in the cart", () -> {
            goToCheckoutBtn();
        });

        step("Sign in with 208 number", () -> {
            logginInNumberOtp(Number208);
        });

        step("Fill address fields", () -> {
            randomFillAddressFields();
        });

        step("Save the location", () -> {
            clickSaveAddressBtn();
        });

        step("Assert: Checkout Page opened", () -> {
            paymentMethodIsDisplayed();
        });

        step("Select Payment Method by Cash", () -> {
            selectPaymentMethodScenario("Cash");
        });

        step("Click To Place Order Btn on the Checkout Page", () -> {
            clickToPlaceOrderBtn();
        });

        step("Assert: Success Page has Title 'Success!' ", () -> {
            orderPlacesSuccessful();
        });

        step("Assert: Track Your Order button is visible", () -> {
            isVisibleTrackYourOrderBtn();
        });

        step("Click to Track Your Order button", () -> {
            clickToTrackYourOrderBtn();
        });

        step("Assert: Order History page opened and has title 'Orders'", () -> {
            verifyOrdersTitle();
        });

        step("Post conditions: Go to Main Page and Remove the saved location", () -> {
            goToSnoonuLogoOnOrdersPage();
            removeNewSavedAddress();
        });

    }
}


