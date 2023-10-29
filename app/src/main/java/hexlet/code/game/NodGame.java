package hexlet.code.game;
import hexlet.code.Engine;
import hexlet.code.Utils;
public class NodGame {
    private static final int BOUND = 100;
    private static final int RIGHTNUMBER = 3;
    private static final int ARRAYCOLUMNS = 3;
    private static final int ARRAYLINE = 2;
    private static int gcdGame(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return gcdGame(number2, number1 % number2);
    }

    private static String[] generateRoundData() {
        int number1 = Utils.generateNumber(0, BOUND);
        int number2 = Utils.generateNumber(0, BOUND);
        int gcd = calculateGcd(number1, number2);
        String question = number1 + " " + number2;
        String answer = String.valueOf(gcd);
        return new String[]{question, answer};
    }

    public static void runGame() {
        final var description = "Find the greatest common divisor of given numbers.";
        String[][] roundsData = new String[ARRAYCOLUMNS][ARRAYLINE];
        for (int i = 0; i < RIGHTNUMBER; i += 1) {
            roundsData[i] = generateRoundData();
        }
        Engine.run(description, roundsData);
    }

    public static int calculateGcd(int number1, int number2) {
        while (number2 != 0) {
            int temp = number2;
            number2 = number1 % number2;
            number1 = temp;
        }
        return number1;
    }
}
