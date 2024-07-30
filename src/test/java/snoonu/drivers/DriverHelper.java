package snoonu.drivers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.appium.java_client.MobileBy;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.openqa.selenium.logging.LogType.BROWSER;
import static snoonu.drivers.Environment.*;


public class DriverHelper {

    public static void configureSelenide() {

        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        if (isWeb) {
            Configuration.browser = CustomWebDriver.class.getName();
            Configuration.browser = CustomWebDriver.class.getName();
            Configuration.baseUrl = webUrl;
            Configuration.startMaximized = true;
            Configuration.browserSize = "1920x1080";
        } else if (isAndroid || isIos) {
            Configuration.startMaximized = true;
            Configuration.browserSize = "1920x1080";
        }
        Configuration.timeout = 50000;
    }

    public static By byTestId(String testId) {
        return by("data-analytic-label", testId);
    }

    public static By dataTestId(String testId) {
        return by("data-test-id", testId);
    }

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid", "");
    }

    public static String getConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }

//    public static String getNetworkLogs() {
//        todo https://ru.selenide.org/2019/12/18/advent-calendar-network-logs-with-proxy/
//    }

}