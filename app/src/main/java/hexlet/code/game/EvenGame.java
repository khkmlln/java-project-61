package hexlet.code.game;
import hexlet.code.Engine;
import hexlet.code.Utils;
public class EvenGame {
    private static final int BOUND = 100;
    private static final int RIGHTNUMBER = 3;
    private static final int ARRAYCOLUMNS = 3;
    private static final int ARRAYLINE = 2;

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static String[] generateRoundData() {
        int number =Utils.generateNumber(0, BOUND);
        String question = String.valueOf(number);
        String answer = isEven(number) ? "yes" : "no";
        return new String[]{question, answer};
    }

    public static void runGame() {
        final var description = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        String[][] roundsData = new String[ARRAYCOLUMNS][ARRAYLINE];

        for (int i = 0; i < RIGHTNUMBER; i += 1) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(description, roundsData);
    }
}
