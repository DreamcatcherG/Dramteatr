package snoonu.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static snoonu.drivers.Environment.*;

public class CustomWebDriver implements WebDriverProvider {
    @Override
    @CheckReturnValue
    @Nonnull
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = getChromeOptions();
                chromeOptions.merge(capabilities);
                chromeOptions.setCapability("goog:loggingPrefs", logPrefs);
                
                WebDriverManager.chromedriver().setup();
                
                if (isRemoteDriver) {
                    return getRemoteWebDriver(chromeOptions);
                } else {
                    return getLocalChromeDriver(chromeOptions);
                }
            case "firefox":
                FirefoxOptions firefoxOptions = getFirefoxOptions();
                firefoxOptions.merge(capabilities);
                firefoxOptions.setCapability("goog:loggingPrefs", logPrefs);
                
                WebDriverManager.firefoxdriver().setup();
                
                if (isRemoteDriver) {
                    return getRemoteWebDriver(firefoxOptions);
                } else {
                    return getLocalFirefoxDriver(firefoxOptions);
                }
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--proxy-bypass-list=<-loopback>");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation", "load-extension"});

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
        prefs.put("safebrowsing.enabled", true);
        prefs.put("plugins.always_open_pdf_externally", true);
        chromeOptions.setExperimentalOption("prefs", prefs);

        return chromeOptions;
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        return firefoxOptions;
    }

    private WebDriver getLocalChromeDriver(ChromeOptions options) {
        return new ChromeDriver(options);
    }

    private WebDriver getLocalFirefoxDriver(FirefoxOptions options) {
        return new FirefoxDriver(options);
    }

    private WebDriver getRemoteWebDriver(Capabilities capabilities) {
        try {
            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(remoteDriverUrl), capabilities);
            remoteWebDriver.setFileDetector(new LocalFileDetector());
            return remoteWebDriver;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unable to create Remote WebDriver", e);
        }
    }
}
