package ro.mirodone;

public class Main {

    public static void main(String[] args) {
	// start game

        RPSLS game = new RPSLS();
         boolean state =  game.running =true;
        game.welcome();
        while (state){
            game.runGame();
        }

    }
}
