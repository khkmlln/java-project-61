package hexlet.code;
import java.util.Scanner;
import java.util.Random;
public class Engine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May i have your name");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        playEvenGame(scanner, name);
        calculatorGame(scanner, name);
        gcdGame(scanner, name);
        progressionGame(scanner, name);
        System.out.println("Congratulations, " + name);
    }
    private final static int BOUND = 3;
    private final static int HUNDRED = 100;
    private final static int START = 50;
    private final static int STEP = 10;
    private final static int LENGTH = 6;
    public static void playEvenGame(Scanner scanner, String name) {
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Random random = new Random();
        int countOfCorrectAnswers = 0;
        for (int i = 0; i < BOUND; i++) {
            int number = random.nextInt();
            System.out.println("Question: " + number);
            String answer = scanner.next();
            System.out.println("Your answer: " + answer);
            if ((number % 2 == 0 && answer.equals("yes")) || (number % 2 != 0 && answer.equals("no"))) {
                System.out.println("Correct!");
                countOfCorrectAnswers++;
            } else {
                String part1 = "'" + answer + " is wrong answer ;(. Correct answer was '";
                System.out.println(part1 + (number % 2 == 0 ? "yes" : "no") + "'");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }
        if (countOfCorrectAnswers == BOUND) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    public static void calculatorGame(Scanner scanner, String name) {
        System.out.println("Hello, " + name + "!");
        System.out.println("What is the result of the expression?");
        Random random = new Random();
        int countCorrectAnswers = 0;
        for (int i = 0; i < BOUND; i++) {
            int number1 = random.nextInt(HUNDRED);
            int number2 = random.nextInt(HUNDRED);
            char operator = getRandomOperator();
            int rightAnswer = calculateExpression(number1, number2, operator);
            System.out.println("Question: " + number1 + " " + operator + " " + number2);
            System.out.println("Your answer: ");
            int yourNumber = scanner.nextInt();
            if (yourNumber == rightAnswer) {
                System.out.println("Correct!");
                countCorrectAnswers++;
            } else {
                String part1 = "'" + yourNumber + "'" + " is wrong answer ;( Correct answer was ";
                System.out.println(part1 + "'" + rightAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }
        if (countCorrectAnswers == BOUND) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
public static void gcdGame(Scanner scanner, String name) {
    System.out.println("Hello, " + name + "!");
    System.out.println("Find the greatest common divisor of given numbers.");
    Random random = new Random();
    int rightAnswersCount = 0;
    for (int i = 0; i < BOUND; i++) { // 3 means that we count until 3 right results
        int number1 = random.nextInt(HUNDRED);
        int number2 = random.nextInt(HUNDRED);
        int rightAnswer = calculateGCD(number1, number2);
        System.out.println("Question: " + number1 + " " + number2);
        System.out.println("Your answer: ");
        int userAnswer = scanner.nextInt();
        if (userAnswer == rightAnswer) {
            System.out.println("Correct!");
            rightAnswersCount++;
        } else {
            System.out.println("'" + userAnswer + " is wrong answer ;(. Correct answer was '" + rightAnswer + "'");
            System.out.println("Let's try again, " + name + "!");
            break;
        }
    }
    if (rightAnswersCount == BOUND) {
        System.out.println("Congratulations, " + name + "!");
    }
}
public static void progressionGame(Scanner scanner, String name) {
    System.out.println("Hello, " + name + "!");
    System.out.println("What number is missing in the progression?");
    Random random = new Random();
    int theRightResult = 0;
    for (int i = 0; i < BOUND; i++) { // 3 means that we count until 3 right results
        int startNumber = random.nextInt(START);
        int step = random.nextInt(STEP) + 1;
        int length = random.nextInt(LENGTH) + 5;
        int hiddenN = random.nextInt(length);
        int[] progression = generateArithmeticProgression(startNumber, step, length);
        progression[hiddenN] = -1;
        String question = getProgressionAsString(progression);
        int rightAnswer = startNumber + step * hiddenN;
        System.out.println("Question: " + question);
        System.out.println("Your answer: ");
        int userAnswer = scanner.nextInt();
        if (userAnswer == rightAnswer) {
            System.out.println("Correct!");
            theRightResult++;
        } else {
            String part1 = "'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '";
            System.out.println(part1 + rightAnswer + "'");
            System.out.println("Let's try again, " + name + "!");
            break;
        }
    }
    if (theRightResult == BOUND) {
        System.out.println("Congratulations, " + name + "!");
    }
}

public static void primeGame(Scanner scanner, String name) {
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Random random = new Random();
        int rightAnswersOnly = 0;
        for (int i = 0; i < BOUND; i++) {
            int number = random.nextInt(HUNDRED);
            System.out.println("Question: " + number);
            System.out.println("Your answer: ");
            String answerOfUser = scanner.next();
            if (isPrime(number) && answerOfUser.equals("yes") || !isPrime(number) && answerOfUser.equals("no")) {
                System.out.println("Correct!");
                rightAnswersOnly++;
            } else {
                String part1 = "'" + answerOfUser + "'" + "is wrong answer ;(. Correct answer was '";
                System.out.println(part1 + (isPrime(number) ? "yes" : "no") + "'");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }
            if (rightAnswersOnly == BOUND) {
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
    private static int calculateGCD(int number1, int number2) {
        while (number2 != 0) {
            int temp = number2;
            number2 = number1 % number2;
            number1 = temp;
        }
        return number1;
    }
    private static int[] generateArithmeticProgression(int startNumber, int step, int length) {
        int[] progression = new int[length];
        progression[0] = startNumber;
        for (int i = 1; i < length; i++) {
            progression[i] = progression[i - 1] + step;
        }
        return progression;
    }

    private static String getProgressionAsString(int[] progression) {
    StringBuilder sb = new StringBuilder();
    for (int number : progression) {
        if (number == -1) {
            sb.append(".. ");
        } else {
            sb.append(number).append(" ");
        }
    }
    return sb.toString().trim();
    }

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
}
