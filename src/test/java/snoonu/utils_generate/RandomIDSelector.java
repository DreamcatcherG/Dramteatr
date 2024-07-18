package snoonu.utils_generate;

import java.util.Random;

import static snoonu.drivers.DriverHelper.byTestId;
import static snoonu.helpers._other_patterns.super_difficult_component.extentions.SelenideExtentions.$;

public class RandomIDSelector {

    public static String getRandomID(String[] idList) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(idList.length);
        return idList[randomIndex];
    }

    public static void main(String[] args) {
        String[] testIds = {"custom", "work", "home"};
        String randomTestId = getRandomID(testIds);

        $(byTestId(randomTestId)).click();
    }
}
