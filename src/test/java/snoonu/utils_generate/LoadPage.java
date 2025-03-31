package snoonu.utils_generate;

import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.codeborne.selenide.Selenide.Wait;

public class LoadPage {

    public static void pageInit() { // LoadPage.pageInit();
        Wait().until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public static void waitForApiResponse(String apiUrl) throws InterruptedException, IOException {
        while (true) {
            try {
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int statusCode = connection.getResponseCode();

                if (statusCode == 200) {
                    break;
                }
            } catch (IOException e) {
                Thread.sleep(1000);
            }
        }
    }
}

