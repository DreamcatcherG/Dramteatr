package snoonu.tests.web.smokeTests;

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
import static snoonu.page_object.scenario.OrderHistoryPageScenario.verifyOrderIsInHistory;
import static snoonu.page_object.scenario.SuccessPageScenario.*;
import static snoonu.tests.TestData.*;

@Tag("Order")
@Tag("smoke")
class FoodOrderByCash extends TestBase {

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

        /* Urls from Stage and Prod are different should think how fix it
        step("Assert: Merchant Page opened", () -> {
            assertPageOpened(TestCafeBrand);
        });
         */

        step("Find a simple product with 'Product Name' if there isn't show message 'Product Not found'", () -> {
            findAProduct("Fresh S");
        });

        step("Click Add button", () -> {
            clickToAddBtn();
        });

        step("Click to the Cart Button on the Header", () -> {
            clickToCart();
        });

        step("Assert: The cart has a product", () -> {
            isProductInCart();
        });

        step("Assert: Selected product in the cart", () -> {
            isSelectedProductInCart("Fresh S");
        });

        step("Click to Checkout button in the cart", () -> {
            goToCheckoutBtn();
        });

        step("Sign in with 208 number", () -> {
            logginInNumberOtp(Number272);
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

        step("Open Payment methods modal", () -> {
            openPayMethodModal();
        });

        step("Select Payment Method by Cash", () -> {
            selectPaymentMethodScenario();
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

        step("Assert: Order History page opened and has an order", () -> {
            verifyOrderIsInHistory();
        });

        step("Post conditions: Remove the saved location", () -> {
            removeNewSavedAddress();
        });
    }
}


