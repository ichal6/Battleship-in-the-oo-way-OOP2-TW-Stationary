
public class SinglePlayer{

    int carrierShip = 5;
    int compShipsToShoot = 2;
    int userShipsToShoot = 17;
    User user = new User(true);
    User comp = new User(false);
    Ocean userOcean = new Ocean();
    Ocean compOcean = comp.makeBoardWithRandomShips();
 
    public void initGame(){
        
        System.out.println("Please provide coordinates for Carrier:");
        int x = user.getInputXGuess();
        int y = user.getInputYGuess();
        int lenght = carrierShip;
        boolean isHorizontal = user.getUserOrientation();
        userOcean.addShip(x, y, lenght, isHorizontal);
        //dodac pozostale statki

        

         

        

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
        System.out.println("");
        compOcean.printBoard();
    }

    public void compMove(){
        int x = comp.getRandomXGuess();
        int y = comp.getRandomYGuess();
        userShipsToShoot = userOcean.checkIfShotCorrect(x, y);
        System.out.println("\nYour board: ");
        userOcean.printBoardView();
    }



    
    


}