package snoonu.utils_generate;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;

import static snoonu.tests.TestData.*;
import static snoonu.utils_generate.RandomUtils.getRandomInt;

public class TextGenerator {

    public static String getRandomFlatName(int min, int max) {
        String[] words = {"TestApartment", "ap", "1", "flat", "TestLoCaTiOn", "lOc", "qwerty"};

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

    public static String getRandomName(int min, int max) {

            String[] words = {"WEBTester", "web", "SnooWeb",
                    "webChecking", "AutotestONLY Don't USE",
                    "Test", "W", "Snoonu", "Checking",
                    "Tester", "QA", "tester", "Checking",
                    "red", "white", "Jane", "John", "Bobby",
                    "man", "woman", "fish", "elephant", "unicorn",
                    "a", "the", "every", "some", "any", "all",
                    "big", "tiny", "pretty", "bald", "small",
                    "runs", "jumps", "talks", "sleeps", "walks",
                    "loves", "hates", "sees", "knows", "looks for", "finds"};

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

    public static String getRandomText(int min, int max) {

            String[] words = {"a", "at", "bat", "cat", "dog",
                    "egg", "fish", "go", "hat", "ice", "jump",
                    "kite", "lion", "map", "nut", "owl", "pen",
                    "quick", "red", "sun", "tree", "up", "van",
                    "wet", "x-ray", "yellow", "zebra", "apple",
                    "banana", "carrot", "dolphin", "elephant",
                    "flower", "giraffe", "house", "igloo", "jacket",
                    "kangaroo", "lemon", "monkey", "nose", "orange",
                    "penguin", "quilt", "rabbit", "snake", "tiger",
                    "umbrella", "vase", "watermelon", "xylophone",
                    "yak", "zeppelin"};

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

    public static String getTestRandomLoc() {

        String[] locations = {Khasooma, AlRuwais, AlZubara};
        int randomIndex = getRandomInt(0, locations.length - 1);
        return locations[randomIndex];
    }

    public static String getKhasooma(int min, int max) {

        String[] locations = {"57F2+FW Khasooma" };
        int randomIndex = getRandomInt(0, locations.length - 1);
        return locations[randomIndex];

    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static String getRandomCardCvv(int min, int max) {

        String[] locations = {"123","456","789","642","457","954","237","852","159","753","369"};
        int randomIndex = getRandomInt(0, locations.length - 1);
        return locations[randomIndex];

    }

}

