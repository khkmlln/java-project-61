package hexlet.code.game;
import hexlet.code.Utils;
import hexlet.code.Engine;
public class ProgressionGame {
    private static final int BOUND = 100;
    private static final int MINLEGTH = 5;
    private static final int MAXLENGTH = 10;
    private static final int RIGHTNUMBER = 3;
    private static final int ARRAYCOLUMNS = 3;
    private static final int ARRAYLINE = 2;


    private static String[] generateRoundData() {
        int length = Utils.generateNumber(MINLEGTH, MAXLENGTH);
        int hidden = Utils.generateNumber(0, length - 1);
        int start = Utils.generateNumber(0, BOUND);
        int step = Utils.generateNumber(0, BOUND);
        String[] progression = makeProgression(start, step, length);
        progression[hidden] = "..";
        return progression;
    }
        private static String generateQuestion(String[] progression) {
        return String.join(" ", progression);
        }
        private static String generateAnswer(String[] progression, int hiddenIndex) {
            return progression[hiddenIndex];
        }
    public static void runGame() {
        final var description = "What number is missing in the progression?";
                String[][] roundsData = new String[ARRAYCOLUMNS][ARRAYLINE];
        for (int i = 0; i < RIGHTNUMBER; i++) {
            String[] progression = generateRoundData();
            int hiddenIndex = findHiddenIndex(progression);
            String question = generateQuestion(progression);
            String answer = generateAnswer(progression, hiddenIndex);
            roundsData[i] = new String[]{question, answer};
        }
        Engine.run(description, roundsData);
    }
    public static int findHiddenIndex(String[] progression) {
        for (int i = 0; i < progression.length; i++) {
            if (progression[i].equals("..")) {
                return i;
            }
        }
        return -1;
    }
    private static String[] makeProgression(int first, int step, int length) {
String[] progression = new String[length];
int currentNumber = first;
for (int i = 0; i < length; i++) {
    progression[i] = String.valueOf(currentNumber);
    currentNumber = currentNumber + step;
}
return progression;
    }
}

