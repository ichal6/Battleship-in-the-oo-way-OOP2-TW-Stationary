import java.util.Random;
import java.util.Scanner;

public class User
{
    private boolean isHuman;
    Random rand = new Random();
    Scanner input = new Scanner(System.in);


    public User(boolean isHuman)
    {
        this.isHuman = isHuman;
    }


    public boolean getIsHuman()
    {
        return isHuman;
    }


    public int getRandomXGuess()
    {
        int x = rand.nextInt(10);
        return x; 
    }


    public int getRandomYGuess()
    {
        int y = rand.nextInt(10);
        return y;  
    }


    public int getInputXGuess()
    {
        System.out.println("Please provide a row number: ");
        int x = input.nextInt();
        return x;
    }

    public int getInputYGuess()
    {
        System.out.println("Please provide a column number: ");
        int y = input.nextInt();
        return y;
    }

    public Ocean makeBoardWithRandomShips()
    {
        boolean successfullyAdded;
        Ocean randomShipsOcean = new Ocean();
        int x;
        int y;
        boolean isHorizontal;

        int[] shipTypes = {5, 4, 3, 3, 2};

        for( int element : shipTypes){
            do{
                x = rand.nextInt(10);
                y = rand.nextInt(10);
    
                isHorizontal = rand.nextBoolean();
                successfullyAdded = randomShipsOcean.addShip(x, y, element, isHorizontal);
            }
            while(successfullyAdded == false);
        }
        return randomShipsOcean;
    }

    public boolean getUserOrientation(){
        System.out.println("Ship horizontal? (Y)es or (N)o");
        String orientation = input.nextLine();
        if (orientation.equalsIgnoreCase("y")){ 
            return true;
        }
        return false;
    }



}