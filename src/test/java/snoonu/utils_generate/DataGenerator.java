package snoonu.utils_generate;

import com.codeborne.selenide.SelenideElement;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class DataGenerator {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyy");
    public static LocalDateTime dateNow = LocalDateTime.now();
    public static String otp = dtf.format(dateNow);

}