package snoonu.tests._other_patterns.no_testid;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static snoonu.tests.TestData.DEFAULT_LOGIN;
import static snoonu.tests.TestData.DEFAULT_PASSWORD;


@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("login")
class LoginTests extends TestBase {
    @Test
    @DisplayName("Successful login in Web app. No testid")
    void successfulLogin() {
        step("Go to login page", ()-> {
            open("https://autotests.cloud");
            $("h2").shouldHave(text("Not authorized"));
        });

        step("Fill the authorization form", ()-> {
            $("form").shouldBe(visible);
            $("input", 0).setValue(DEFAULT_LOGIN);
            $("input", 1).setValue(DEFAULT_PASSWORD);
            $("input[type=checkbox]").click();
            $("button").click();
        });

        step("Verify successful authorization", ()-> {
            $("form").shouldNot(exist);
            $("h2").shouldHave(text("Hello, " + DEFAULT_LOGIN + "!"));
            $$("div div div")
                    .shouldHaveSize(2)
                    .shouldHave(texts("Here is your private content #1",
                            "and private content #2"));
        });
    }

}
