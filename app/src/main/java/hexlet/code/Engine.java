package hexlet.code;
import java.util.Scanner;
public class Engine {
    private static final int RIGHTNUMBER = 3;

    public static void run(String description, String[][] roundsData) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        System.out.println(description);
        int incorrectAnswer = 0;
        for (int i = 0; i < RIGHTNUMBER; i++) {
            String question = roundsData[i][0];
            String correctAnswer = roundsData[i][1];
            System.out.println("Question: " + question);
            System.out.println("Answer: ");
            String userAnswer = scanner.next();
            if (!userAnswer.equalsIgnoreCase(correctAnswer)) {
                String part1 = ("'" + userAnswer + "'" + "is wrong answer ;(. Correct answer was ");
                System.out.println(part1 + "'" + correctAnswer + "'");
                System.out.println("Let's try again, " + name + "!");
                incorrectAnswer++;
                break;
            }
            System.out.println("Correct!");
        }
        if (incorrectAnswer == 0) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
