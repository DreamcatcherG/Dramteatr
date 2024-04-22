package snoonu.tests.page_objects.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;
import static snoonu.helpers.DriverHelper.byTestId;
import static snoonu.tests._other_patterns.super_difficult_component.extentions.SelenideExtentions.$;

public class locationObjects {

    public static SelenideElement selectLocationBtn() {
        return $(byTestId("selectLocation"));
    }

    public static SelenideElement confirmLocBtn() {
        return $(byTestId("loginContinue"));
    }

    public static SelenideElement crossIconX() {
        return $(byTestId("crossIcon"));
    }

    public static SelenideElement addressPredictionField() {
//        return $(By.xpath("//div[@class='AddressPredictions_prediction__RQIm5']"));
        return $(By.xpath("//div[@class='AddressPredictions_prediction__RQIm5' " +
                "and @data-analytic-label='addressPrediction']"));
    }

    public static SelenideElement delConfirmYesBtn() {
        return $(byTestId("deleteConfirmYes"));
    }

    public static SelenideElement delConfirmNoBtn() {
        return $(byTestId("deleteConfirmNo"));
    }

    public static SelenideElement addNewAddressBtn() {
        return $(byTestId("addNewAddress"));
    }

    public static SelenideElement addressInputField() {
        return $(byName("address"));
    }

    public static SelenideElement apartmentInputField() {
        return $(byName("apartment"));
    }

    public static SelenideElement notesInputField() {
        return $(byName("notes"));
    }

    public static SelenideElement customNameInputField() {
        return $(byName("customName"));
    }

    public static SelenideElement locationPopup() {
        return $(byTestId("locationSelector"));
    }

    public static SelenideElement saveAddressBtn() {
        return $(byTestId("saveAddress"));
    }


}
