package hexlet.code;
import java.util.Random;
public class Utils {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 100;
    private static Random random = new Random();
    public static int generateNumber(int number1, int number2) {
        number1 = MINIMUM;
        number2 = MAXIMUM;
        return random.nextInt(((number2 - number1) + 1) + MINIMUM);
    }
}
