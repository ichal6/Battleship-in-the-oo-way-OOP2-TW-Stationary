
public class SinglePlayer{

    int carrierShip = 5;
    int compShipsToShoot;
    int userShipsToShoot;
    

    SinglePlayer(){
        User user = new User(true);
        User comp = new User(false);
        Ocean userOcean = new Ocean();
        Ocean compOcean = comp.makeBoardWithRandomShips();
        //dokonczyc metode
    }

    public void initGame(){
        
        System.out.println("Please provide coordinates for Carrier:");
        int x = user.getInputXGuess();
        int y = user.getInputYGuess();
        int lenght = carrierShip;
        user.addShip(x, y, lenght, user.getUserOrientation());
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
        compOcean.printBoardView();
    }

    public void compMove(){
        int x = comp.getRandomXGuess();
        int y = comp.getRandomYGuess();
        userShipsToShoot = userOcean.checkIfShotCorrect(x, y);
    }



    
    


}