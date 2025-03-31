package snoonu.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.Desktop;
import java.io.File;
// import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class TestBase {
    private static final String PROJECT_DIR = System.getProperty("user.dir");
    private static final Path ALLURE_RESULTS = Paths.get(PROJECT_DIR, "build", "allure-results");
    
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = null;
        Configuration.pageLoadTimeout = 120000;
        Configuration.timeout = 30000;
        Configuration.browser = "chrome";
        Configuration.browserPosition = "0x0";
        Configuration.holdBrowserOpen = false;
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
            "--disable-background-mode",
            "--disable-gpu",
            "--no-sandbox",
            "--disable-dev-shm-usage"
        );
        options.addArguments("--disable-application-cache");
        options.addArguments("--disable-cache");
        options.addArguments("--disk-cache-size=1");
        
        Configuration.browserCapabilities = options;

        // Open browser with blank page and maximize it
        open("about:blank");
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }

    protected static void openUrlInMaximizedWindow(String url) {
        if (!WebDriverRunner.hasWebDriverStarted()) {
            open("about:blank");
            Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
        }
        open(url);
    }

    protected static void switchToBrowserWindow() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            Selenide.switchTo().window(0);
        }
    }

    @AfterEach
    void addAttachments() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriver driver = WebDriverRunner.getWebDriver();
            try {
                if (driver != null && driver.getWindowHandles().size() > 0) {
                    // Take screenshot first, while browser is still open
                    Selenide.screenshot("Last screenshot");
                    
                    // Then clear data
                    Selenide.clearBrowserCookies();
                    Selenide.clearBrowserLocalStorage();
                    Selenide.localStorage().clear();
                    
                    // Wait a bit for cleanup
                    sleep(3000);
                }
            } catch (Exception e) {
                System.out.println("Failed to add attachments: " + e.getMessage());
            } finally {
                try {
                    // Always try to close the browser
                    closeWebDriver();
                } catch (Exception e) {
                    System.out.println("Failed to close WebDriver: " + e.getMessage());
                }
            }
        }
    }

    @AfterAll
    static void openAllureReport() {
        try {
            // First ensure WebDriver is closed
            if (WebDriverRunner.hasWebDriverStarted()) {
                closeWebDriver();
            }
            
            // Wait a bit to ensure browser is fully closed
            sleep(1000);
            
            // Clean up previous Allure reports
            File allureResultsDir = ALLURE_RESULTS.toFile();
            File allureReportDir = new File(PROJECT_DIR, "build/reports/allure-report");
            
            if (allureResultsDir.exists()) {
                deleteDirectory(allureResultsDir);
            }
            if (allureReportDir.exists()) {
                deleteDirectory(allureReportDir);
            }
            
            // Ensure we're using the correct Gradle wrapper
            String gradlewCmd = System.getProperty("os.name").toLowerCase().contains("windows") 
                ? "gradlew.bat" 
                : "./gradlew";

            // Generate Allure report using Gradle
            ProcessBuilder generateReport = new ProcessBuilder(
                gradlewCmd,
                "allureReport"
            );
            generateReport.directory(new File(PROJECT_DIR));
            generateReport.redirectErrorStream(true);
            
            // Start the process and wait for it to complete
            Process process = generateReport.start();
            process.waitFor();
            
            // Wait a bit for the report to be generated
            Thread.sleep(2000);
            
            // Start Allure server with specific port and host
            ProcessBuilder serveReport = new ProcessBuilder(
                "C:\\Users\\Slowdowns\\Desktop\\allure-commandline\\bin\\allure.bat",
                "serve",
                "--port", "35577",
                "--host", "localhost",
                PROJECT_DIR + "\\build\\allure-results"
            );
            serveReport.directory(new File(PROJECT_DIR));
            serveReport.redirectErrorStream(true);
            
            // Start the server process
            Process serveProcess = serveReport.start();
            
            // Wait a bit for the server to start
            Thread.sleep(3000);
            
            // Open the report in the default browser using Desktop API
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(new URI("http://localhost:35577"));
                }
            }
            
            // Add shutdown hook to kill the server when JVM exits
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                serveProcess.destroy();
                if (serveProcess.isAlive()) {
                    serveProcess.destroyForcibly();
                }
            }));
            
        } catch (Exception e) {
            System.out.println("Failed to open Allure report: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void deleteDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        dir.delete();
    }
} 