package snoonu.tests._other_patterns.page_objects.scenario;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import snoonu.tests.TestBase;
import snoonu.tests._other_patterns.page_objects.scenario.pages.LoginPageDev;
import snoonu.tests._other_patterns.page_objects.scenario.pages.MainPage;


@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("not-very-bad-practice")
@Tag("login")
class LoginTests extends TestBase {
    LoginPageDev loginPage = new LoginPageDev();
    MainPage mainPage = new MainPage();

    @Test
    @Description("Not very bad practice - page-objects are good, but not in this simple case")
    @DisplayName("Successful login in Web app. Page object. Scenario")
    void successfulLogin() {

    }
}
