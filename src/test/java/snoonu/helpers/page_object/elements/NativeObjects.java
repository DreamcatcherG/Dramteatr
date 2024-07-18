package snoonu.helpers.page_object.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NativeObjects {

    public static SelenideElement cssUrl() {
        return $("meta[property='og:url']");
    }
}

