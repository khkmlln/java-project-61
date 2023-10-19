package hexlet.code;
import java.util.Random;
import java.util.Scanner;
public class NodGame {
    private static final int BOUND = 100;

    private static int GCDgame(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return GCDgame(number2, number1 % number2);
    }

    private static String[] generateRoundData() {
        Random random = new Random();
        int number1 = random.nextInt(BOUND);
        int number2 = random.nextInt(BOUND);
        int GCD = calculateGCD(number1, number2);
        String question = number1 + " " + number2;
        String answer = String.valueOf(GCD);
        return new String[]{question, answer};
    }

    public static void runGame() {
        String[][] roundsData = new String[3][2];
        for (int i = 0; i < 3; i += 1) {
            roundsData[i] = generateRoundData();
        }
        Engine.run(description, roundsData);
    }

    public static int calculateGCD(int number1, int number2) {
        while (number2 != 0) {
            int temp = number2;
            number2 = number1 % number2;
            number1 = temp;
        }
        return number1;
    }
}
