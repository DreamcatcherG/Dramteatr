package snoonu.utils_generate;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.Wait;

public class LoadPage {

    public static void pageInit() { // LoadPage.pageInit();

        Wait().until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));

    }

    public static void waitForApiResponse(String apiUrl) throws InterruptedException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl);

        while (true) {
            try {
                ClassicHttpResponse response = httpClient.execute(httpGet);
                int statusCode = response.getCode();

                if (statusCode == 200) {
                    break;
                }
            } catch (IOException e) {
                // Если возникло исключение, ждем некоторое время и повторяем запрос
                Thread.sleep(1000);
            }
        }

        httpClient.close();
    }
}

