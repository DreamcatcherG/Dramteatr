package snoonu.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static snoonu.drivers.AttachmentsHelper.*;
import static snoonu.drivers.BrowserstackHelper.getBSPublicLink;
import static snoonu.drivers.DriverHelper.*;
import static snoonu.drivers.Environment.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)

public class TestBase {
    @BeforeAll
    public static void beforeAll() {
        configureSelenide();
    }
    @AfterEach
    public void addAttachments() {
        String sessionId = getSessionId();
        attachScreenshot("Last screenshot");
        attachPageSource();
//        attachNetwork(); // todo
        if (isWeb) attachAsText("Browser console logs", getConsoleLogs());
        Selenide.closeWindow();
        closeWebDriver();
        if (isIos || isAndroid) attachAsText("Browserstack build link", getBSPublicLink(sessionId));
        closeWebDriver();
        if (isVideoOn) attachVideo(sessionId); // in browserstack video url generates after driver close
        closeWebDriver();
    }
}

