package hexlet.code;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calculator");
        System.out.println("0 - Exit");
        System.out.println("Your choice: ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Your choice = 1");
            Cli.greetUser();
        } else if (choice == 0) {
            System.out.println("Your choice = 0");
            System.out.println("Bye");
        } else if (choice == 2) {
            System.out.println("Your choice is 2");
            System.out.println("Welcome to the Brain Games!");
            System.out.println("May i have your name?");
            String name = scanner.next();
            Engine.playEvenGame(scanner, name);
        } else if (choice == 3) {
            System.out.println("Your choice is 3");
            System.out.println("Welcome to the Brain Games!");
            System.out.println("May i have your name?");
            String name = scanner.next();
            Engine.calculatorGame(scanner, name);
        } else {
            System.out.println("Please, make sure that you chose the right number");
        }
    }
}

