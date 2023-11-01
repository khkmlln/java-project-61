package hexlet.code.game;
import hexlet.code.Utils;
import hexlet.code.Engine;
public class ProgressionGame {
    private static final int BOUND = 100;
    private static final int PROGRESSIONLENGTH = 8;
    private static final int RIGHTNUMBER = 3;
    private static final int ARRAYCOLUMNS = 3;
    private static final int ARRAYLINE = 2;
    private static final int FIRSTBOUND = 1;


    private static String[] generateRoundData() {
        var start = Utils.generateNumber(FIRSTBOUND, BOUND);
        var step = Utils.generateNumber(FIRSTBOUND, BOUND);
        var hidden = Utils.generateNumber(0, PROGRESSIONLENGTH - 1);
        String[] progression = makeProgression(start, step, PROGRESSIONLENGTH);
        var answer = progression[hidden];
        progression[hidden] = "..";
        var question = String.join(" ", progression);
        return new String[]{question, answer};
    }

    private static String generateQuestion(String[] progression) {
        return String.join(" ", progression);
    }

    private static String generateAnswer(String[] progression, int hiddenIndex) {
        if (hiddenIndex < 0) {
            return "";
        }
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
        for (int i = 0; i < length; i++) {
            progression[i] = Integer.toString(first + i * step);
        }
        return progression;
    }
}

