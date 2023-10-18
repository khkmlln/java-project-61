package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class PrimeGame {
    private static final int BOUND = 100;

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

    public static String[] generateRoundData() {
        Random random = new Random();
        int number = random.nextInt(BOUND);
        String question = String.valueOf(number);// конвертируем в строку;
        String answer = isPrime(number) ? "yes" : "no";
        return new String[]{question, answer}; // тут метод возвращает одномерный массив [5, "no"]
    }

    public static void runGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        final var description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] roundsData = new String[3][2]; // создаем пустой массив размера число 3 на 2 [ [], [], [] ]

        for (int i = 0; i < 3; i += 1) {
            roundsData[i] = generateRoundData();
        }
        Engine.run(description, roundsData);
    }
}