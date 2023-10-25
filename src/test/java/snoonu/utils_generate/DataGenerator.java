package snoonu.utils_generate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataGenerator {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyy");
    public static LocalDateTime dateNow = LocalDateTime.now();
    public static String otp = dtf.format(dateNow);

}