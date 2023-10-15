package hexlet.code;
import java.util.Scanner;
public class App {
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
        String name;
        switch (choice) {
            case '1':
            System.out.println("Your choice is 1");
            Cli.greetUser();
            break;
            case '0':
            System.out.println("Your choice is 0");
            System.out.println("Bye");
            break;
            case '2':
            System.out.println("Your choice is 2");
            System.out.println("Welcome to the Brain Games!");
            System.out.println("May i have your name?");
            name = scanner.next();
            Engine.playEvenGame(scanner, name);
            break;
            case '3':
            System.out.println("Your choice is 3");
            System.out.println("Welcome to the Brain Games!");
            System.out.println("May i have your name?");
            name = scanner.next();
            Engine.calculatorGame(scanner, name);
            case '4':
            System.out.println("Your choice is 4");
            System.out.println("Welcome to the Brain games!");
            System.out.println("May i have your name?");
            name = scanner.next();
            Engine.gcdGame(scanner, name);
            break;
            case '5':
            System.out.println("Your choice is 5");
            System.out.println("Welcome to the Brain games!");
            System.out.println("May i have your name?");
            name = scanner.next();
            Engine.progressionGame(scanner, name);
            break;
            case '6':
            System.out.println("Your choice is 6");
            System.out.println("Welcome to the Brain games!");
            System.out.println("May i have your name?");
            name = scanner.next();
            Engine.primeGame(scanner, name);
            break;
            default:
            System.out.println("Please, make sure that you chose the right number");
        }
    }
}

