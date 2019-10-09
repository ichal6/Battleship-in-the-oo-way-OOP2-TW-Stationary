
public class Main{
    public static void main(String[] args){
        Ocean ocean = new Ocean();
        
        ocean.addShip(3, 6, 5, true);
        ocean.addShip(5,5,2,false);
        ocean.addShip(3,2,2,true);

        Ocean ocean2 = new Ocean();
        ocean2.addShip(5,5,2,false);
        ocean2.checkIfShotCorrect(4, 5);
        ocean2.printBoardView();

    }
}