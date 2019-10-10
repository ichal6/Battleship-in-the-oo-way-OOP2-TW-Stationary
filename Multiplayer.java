import java.util.*;
import java.util.Map.Entry;

public class Multiplayer{
    int user1ShipsToShoot = 17;
    int user2ShipsToShoot = 17;
    User user1 = new User(true);
    User user2 = new User(true);
    Ocean user1Ocean = new Ocean();
    Ocean user2Ocean = new Ocean();

    public void startGame(){
        initGame(user1, user1Ocean);
        initGame(user2, user2Ocean);
    }
 
    public void initGame(User user, Ocean userOcean){

        Map<String, Integer> shipTypes = new HashMap<String, Integer>();
        shipTypes.put("Carrier", 5);
        shipTypes.put("Battleship", 4);
        shipTypes.put("Cruiser", 3);
        shipTypes.put("Submarine", 3);
        shipTypes.put("Destroyer", 2);

        for (Entry<String, Integer> entry : shipTypes.entrySet()) {
            String ship = entry.getKey();
            int mast = entry.getValue();
            boolean isAdded;
            do{
                System.out.println("Please provide coordinates for " + ship + " :");
                int x = user.getInputXGuess();
                int y = user.getInputYGuess();
                int lenght = mast;
                boolean isHorizontal = user.getUserOrientation();
                isAdded = userOcean.addShip(x, y, lenght, isHorizontal);
                if (isAdded == false){
                    System.out.println("You cannot use such coordinates!");
                }
                else{
                    System.out.println("Your board:");
                    userOcean.printBoard(); 
                }
            }
            while (isAdded == false);
        }

        

    }

    public void game(){
        while (user1ShipsToShoot > 0 && user2ShipsToShoot >0){
            userMove(user1, user2Ocean, user2ShipsToShoot);
            userMove(user2, user1Ocean, user1ShipsToShoot);

        }
    }

    public void userMove(User user, Ocean otherUserOcean, int otherUserShipsToShoot){
        System.out.println("Try to shoot!");
        int x = user.getInputXGuess();
        int y = user.getInputYGuess();
        otherUserShipsToShoot = otherUserOcean.checkIfShotCorrect(x, y);
        System.out.println("\nComputer's board:");
        otherUserOcean.printBoardView();
    }

}