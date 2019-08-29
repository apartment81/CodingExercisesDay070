package ro.mirodone;

public class Main {

    public static void main(String[] args) {
        // start game

        RPSLS game = new RPSLS();
        game.running = true;
        game.welcome();
        while (game.running) {
            game.runGame();
        }

    }
}
