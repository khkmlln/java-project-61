package hexlet.code;
import java.util.Random;
import java.util.Scanner;

public class CalculatorGame {
    private static final int BOUND = 100;
    private static final int OPERATOR = 3;

    private static String[] generateRoundData() {
        Random random = new Random();
        int number1 = random.nextInt(BOUND);
        int number2 = random.nextInt(BOUND);
        String question = number1 + " " + getRandomOperator() + " " + number2;
        String answer = calculate(getRandomOperator(), number1, number2);
        return new String[]{question, answer};
    }
    public static void runGame() {
        String[][] roundsData = new String[3][2]; // создаем пустой массив размера число 3 на 2 [ [], [], [] ]

        for (int i = 0; i < 3; i += 1) {
            roundsData[i] = generateRoundData(); // записываем в массив 3 на 2 результат генерации раунда
            // i = 0; [ ["5 + 3", "8"], [], [] ]
            // i = 1; [ ["5 + 3", "8"], ["7 * 2", "114"], [] ]
            // i = 2; [ ["5 + 3", "8"], ["7 * 2", "114"], ["11 - 5", "6"] ]
        }

        Engine.run(description, roundsData);
    }


    private static String getRandomOperator() {
        Random random = new Random();
        int operatorIndex = random.nextInt(OPERATOR);
        String[] operators = {"+", "-", "*"};
        return operators[operatorIndex];
    }
    private static String calculate(String operator, int number1, int number2) {
        switch (operator){
            case "+":
                return String.valueOf(number1 + number2);
            case "-":
                return String.valueOf(number1 - number2);
            case "*":
                return String.valueOf(number1 * number2);
            default:
                return "";
        }
    }
}