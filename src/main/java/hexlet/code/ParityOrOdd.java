package hexlet.code;
import java.util.Scanner;
import java.util.Random;
public class ParityOrOdd {
    public static void PlayEvenGame() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May i have your name?");
        Scanner scanner1 = new Scanner(System.in);
        String name1 = scanner1.nextLine();
        System.out.println("Hello, " + name1 + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int countOfCorrectAnswers = 0;
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt();
            System.out.println("Question: " + number);
            String answer = scanner.nextLine();
            System.out.println("Your answer: " + answer);
            if ((number % 2 == 0 && answer.equals("yes")) || (number % 2 != 0 && answer.equals("no"))) {
                System.out.println("Correct!");
                countOfCorrectAnswers++;
            } else {
                System.out.println("'" + answer + " is wrong answer ;(. Correct answer was '" + (number % 2 == 0 ? "yes" : "no") + "'");
                System.out.println("Let's try again, " + name1);
                break;
            }
        }
        if (countOfCorrectAnswers == 3) {
            System.out.println("Congratulations, " + name1 + "!");
        }
    }
}
