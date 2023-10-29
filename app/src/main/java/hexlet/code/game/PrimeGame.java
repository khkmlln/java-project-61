package hexlet.code.game;
import hexlet.code.Engine;
import hexlet.code.Utils;
public class PrimeGame {
    private static final int BOUND = 100;
    private static final int RIGHTNUMBER = 3;
    private static final int ARRAYCOLUMNS = 3;
    private static final int ARRAYLINE = 2;

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String[] generateRoundData() {
        int number = Utils.generateNumber(0, BOUND);
        String question = String.valueOf(number);
        String answer = isPrime(number) ? "yes" : "no";
        return new String[]{question, answer};
    }

    public static void runGame() {
        final var description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] roundsData = new String[ARRAYCOLUMNS][ARRAYLINE];

        for (int i = 0; i < RIGHTNUMBER; i += 1) {
            roundsData[i] = generateRoundData();
        }
        Engine.run(description, roundsData);
    }
}
