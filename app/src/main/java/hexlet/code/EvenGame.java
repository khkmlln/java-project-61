package hexlet.code;
import java.util.Scanner;
import java.util.Random;

public class EvenGame {
    private static final int BOUND = 100;
    private static boolean isEven(int number) {
       return number % 2 == 0; // тут проверяем что четное или нечетное и возвращаем boolean
    }

    private static String[] generateRoundData() {
        Random random = new Random();
        int number = random.nextInt(BOUND);// генерируем случайное число;
        String question = String.valueOf(number);// конвертируем в строку;
        String answer = isEven(number) ? "yes" : "no";// вычисляем правильный ответ для числа - "yes"|"no";
        return new String[] {question, answer}; // тут метод возвращает одномерный массив [5, "no"]
    }

    public static void runGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        final var description = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        String[][] roundsData = new String[3][2]; // создаем пустой массив размера число 3 на 2 [ [], [], [] ]

        for (int i = 0; i < 3; i += 1) {
            roundsData[i] = generateRoundData(); // записываем в массив 3 на 2 результат генерации раунда
            // i = 0; [ [5, "no"], [], [] ]
            // i = 1; [ [5, "no"], [8, "yes"], [] ]
            // i = 2; [ [5, "no"], [8, "yes"], [50, "yes"] ]
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