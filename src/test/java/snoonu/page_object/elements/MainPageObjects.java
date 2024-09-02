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
        return $(byDataTestId("searchField"));
    }

    public static SelenideElement searchFieldButton() {
        return $(byDataTestId("searchFieldBtn"));
    }

    public static SelenideElement nothingFoundText() {
        return $(byDataTestId("searchNothingFoundText"));
    }

    public static SelenideElement emptySearchWriteToUsBTN() {
        return $(byDataTestId("searchWriteToUsBtn"));
    }

    public static SelenideElement writeToUsCommentField() {
        return $(byDataTestId("searchFeedbackField"));
    }

    public static SelenideElement sendFeedbackBtn() {
        return $(byDataTestId("searchFeedbackBtn"));
    }

    // Service boxes
    public static SelenideElement showMoreOnServiseBoxes() {
        return $(byDataTestId("showMoreBtn"));
    }

    public static ElementsCollection categoryIcon() {
        return $$(byDataTestId("categoryIcon"));
    }

    public static SelenideElement orderWidget() {
        return $(By.className("TrackingWidgets_wrapper__vI1e0"));
    }

}

