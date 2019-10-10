import java.util.concurrent.TimeUnit;

public class Simulation{

    int comp1ShipsToShoot = 17;
    int comp2ShipsToShoot = 17;
    User comp1 = new User(false);
    User comp2 = new User(false);
    Ocean comp1Ocean = comp1.makeBoardWithRandomShips();
    Ocean comp2Ocean = comp2.makeBoardWithRandomShips();

    public void game(){
        while (comp1ShipsToShoot > 0 && comp2ShipsToShoot >0){
            System.out.println("Computer 1 shoots:");
            comp1Move();
            try{
                TimeUnit.SECONDS.sleep(1);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            System.out.println("Computer 2 shoots:");
            comp2Move();
            try{
                TimeUnit.SECONDS.sleep(1);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }

        }
    }


    public void comp1Move(){
        int x = comp1.getRandomXGuess();
        int y = comp1.getRandomYGuess();
        comp2ShipsToShoot = comp2Ocean.checkIfShotCorrect(x, y);
        System.out.println("\nComputer 2 board: ");
        comp2Ocean.printBoardView();
    }

    public void comp2Move(){
        int x = comp2.getRandomXGuess();
        int y = comp2.getRandomYGuess();
        comp1ShipsToShoot = comp1Ocean.checkIfShotCorrect(x, y);
        System.out.println("\nComputer 1 board: ");
        comp1Ocean.printBoardView();
    }


}