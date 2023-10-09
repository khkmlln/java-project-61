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

    public static void playEvenGame(Scanner scanner, String name) {
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Random random = new Random();
        int countOfCorrectAnswers = 0;
        int bound = 3;
        for (int i = 0; i < bound; i++) {
            int number = random.nextInt();
            System.out.println("Question: " + number);
            String answer = scanner.next();
            System.out.println("Your answer: " + answer);
            if ((number % 2 == 0 && answer.equals("yes")) || (number % 2 != 0 && answer.equals("no"))) {
                System.out.println("Correct!");
                countOfCorrectAnswers++;
            } else {
                System.out.println("'" + answer + " is wrong answer ;(. Correct answer was '" + (number % 2 == 0 ? "yes" : "no") + "'");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }
        if (countOfCorrectAnswers == bound) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    public static void calculatorGame(Scanner scanner, String name) {
        System.out.println("Hello, " + name + "!");
        System.out.println("What is the result of the expression?");
        Random random = new Random();
        int countCorrectAnswers = 0;
        int bound = 3;
        int boundariesForRandom = 100;
        for (int i = 0; i < bound; i++) {
            int number1 = random.nextInt(boundariesForRandom);
            int number2 = random.nextInt(boundariesForRandom);
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
        if (countCorrectAnswers == bound) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
public static void gcdGame(Scanner scanner, String name) {
    System.out.println("Hello, " + name + "!");
    System.out.println("Find the greatest common divisor of given numbers.");
    Random random = new Random();
    int rightAnswersCount = 0;
    int bound = 3;
    int boundariesForRandom = 100;
    for (int i = 0; i < bound; i++) { // 3 means that we count until 3 right results
        int number1 = random.nextInt(boundariesForRandom);
        int number2 = random.nextInt(boundariesForRandom);
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
    if (rightAnswersCount == bound) {
        System.out.println("Congratulations, " + name + "!");
    }
}
public static void progressionGame(Scanner scanner, String name) {
    System.out.println("Hello, " + name + "!");
    System.out.println("What number is missing in the progression?");
    Random random = new Random();
    int theRightResult = 0;
    int bound = 3;
    int boundariesForStartNumber = 50;
    int boundariesForStep = 10;
    int boundariesForLength = 6;
    for (int i = 0; i < bound; i++) { // 3 means that we count until 3 right results
        int startNumber = random.nextInt(boundariesForStartNumber);
        int step = random.nextInt(boundariesForStep) + 1;
        int length = random.nextInt(boundariesForLength) + 5;
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
            System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '" + rightAnswer + "'");
            System.out.println("Let's try again, " + name + "!");
            break;
        }
    }
    if (theRightResult == bound) {
        System.out.println("Congratulations, " + name + "!");
    }
}

public static void primeGame(Scanner scanner, String name) {
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Random random = new Random();
        int rightAnswersOnly = 0;
        int boundaries = 100;
        int bound = 3;
        for (int i = 0; i < bound; i++) {
            int number = random.nextInt(boundaries);
            System.out.println("Question: " + number);
            System.out.println("Your answer: ");
            String answerOfUser = scanner.next();
            if (isPrime(number) && answerOfUser.equals("yes") || !isPrime(number) && answerOfUser.equals("no")) {
                System.out.println("Correct!");
                rightAnswersOnly++;
            } else {
                System.out.println("'" + answerOfUser + "'" + "is wrong answer ;(. Correct answer was '" + (isPrime(number) ? "yes" : "no") + "'");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }
            if (rightAnswersOnly == bound) {
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
