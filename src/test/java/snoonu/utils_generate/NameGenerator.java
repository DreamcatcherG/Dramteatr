package snoonu.utils_generate;

import org.apache.commons.lang3.StringUtils;


import static snoonu.utils_generate.RandomUtils.getRandomInt;

public class NameGenerator {

    public static String getRandomName(int min, int max) {
        String[] words = {"Tester", "QA", "tester", "Checking"};

        StringBuilder message = new StringBuilder();
        int messageLength = getRandomInt(min, max);
        while (message.length() < messageLength) {
            int wordIndex = getRandomInt(0, words.length - 1);
            message.append(words[wordIndex] + " ");
        }


        String readyMessage = StringUtils.capitalize(message.toString())
                .replace("  ", " ")
                .replace(" ,", ",")
                .replace(" .", ".").trim();

        return readyMessage;
    }
}