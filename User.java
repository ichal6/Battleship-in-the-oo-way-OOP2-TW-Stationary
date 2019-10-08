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
        Ocean randomShipsOcean = new Ocean();
        int x = rand.nextInt(10);
        int y = rand.nextInt(10);
        boolean isHorizontal = rand.nextBoolean();
        randomShipsOcean.addShip(x, y, 5, isHorizontal);


        randomShipsOcean.addShip(x, y, 4, isHorizontal);
        randomShipsOcean.addShip(x, y, 3, isHorizontal);
        randomShipsOcean.addShip(x, y, 3, isHorizontal);
        randomShipsOcean.addShip(x, y, 2, isHorizontal);

        return randomShipsOcean;
    }



}