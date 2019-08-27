package ro.mirodone;

import java.util.Random;
import java.util.Scanner;

public class RPSLS {

    private Scanner input = new Scanner(System.in);
    private Random randomNumber = new Random();

    private String userAnswer, randomAnswer;

    boolean running;

    private String choices(int number) {
        String choices[] = new String[5];
        choices[0] = "Rock";
        choices[1] = "Paper";
        choices[2] = "Scissors";
        choices[3] = "Lizard";
        choices[4] = "Spock";

        return choices[number];
    }

    private String results(int number) {
        String results[] = new String[10];
        results[0] = "Scissors cut Paper";
        results[1] = "Paper covers Rock";
        results[2] = "Rock crushes Lizard";
        results[3] = "Lizard poisons Spock";
        results[4] = "Spock smashes Scissors";
        results[5] = "Scissors decapitates Lizard";
        results[6] = "Lizard eats Paper";
        results[7] = "Paper disproves Spock";
        results[8] = "Spock vaporizes Rock";
        results[9] = "(and as it always has) Rock crushes Scissors";

        return results[number];
    }

     void welcome() {
        System.out.println("Welcome to the game!");
        System.out.println("Type \"rules\" in the console for instructions");
    }

    private void rules() {
        for (int i = 0; i < 10; i++) {
            System.out.println(results(i));
        }
    }

    private String getComputerChoice() {
        int number = randomNumber.nextInt(5);
        randomAnswer = choices(number);
        return randomAnswer;
    }

    private String getUserChoice() {
        System.out.println("Type your choice: ");
        userAnswer = input.nextLine();
        return userAnswer;
    }

    private void printAnswers() {
        System.out.println("Computer's choice: " + randomAnswer);
       //System.out.println("Your choice: " + userAnswer);
    }

    private  void gameLogic() {

        if (userAnswer.equalsIgnoreCase("rock") && (randomAnswer.equalsIgnoreCase("scissors") || randomAnswer.equalsIgnoreCase("lizard"))) {
            win();
        } else if (userAnswer.equalsIgnoreCase("rock") && randomAnswer.equalsIgnoreCase("rock")) {
            tie();
        } else if (userAnswer.equalsIgnoreCase("paper") && (randomAnswer.equalsIgnoreCase("rock") || randomAnswer.equalsIgnoreCase("spock"))) {
            win();
        } else if (userAnswer.equalsIgnoreCase("paper") && randomAnswer.equalsIgnoreCase("paper")) {
            tie();
        } else if (userAnswer.equalsIgnoreCase("scissors") && (randomAnswer.equalsIgnoreCase("paper") || randomAnswer.equalsIgnoreCase("lizard"))) {
            win();
        } else if (userAnswer.equalsIgnoreCase("scissors") && randomAnswer.equalsIgnoreCase("scissors")) {
            tie();
        } else if (userAnswer.equalsIgnoreCase("lizard") && (randomAnswer.equalsIgnoreCase("paper") || randomAnswer.equalsIgnoreCase("spock"))) {
            win();
        } else if (userAnswer.equalsIgnoreCase("lizard") && randomAnswer.equalsIgnoreCase("lizard")) {
            tie();
        } else if (userAnswer.equalsIgnoreCase("spock") && (randomAnswer.equalsIgnoreCase("scissors") || randomAnswer.equalsIgnoreCase("rock"))) {
            win();
        } else if (userAnswer.equalsIgnoreCase("spock") && randomAnswer.equalsIgnoreCase("spock")) {
            tie();
        } else if (userAnswer.equalsIgnoreCase("rules")) {
            rules();
        } else {
            lose();
        }

    }

    private void win() {
        System.out.println("You win!");
        playAgain();
    }

    private  void lose() {
        System.out.println("You lose!");
        playAgain();
    }


    private void tie() {
        System.out.println("I's a tie!");
        playAgain();
    }

    private void gameExit(){
        running = false;
    }

    private  void playAgain() {
        System.out.println("Would you like to play again? Y/N");
        String choice = input.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            runGame();
        } else if (choice.equalsIgnoreCase("n")) {
            gameExit();
        } else {
            System.out.println("Invalid choice , end game!");
            gameExit();
        }
    }

    public void runGame() {
        System.out.println("------------------------------------------------------");
        getComputerChoice();
        getUserChoice();
        printAnswers();
        gameLogic();
        playAgain();
        System.out.println("------------------------------------------------------");
    }


}
