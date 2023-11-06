package hexlet.code.game;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalculatorGame {
    private static final int BOUND = 100;
    private static final int FIRSTBOUND = 1;
    private static final int OPERATOR = 3;
    private static final int RIGHTNUMBER = 3;
    private static final int ARRAYCOLUMNS = 3;
    private static final int ARRAYLINE = 2;

    private static String[] generateRoundData() {
        var number1 = Utils.generateNumber(FIRSTBOUND, BOUND);
        int number2 = Utils.generateNumber(FIRSTBOUND, BOUND);
        String operator = getRandomOperator();
        String question = number1 + " " + operator + " " + number2;
        String answer = String.valueOf(calculate(operator, number1, number2));
        return new String[]{question, answer};
    }
    public static void runGame() {
        final var description = "What is the result of the expression?";
        String[][] roundsData = new String[ARRAYCOLUMNS][ARRAYLINE];

        for (int i = 0; i < RIGHTNUMBER; i += 1) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(description, roundsData);
    }


    private static String getRandomOperator() {
        int operatorIndex = Utils.generateNumber(0, OPERATOR - 1);
        String[] operators = {"+", "-", "*"};
        return operators[operatorIndex];
     }
    private static int calculate(String operator, int number1, int number2) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            default:
                return 0;
        }
    }
}
