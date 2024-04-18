package snoonu.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static snoonu.helpers.AttachmentsHelper.*;
import static snoonu.helpers.BrowserstackHelper.getBSPublicLink;
import static snoonu.helpers.DriverHelper.*;
import static snoonu.helpers.EnvironmentHelper.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)

public class TestBase {

    private static final String stageUrl = "https://qa.snoonu.com";
    private static final String prodUrl = "https://snoonu.com";
    //Set env
    public static final String environment = System.getProperty("environment", "stage");
    public static final String webPage = environment.equals("stage") ? stageUrl : prodUrl;


    @BeforeAll
    public static void beforeAll() {
        configureSelenide();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = getSessionId();
//
        attachScreenshot("Last screenshot");
        attachPageSource();
        Selenide.closeWindow();
        closeWebDriver();
//        attachNetwork(); // todo
        if (isWeb) attachAsText("Browser console logs", getConsoleLogs());
        if (isIos || isAndroid) attachAsText("Browserstack build link", getBSPublicLink(sessionId));
        closeWebDriver();
        if (isVideoOn) attachVideo(sessionId); // in browserstack video url generates after driver close
        closeWebDriver();

    }

}

