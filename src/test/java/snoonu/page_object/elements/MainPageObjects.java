package snoonu.page_object.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static snoonu.drivers.DriverHelper.byTestId;
import static snoonu.drivers.DriverHelper.byDataTestId;

public class MainPageObjects {

    public static SelenideElement searchField() {
        return $(byName("search"));
    }

    public static SelenideElement nothingFoundText() {
        return $(byAttribute("data-test-id","search-nothing-found"));
    }

    public static SelenideElement emptySearchWriteToUsBTN() {
        return $(byDataTestId("nothing-found-write-to-us"));
    }

    public static SelenideElement writeToUsCommentField() {
        return $(byName("comments"));
    }

    public static SelenideElement sendFeedbackBtn() {
        return $(byTestId("sendFeedback"));
    }

    // Service boxes
    public static SelenideElement moreServiceBoxesBtn() {
        return $(byText("More"));
    }

    public static SelenideElement lessCategoryBtn() {
        return $(byText("Less"));
    }

    public static ElementsCollection categoryIcon() {
        return $$(byDataTestId("categoryIcon"));
    }

    public static SelenideElement orderWidget() {
        return $(By.className("TrackingWidgets_wrapper__vI1e0"));
    }

}

