package snoonu.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.appium.java_client.MobileBy;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import snoonu.drivers.CustomMobileDriver;
import snoonu.drivers.CustomWebDriver;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.openqa.selenium.logging.LogType.BROWSER;
import static snoonu.helpers.Environment.*;


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
            Configuration.browser = CustomMobileDriver.class.getName();
            Configuration.startMaximized = true;
            Configuration.browserSize = "1920x1080";
        }
        Configuration.timeout = 30000;
    }

    public static By byTestId(String testId) {
        if (isWeb) {
            return by("data-analytic-label", testId);
        } else if (isAndroid) {
            return MobileBy.xpath("//*[@content-desc='" + testId + "']");
        } else if (isIos) {
            return MobileBy.id(testId);
        } else { // todo isDesktop
            return by("some-desktop-attribute-name", testId);
        }
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