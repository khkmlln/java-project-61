package hexlet.code;
import java.util.Scanner;
public class Engine {

    public static void run(String description, String[][] roundsData) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        System.out.println(description);
        for (int i = 0; i < 3; i++) {
            String question = roundsData[i][0];
            String correctAnswer = roundsData[0][i];
            System.out.println("Question: " + question);
            System.out.println("Answer: ");
            String userAnswer = scanner.next();
            if (!userAnswer.equalsIgnoreCase(correctAnswer)) {
                String part1 = ("'" + userAnswer + "'" + "is wrong answer ;(. Correct answer was");
                System.out.println(part1 + "'" + correctAnswer + "'");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
            System.out.println("Correct!");
        }
        System.out.println("Congratulations, " + name + ",");
    }
}