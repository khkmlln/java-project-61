package hexlet.code;
import java.util.Random;
import java.util.Scanner;
public class ProgressionGame {
    private static final int BOUND = 100;
    private static final int MAXLENGTH = 5;
    private static final int MINLENGTH = 10;


    private static String[] generateRoundData() {
        Random random = new Random();
        int length = (MINLENGTH - MAXLENGTH + 1) + MINLENGTH;
        int hidden = random.nextInt(length);
        int start = random.nextInt(BOUND);
        int step = random.nextInt(BOUND);
        StringBuilder questionBuilder = new StringBuilder();
        int currentNumber = start;
        for (int i = 0; i < length; i++) {
            if (i == hidden) {
                questionBuilder.append(".. ");
            } else {
                questionBuilder.append(currentNumber).append(" ");
            }
            currentNumber = currentNumber + step;
        }
        String question = questionBuilder.toString().trim();
        String answer = String.valueOf(start + hidden * step);
        return new String[]{question, answer};
    }

    public static void runGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        final String description = "What number is missing in the progression?";
        String[][] roundsData = new String[3][2];
        for (int i = 0; i < 3; i += 1) {
            roundsData[i] = generateRoundData();
        }
        Engine.run(description, roundsData);
    }
}

