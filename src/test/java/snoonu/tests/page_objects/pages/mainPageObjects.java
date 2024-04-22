package snoonu.tests.page_objects.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static snoonu.helpers.DriverHelper.byTestId;

public class mainPageObjects {

    public static SelenideElement profileIcon() {
        return $(byTestId("userPreview"));
    }

    public static SelenideElement locationBtn() {
        return $(By.xpath("//p[@class='Typography_p5__8b5pg Selector_location__g2_Bs']"));
    }
}
