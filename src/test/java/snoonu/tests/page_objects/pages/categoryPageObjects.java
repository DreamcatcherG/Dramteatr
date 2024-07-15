package snoonu.tests.page_objects.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static snoonu.helpers.DriverHelper.byTestId;

public class categoryPageObjects {

    public static SelenideElement merchantCard() {
        return $(byAttribute("data-analytic-label","merchantCard"));
    }

}

