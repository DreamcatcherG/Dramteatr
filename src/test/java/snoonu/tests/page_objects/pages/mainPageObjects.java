package snoonu.tests.page_objects.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.helpers.DriverHelper.byTestId;

public class mainPageObjects {

    public static SelenideElement profileIcon() {
        return $(byTestId("userPreview"));
    }

    public static SelenideElement locationBtn() {
        return $(By.xpath("//p[@class='Typography_p5__8b5pg Selector_location__g2_Bs']"));
    }

    public static SelenideElement cssUrl() {
        return $("meta[property='og:url']");
    }

    // Service boxes
    public static SelenideElement moreCategoryBtn() {
        return $(By.cssSelector(".ShowMore_iconWrapper__f0950"));
    }

    public static SelenideElement lessCategoryBtn() {
        return $(By.cssSelector("p.Typography_p10__teZqm.ShowMore_label__udTb6"));
    }

    public static SelenideElement beautyPerfumesCategory() {
        return $(byAttribute("data-analytic-event-content", "beauty-and-perfumes"));
    }

    public static SelenideElement electronicsCategory() {
        return $(byAttribute("data-analytic-event-content", "electronics"));
    }

    public static SelenideElement flowersAnsGiftsCategory() {
        return $(byAttribute("data-analytic-event-content", "flowers-and-gifts"));
    }

    public static SelenideElement healthAndWellnessCategory() {
        return $(byAttribute("data-analytic-event-content", "pharmacy"));
    }

    public static SelenideElement kidsAndStationery() {
        return $(byAttribute("data-analytic-event-content", "kids-and-stationery"));
    }

    public static SelenideElement pets() {
        return $(byAttribute("data-analytic-event-content", "pets"));
    }

    public static SelenideElement shops() {
        return $(byAttribute("data-analytic-event-content", "online-shopping"));
    }

    public static SelenideElement snoomart() {
        return $(byAttribute("data-analytic-event-content", "snoomart"));
    }

    public static SelenideElement groceries() {
        return $(byAttribute("data-analytic-event-content", "groceries"));
    }

    public static SelenideElement food() {
        return $(byAttribute("data-analytic-event-content", "restaurants"));
    }

    public static SelenideElement snoosend() {
        return $(byXpath("//div[@class='Category_category__PdwL9']"));
    }

    public static SelenideElement snoosendPopupText() {
        return $(By.xpath("//h2[@class='Typography_h2__9oI5M SnoosendModal_title__aDsn2']"));
    }

    public static SelenideElement orderWidget() {
        return $(By.className("TrackingWidgets_wrapper__vI1e0"));
    }

}

