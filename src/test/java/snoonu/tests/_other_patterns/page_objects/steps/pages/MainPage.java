package snoonu.tests._other_patterns.page_objects.steps.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static snoonu.helpers.DriverHelper.byTestId;


public class MainPage extends BasePage {
    private final SelenideElement authorizationForm = $(byTestId("Authorization form"));
    private final ElementsCollection privateContentList = $$(byTestId("Private content"));


    @Step("Authorization form should not exist")
    public MainPage verifyAuthorizationFormDoesntExist() {
        authorizationForm.shouldNot(exist);

        return this;
    }

    @Step("Verify successful authorization")
    public void verifyPrivateContentExists() {
        privateContentList
                .shouldHaveSize(2)
                .shouldHave(texts("Here is your private content #1",
                        "and private content #2"));
    }
}
