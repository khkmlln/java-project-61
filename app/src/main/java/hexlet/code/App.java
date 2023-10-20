package hexlet.code;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        String selectedGame = scanner.next();
        System.out.println();

        switch (selectedGame) {
            case "1":
                Cli.greetUser();;
                break;
            case "2":
                EvenGame.runGame();
                break;
            case "3":
                CalculatorGame.runGame();
                break;
            case "4":
                NodGame.runGame();
                break;
            case "5":
                ProgressionGame.runGame();
                break;
            case "6":
                PrimeGame.runGame();
                break;
        }

        scanner.close();
    }
}