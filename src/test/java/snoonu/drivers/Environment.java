package snoonu.drivers;

import static java.lang.Boolean.parseBoolean;

public class Environment {

    private static final String prodUrl = "https://snoonu.com";
    public static final String stageUrl = "https://qa.snoonu.com";
    public static final String environment = System.getProperty("environment", "stage");
    public static final String webPage = environment.equals("prod") ? prodUrl : stageUrl;

    // PLATFORM CONFIG
    public final static String
            platform = System.getProperty("platform", "web");

    // WEB CONFIG
    public static final boolean isWeb = platform.equals("web");
    public static final String
            webUrl = "https://" + System.getProperty("web_url", "autotests.cloud"),
            apiUrl = "https://" + System.getProperty("api_url", "api.autotests.cloud"),
            browser = System.getProperty("browser", "chrome"),
            screenResolution = System.getProperty("screen_resolution", "1920x1080"),
            webMobileDevice = System.getProperty("web_mobile_device"),
            remoteDriverUrl = System.getProperty("http://localhost:4444/wd/hub/"), // https://username:password@selenoid.autotests.cloud:4444/wd/hub/
            videoStorageUrl = System.getProperty("video_storage_url"); // https://selenoid.autotests.cloud/video/
    public static final boolean
            isHeadless = parseBoolean(System.getProperty("headless", "false")),
            isWebMobile = webMobileDevice != null,
            isRemoteDriver = remoteDriverUrl != null,
            isVideoOn = videoStorageUrl != null;

    // BROWSERSTACK CONFIG
    public static final String
            bsLogin = System.getProperty("bs_login", ""),
            bsPassword = System.getProperty("bs_password", "");

    // CI CONFIG (jenkins)
    public static final String
            buildNumber = System.getProperty("build_number", "0"),
            jobBaseName = System.getProperty("job_base_name", "local");
}
