package snoonu.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import java.lang.invoke.StringConcatFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverConditions.url;
import static snoonu.tests.TestData.ACTION_CENTER_URL;

@Feature("Action Center")
public class OpenAc extends TestBase {
    @Test
    @Description("Open Action Center and verify page loads correctly")
    void openActionCenter() {
        openUrlInMaximizedWindow(ACTION_CENTER_URL);
        $("body").shouldBe(visible);
        Selenide.webdriver().shouldHave(url(ACTION_CENTER_URL));
    }
} 