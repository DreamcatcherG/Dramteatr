package snoonu.page_object.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.drivers.DriverHelper.byTestId;
import static snoonu.drivers.DriverHelper.dataTestId;

public class MainPageObjects {

    public static SelenideElement searchField() {
        return $(byName("search"));
    }

    public static SelenideElement nothingFoundText() {
        return $(byAttribute("data-test-id","search-nothing-found"));
    }

    public static SelenideElement emptySearchWriteToUsBTN() {
        return $(dataTestId("nothing-found-write-to-us"));
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

    public static SelenideElement food() {
        return $(byAttribute("href", "/restaurants"));
    }

    public static SelenideElement snoomart() {
        return $(byAttribute("href", "/groceries/snoomart"));
    }

    public static SelenideElement groceries() {
        return $(byAttribute("href", "/groceries"));
    }

    public static SelenideElement gifting() {
        return $(byAttribute("href", "/flowers-and-gifts"));
    }

    public static SelenideElement pharmacy() {
        return $(byAttribute("href", "/pharmacy"));
    }

    public static SelenideElement healthAndBeauty() {
        return $(byAttribute("href", "/snoonu-market/health-and-beauty"));
    }

    public static SelenideElement electronics() {
        return $(byAttribute("href", "/snoonu-market/electronics"));
    }

    public static SelenideElement babyAndKids() {
        return $(byAttribute("href", "/snoonu-market/baby-and-kids"));
    }

    public static SelenideElement pets() {
        return $(byAttribute("href", "/snoonu-market/pets"));
    }

    public static SelenideElement houseAndGarden() {
        return $(byAttribute("href", "/snoonu-market/household-and-garden"));
    }

    public static SelenideElement booksAndStationery() {
        return $(byAttribute("href", "/snoonu-market/books-and-stationery"));
    }

    public static SelenideElement sportsAndOutdoors() {
        return $(byAttribute("href", "/snoonu-market/sport-and-outdoors"));
    }

    public static SelenideElement clothesAndAccessories() {
        return $(byAttribute("href", "/snoonu-market/clothes-and-accessories"));
    }

    public static SelenideElement snoosendPopupText() {
        return $(By.xpath("//h2[@class='Typography_h2__9oI5M SnoosendModal_title__aDsn2']"));
    }

    public static SelenideElement orderWidget() {
        return $(By.className("TrackingWidgets_wrapper__vI1e0"));
    }

}

