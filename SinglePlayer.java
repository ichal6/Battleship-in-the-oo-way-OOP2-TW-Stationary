import java.util.*;
import java.util.Map.Entry;
public class SinglePlayer{

    int carrierShip = 5;
    int compShipsToShoot = 2;
    int userShipsToShoot = 17;
    User user = new User(true);
    User comp = new User(false);
    Ocean userOcean = new Ocean();
    Ocean compOcean = comp.makeBoardWithRandomShips();
 
    public void initGame(){

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
        while (userShipsToShoot > 0 && compShipsToShoot >0){
            userMove();
            compMove();

        }
    }

    public void userMove(){
        System.out.println("Try to shoot!");
        int x = user.getInputXGuess();
        int y = user.getInputYGuess();
        compShipsToShoot = compOcean.checkIfShotCorrect(x, y);
        System.out.println("\nComputer's board:");
        compOcean.printBoardView();
        // System.out.println("");
        // compOcean.printBoard();
    }

    public void compMove(){
        int x = comp.getRandomXGuess();
        int y = comp.getRandomYGuess();
        userShipsToShoot = userOcean.checkIfShotCorrect(x, y);
        System.out.println("\nYour board: ");
        userOcean.printBoardView();
        // System.out.println("\n");
        // userOcean.printBoard();
    }



    
    


}