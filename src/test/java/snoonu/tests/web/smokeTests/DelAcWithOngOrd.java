package snoonu.tests.web.smokeTests;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import snoonu.helpers.Css;
import snoonu.tests.TestBase;
import snoonu.utils_generate.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;
import static snoonu.tests.TestData.sNumber208;
import static snoonu.utils_generate.RandomIDSelector.getRandomID;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("smoke")

public class DelAcWithOngOrd extends TestBase {

    @Test
    void deleteAccountWithOngoingOrder() {

        step("Go to the web page", () -> {

            open("http://snoonu.com");

        });

        step("Fill auth Form", () -> {

            Auth.defaultProfile(sNumber208);//            $(byCssSelector("#__next > div > div > div.TrackingWidgets_wrapper__vI1e0")).click();
            sleep(1000);
        });

        step("Assert User has an ongoing order", () -> {

            if ($(byCssSelector("#__next > div > div > div.TrackingWidgets_wrapper__vI1e0")).exists()) {

                step("Open account modal window", () -> {

                    $(byTestId("userPreview")).click();
                    $(byTestId("myAccount")).shouldBe(appear).click();

                });

                step("Deleting the Account", () -> {

                    $(byTestId("deleteAccount")).click();
                    $(byCssSelector("h3.Typography_h3__odKq_.Modal_title__phnDp")).shouldHave(text("Are you sure you want to delete your account?"));
                    $(Css.byId("delete-account-modal-confirm")).click();

                });

                step("Assert the widget is visible and account isn't deleted", () -> {

                    $(byTestId("ok")).shouldBe(visible).click();
                    $(byTestId("userPreview")).shouldBe(visible);
//                    $(byTestId("orderTrackingWidget")).shouldBe(visible);
                    $(byCssSelector("#__next > div > div > div.TrackingWidgets_wrapper__vI1e0")).shouldBe(visible);

                });

            } else {

                if ($(byTestId("selectLocation")).exists()) {

                    $(byTestId("selectLocation")).shouldBe(visible).click();

                    step("Add a test Location", () -> {

                        $(byTestId("crossIcon")).shouldBe(visible).click();
                        $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
                        AwtRobot.LocKhasooma();
                        $(byTestId("addressPrediction")).wait(1000);
                        $(byTestId("addressPrediction")).shouldBe(appear).click();
                        sleep(1000);
                        $(byTestId("loginContinue")).shouldHave(text("Confirm location")).click();

                    });

                    step("Fill the location data", () -> {

                        String randomText = TextGenerator.getRandomFlatName(1, 10);
                        $(byName("apartment")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                        $(byName("apartment")).setValue(randomText);
                        String randomNotes = TextGenerator.getRandomFlatName(1, 10);
                        $(byName("notes")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                        $(byName("notes")).setValue(randomNotes);

                        String[] testIds = {"custom", "work", "home"};

                        $(byTestId(getRandomID(testIds))).click();

                        if ($(byName("customName")).exists()) {

                            $(byName("customName")).setValue(randomText);


                        } else {

                        }

                    });

                    step("Saved the location", () -> {

                        $(byTestId("saveAddress")).shouldBe(visible).click();
                        $(byTestId("saveAddress")).shouldBe(disappear);
                        $(byTestId("locationSelector")).shouldBe(visible);

                    });


                } else {

                    $(byTestId("deleteConfirmNo")).click();

                    step("Add a test Location", () -> {

                        $(byTestId("addNewAddress")).click();
                        $(byTestId("crossIcon")).shouldBe(visible).click();
                        $(byTestId("loginContinue")).shouldHave(text("Confirm location"));
                        AwtRobot.LocKhasooma();
                        $(byTestId("addressPrediction")).shouldBe(appear).click();
                        sleep(1000);
                        $(byTestId("loginContinue")).shouldHave(text("Confirm location")).click();

                    });

                    step("Fill the location data", () -> {

                        String randomText = TextGenerator.getRandomFlatName(1, 10);
                        $(byName("apartment")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                        $(byName("apartment")).setValue(randomText);
                        String randomNotes = TextGenerator.getRandomFlatName(1, 10);
                        $(byName("notes")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                        $(byName("notes")).setValue(randomNotes);

                        String[] testIds = {"custom", "work", "home"};

                        $(byTestId(getRandomID(testIds))).click();

                        if ($(byName("customName")).exists()) {

                            $(byName("customName")).setValue(randomText);


                        } else {
                        }

                    });

                    step("Saved the location", () -> {

                        $(byTestId("saveAddress")).shouldBe(visible).click();
                        $(byTestId("saveAddress")).shouldBe(disappear);
                        $(byTestId("locationSelector")).shouldBe(visible);

                    });
                }

                step("Make an order with Test Electronic Brand", () -> {

                    $(byName("search")).sendKeys("test electronic");
                    $(byName("search")).pressEnter();
                    $(byText("Test Electronic Brand (Shouldn't DELETE / CHANGE / CLOSE)")).click();

                });

                step("Add a product with addons to the cart", () -> {

                    $(byText("FeaturePhone")).shouldBe(appear);
                    ElementsCollection elements = $$(byTestId("productButtonAdd"));
                    elements.get(1).click();

                    $$(byName("Battery1")).get(1).click();
                    $$(byName("Platform0")).get(1).click();
                    $$(byTestId("checkboxAdditional")).get(0).click();
                    $$(byTestId("checkboxAdditional")).get(1).click();
                    $$(byTestId("checkboxAdditional")).get(3).click();

                });

                step("Add several pics of the product to the cart", () -> {

                    $(byTestId("plus")).shouldBe(appear).click();
                    $(byTestId("plus")).shouldBe(appear).click();
                    $(byTestId("plus")).shouldBe(appear).click();
                    $(byTestId("minus")).shouldBe(appear).click();
                    $(byText("Add to Cart")).click();

                });

                step("Go to checkout page and selected payment method", () -> {

                    $(byTestId("sw_checkout_button_pressed")).shouldBe(visible).click();
                    $(byTestId("selectPaymentMethod")).click();
                    $(byId("cash")).click();
                    $(byId("selectPaymentMethodId")).click();

                });

                step("Place the order", () -> {

                    $(byTestId("placeOrder")).click();
                    $(byTestId("trackOrder")).shouldBe(visible);

                });

                step("Go to main page and to Account menu", () -> {

                    $(byTestId("logo")).shouldBe(visible).click();
                    $(byTestId("userPreview")).shouldBe(visible).click();
                    $(byTestId("myAccount")).click();

                });

                step("Try delete the account", () -> {

                    $(byTestId("deleteAccount")).click();
                    $(byCssSelector("h3.Typography_h3__odKq_.Modal_title__phnDp")).shouldHave(text("Are you sure you want to delete your account?"));
                    $(Css.byId("delete-account-modal-confirm")).click();
                    $(byTestId("ok")).click();

                });

                step("Assert the user has an ongoing order", () -> {

                    $(byTestId("userPreview")).shouldBe(visible);
//                    $(byTestId("orderTrackingWidget")).wait(1000);
//                    $(byTestId("orderTrackingWidget")).shouldBe(visible);
                    $(byCssSelector("#__next > div > div > div.TrackingWidgets_wrapper__vI1e0")).click();
                });
            }

        });

    }

}










