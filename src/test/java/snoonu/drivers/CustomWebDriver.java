package snoonu.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static snoonu.helpers.EnvironmentHelper.*;


public class CustomWebDriver implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

        capabilities.setBrowserName(browser);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", isVideoOn);
        capabilities.setCapability("videoFrameRate", 24);

        switch (browser.toLowerCase()) {
            case "chrome":
                capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
                WebDriverManager.chromedriver().setup();
                if (isRemoteDriver) {
                    return getRemoteWebDriver(capabilities);
                } else {
                    return getLocalChromeDriver(capabilities);
                }
            case "firefox":
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, getFirefoxOptions());
                WebDriverManager.firefoxdriver().setup();
                if (isRemoteDriver) {
                    return getRemoteWebDriver(capabilities);
                } else {
                    return getLocalFirefoxDriver(capabilities);
                }
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();

        if (isWebMobile) {
            Map<String, Object> mobileDevice = new HashMap<>();
            mobileDevice.put("deviceName", webMobileDevice);
            chromeOptions.setExperimentalOption("mobileEmulation", mobileDevice);
        }
        chromeOptions.addArguments("--window-size=" + screenResolution);
//        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-infobars");
        if (isHeadless) chromeOptions.addArguments("headless");

        return chromeOptions;
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        firefoxOptions.addArguments("--window-size=" + screenResolution);
        if (isHeadless) firefoxOptions.addArguments("-headless");

        return firefoxOptions;
    }

    @SuppressWarnings("deprecation")
    private WebDriver getLocalChromeDriver(DesiredCapabilities capabilities) {
        return new ChromeDriver(capabilities);
    }

    @SuppressWarnings("deprecation")
    private WebDriver getLocalFirefoxDriver(DesiredCapabilities capabilities) {
        return new FirefoxDriver(capabilities);
    }

    private WebDriver getRemoteWebDriver(DesiredCapabilities capabilities) {
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(getRemoteWebdriverUrl(), capabilities);
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        return remoteWebDriver;
    }

    private URL getRemoteWebdriverUrl() {
        try {
            return new URL(remoteDriverUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
