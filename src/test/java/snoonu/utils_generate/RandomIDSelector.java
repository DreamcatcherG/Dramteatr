package snoonu.utils_generate;

import java.util.Random;

public class RandomIDSelector {

    public static String getRandomID(String[] idList) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(idList.length);
        return idList[randomIndex];
    }
}
