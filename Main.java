import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to battleship game!");
        System.out.println("Choose game mode:");
        System.out.println("1. Simulation (Computer vs Computer)\n2. Single player (Player vs Computer)");
        System.out.println("3. Multiplayer (Player1 vs Player2)");
        Scanner input = new Scanner(System.in);
        int chosenMode = input.nextInt();
        switch(chosenMode){
            case 1:
                Simulation game2 = new Simulation();
                game2.game();
                break;
            case 2:
                SinglePlayer game = new SinglePlayer();
                game.initGame();
                game.game();
                break;
            case 3:
                break;
        }
    }
}