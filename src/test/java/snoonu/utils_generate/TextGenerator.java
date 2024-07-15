package snoonu.utils_generate;


import java.util.Random;

import static afu.org.checkerframework.checker.units.UnitsTools.min;
import static snoonu.tests.TestData.*;
import static snoonu.utils_generate.RandomUtils.getRandomInt;

public class TextGenerator {

    public static String getRandomText(int min, int max) {
        StringBuilder text = new StringBuilder();
        Random random = new Random();

        int textLength = getRandomNumber(min, max);
        while (text.length() < textLength) {
            char randomChar;
            if (random.nextBoolean()) {
                randomChar = (char) (random.nextInt(26) + 'a');
            } else {
                randomChar = (char) (random.nextInt(26) + 'A');
            }
            text.append(randomChar);
        }

        return text.toString();
    }

    public static String getRandomAlphaNumeric(int min, int max) {
        StringBuilder text = new StringBuilder();
        Random random = new Random();

        int textLength = getRandomNumber(min, max); // тут принимает getRandomNumber
        while (text.length() < textLength) {
            char randomChar;
            if (random.nextBoolean()) {
                randomChar = (char) (random.nextInt(26) + 'a');
            } else {
                randomChar = (char) (random.nextInt(26) + 'A');
            }
            if (random.nextBoolean()) {
                text.append(randomChar);
            } else {
                text.append(random.nextInt(10));
            }
        }

        return text.toString();
    }

    public static String getTestRandomLoc() {
//        String[] locations = {AlRuwais, AlZubara};
//        String[] locations = {AlRuwais, Khasooma};
        String[] locations = {Khasooma};
        int randomIndex = getRandomInt(0, locations.length - 1);
        return locations[randomIndex];
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static String getRandomEmail(int min, int max) {
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        int emailLength = getRandomNumber(min, max);
        while (email.length() < emailLength) {
            char randomChar = (char) (random.nextInt(26) + 'a'); // Генерация случайной буквы
            email.append(randomChar);
        }
        email.append("@webtest.com");
        return email.toString();
    }
}

