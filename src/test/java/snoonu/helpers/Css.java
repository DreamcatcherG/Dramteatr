package snoonu.helpers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;

public class Css {
    public static By byId(String value) {
        return byAttribute("data-test-id", value);
    }
}