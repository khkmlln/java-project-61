package hexlet.code;
import java.util.Scanner;

public class CalculatorGame {
private static final int BOUND = 100;
    private static String[] generateRoundData() {
        var operator = "";
        int number1 = 0;
        int number2 = 0;
        String question = "";
        int rightAnswer = Integer.parseInt("");
        var randomOperator = (int) (Math.random() * 3) + 1;
        switch (randomOperator) {
            case 1:
                operator = "+";
                number1 = (int) (Math.random() * BOUND); // generated random numbers from 0 to 99
                number2 = (int) (Math.random() * BOUND);
                question = number1 + " " + operator + " " + number2;
                rightAnswer = number1 + number2;
                break;
            case '2':
                operator = "-";
                number1 = (int) (Math.random() * BOUND); // generated random numbers from 0 to 99
                number2 = (int) (Math.random() * BOUND);
                question = number1 + " " + operator + " " + number2;
                rightAnswer = number1 - number2;
                break;
            case '3':
                operator = "*";
                number1 = (int) (Math.random() * BOUND); // generated random numbers from 0 to 99
                number2 = (int) (Math.random() * BOUND);
                question = number1 + " " + operator + " " + number2;
                rightAnswer = number1 * number2;
                break;
        }
        return new String[]{question, String.valueOf(rightAnswer)};
    }

    public static void runGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        final String description = "What is the result of the expression?";
        String[][] roundsData = new String[3][2];
        for (int i = 0; i < 3; i += 1) {
            roundsData[i] = generateRoundData();
        }
        Engine.run(description, roundsData);
        for (int i = 0; i < 3; i++) {
            String question = roundsData[i][0];
            String correctAnswer = roundsData[0][i];
            System.out.println("Question: " + question);
            System.out.println("Answer: ");
            String userAnswer = scanner.next();
            if (!userAnswer.equalsIgnoreCase(correctAnswer)) {
                String part1 = ("'" + userAnswer + "'" + "is wrong answer ;(. Correct answer was ");
                System.out.println(part1 + "'" + correctAnswer + "'");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
            System.out.println("Correct!");
        }
        System.out.println("Congratulations, " + name + ",");
    }
}