package hexlet.code;
import java.util.Random;

public class EvenGame {
    private static final int BOUND = 100;
    private static final int RIGHTNUMBER = 3;
    private static final int ARRAYCOLUMNS = 3;
    private static final int ARRAYLINE = 2;

    private static boolean isEven(int number) {
        return number % 2 == 0; // тут проверяем что четное или нечетное и возвращаем boolean
    }

    private static String[] generateRoundData() {
        Random random = new Random();
        int number = random.nextInt(BOUND); // генерируем случайное число;
        String question = String.valueOf(number); // конвертируем в строку;
        String answer = isEven(number) ? "yes" : "no"; // вычисляем правильный ответ для числа - "yes"|"no";
        return new String[]{question, answer}; // тут метод возвращает одномерный массив [5, "no"]
    }

    public static void runGame() {
        final var description = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        String[][] roundsData = new String[ARRAYCOLUMNS][ARRAYLINE]; // создаем пустой массив
        // размера число 3 на 2 [ [], [], [] ]

        for (int i = 0; i < RIGHTNUMBER; i += 1) {
            roundsData[i] = generateRoundData(); // записываем в массив 3 на 2 результат генерации раунда
            // i = 0; [ [5, "no"], [], [] ]
            // i = 1; [ [5, "no"], [8, "yes"], [] ]
            // i = 2; [ [5, "no"], [8, "yes"], [50, "yes"] ]
        }

        Engine.run(description, roundsData);
    }
}
