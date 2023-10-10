package hexlet.code;
import java.util.Scanner;
public class App {
    private static final int GREETING = 1;
    private static final int EVEN = 2;
    private static final int CALCULATOR = 3;
    private static final int GCD = 4;
    private static final int PROGRESSION = 5;
    private static final int PRIME = 6;
    private static final int EXIT = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calculator");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.println("Your choice: ");
        int choice = scanner.nextInt();
        if (choice == GREETING) {
            System.out.println("Your choice is 1");
            Cli.greetUser();
        } else if (choice == EXIT) {
            System.out.println("Your choice is 0");
            System.out.println("Bye");
        } else if (choice == EVEN) {
            System.out.println("Your choice is 2");
            System.out.println("Welcome to the Brain Games!");
            System.out.println("May i have your name?");
            String name = scanner.next();
            Engine.playEvenGame(scanner, name);
        } else if (choice == CALCULATOR) {
            System.out.println("Your choice is 3");
            System.out.println("Welcome to the Brain Games!");
            System.out.println("May i have your name?");
            String name = scanner.next();
            Engine.calculatorGame(scanner, name);
        } else if (choice == GCD) {
            System.out.println("Your choice is 4");
            System.out.println("Welcome to the Brain games!");
            System.out.println("May i have your name?");
            String name = scanner.next();
            Engine.gcdGame(scanner, name);
        } else if (choice == PROGRESSION) {
            System.out.println("Your choice is 5");
            System.out.println("Welcome to the Brain games!");
            System.out.println("May i have your name?");
            String name = scanner.next();
            Engine.progressionGame(scanner, name);
        } else if (choice == PRIME) {
            System.out.println("Your choice is 6");
            System.out.println("Welcome to the Brain games!");
            System.out.println("May i have your name?");
            String name = scanner.next();
            Engine.primeGame(scanner, name);
        } else {
            System.out.println("Please, make sure that you chose the right number");
        }
    }
}

