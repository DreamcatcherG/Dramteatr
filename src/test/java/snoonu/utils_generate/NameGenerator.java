import java.util.Random;

public class NameGenerator {

    private static final String[] nameOptions = {"QA", "Checking", "Tester", "Engeneer", "Manual QA"};

    public static String getRandomName() {
        int randomIndex = new Random().nextInt(nameOptions.length);
        return nameOptions[randomIndex];
    }
}