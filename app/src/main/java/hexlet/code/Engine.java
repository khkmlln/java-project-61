package hexlet.code;
import java.util.Scanner;
import java.util.Random;
public class Engine {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May i have your name");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        playEvenGame(scanner, name);
        calculatorGame(scanner, name);
        System.out.println("Congratulations, " + name);
    }

    public static void playEvenGame(Scanner scanner, String name) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Random random = new Random();
        int countOfCorrectAnswers = 0;
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt();
            System.out.println("Question: " + number);
            String answer = scanner.next();
            System.out.println("Your answer: " + answer);
            if ((number % 2 == 0 && answer.equals("yes")) || (number % 2 != 0 && answer.equals("no"))) {
                System.out.println("Correct!");
                countOfCorrectAnswers++;
            } else {
                System.out.println("'" + answer + " is wrong answer ;(. Correct answer was '" + (number % 2 == 0 ? "yes" : "no") + "'");
                System.out.println("Let's try again, " + name);
                break;
            }
        }
        if (countOfCorrectAnswers == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    public static void calculatorGame(Scanner scanner, String name) {
        System.out.println("What is the result of the expression?");
        Random random = new Random();
        int countCorrectAnswers = 0;
        for (int i = 0; i < 3; i++) {
            int number1 = random.nextInt(100);
            int number2 = random.nextInt(100);
            char operator = getRandomOperator();
            int rightAnswer = calculateExpression(number1, number2, operator);
            System.out.println("Question: " + number1 + " " + operator + " " + number2);
            System.out.println("Your answer: ");
            int yourNumber = scanner.nextInt();
            if (yourNumber == rightAnswer) {
                System.out.println("Correct!");
                countCorrectAnswers++;
            } else {
                System.out.println("'" + yourNumber + "'" + " is wrong answer ;( Correct answer was " + "'" + rightAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }
        if (countCorrectAnswers == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    private static char getRandomOperator() {
        Random random = new Random();
        int varietyOfOperator = random.nextInt(3);
        if (varietyOfOperator == 0) {
            return '+';
        } else if (varietyOfOperator == 1) {
            return '-';
        } else {
            return '*';
        }
    }

    private static int calculateExpression(int number1, int number2, char operator) {
        if (operator == '+') {
            return number1 + number2;
        } else if (operator == '-') {
            return number1 - number2;
        } else {
            return number1 * number2;
        }
    }
}
