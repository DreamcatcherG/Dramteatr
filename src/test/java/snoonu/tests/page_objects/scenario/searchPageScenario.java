package snoonu.tests.page_objects.scenario;

import com.codeborne.selenide.conditions.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import snoonu.utils_generate.AwtRobot;
import snoonu.utils_generate.TextGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static snoonu.helpers.DriverHelper.byTestId;
import static snoonu.tests._other_patterns.super_difficult_component.extentions.SelenideExtentions.$;
import static snoonu.tests.page_objects.pages.locationObjects.*;
import static snoonu.tests.page_objects.pages.mainPageObjects.locationBtn;
import static snoonu.tests.page_objects.pages.mainPageObjects.profileIcon;
import static snoonu.tests.page_objects.pages.profileObjects.savedAddresses;
import static snoonu.tests.page_objects.pages.searchPageObjects.merchantCard;
import static snoonu.utils_generate.RandomIDSelector.getRandomID;

public class searchPageScenario {


    public static void findMerchantCard() {
        merchantCard().shouldHave(text("Fake Devices Store (Only for Autotests)"));
        merchantCard().click();
    }


}


