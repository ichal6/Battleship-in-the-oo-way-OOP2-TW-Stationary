import java.util.ArrayList;

public class Ocean {
    int boardLimit = 10;
    Square[][] board;
    ArrayList<Ship> ships;

    Ocean(){
        ships = new ArrayList<Ship>();
        board = new Square[boardLimit][boardLimit];
        initializeBoard();
    }

    private void initializeBoard(){
        for(int x = 0; x < boardLimit; x++){
            for(int y = 0; y < boardLimit; y++){
                board[x][y] = new Square();
            }
        }
    }

    public void addShip(int x, int y, int length, boolean isHorizontal){
        Square[] shipElements = new Square[length];
        if(isHorizontal){
            for(int i = 0; i < length; i++){
                shipElements[i] = board[x][y+i];
            }
        }
        else {
            for(int i = 0; i < length; i++){
                shipElements[i] = board[x+i][y];
            }
        }
        Ship ship = new Ship(shipElements);
        ships.add(ship);
    }


    public void printBoard(){
        for(int x = 0; x < boardLimit; x++){
            for(int y = 0; y < boardLimit; y++){
                Square boardSquare = board[x][y];
                System.out.print(boardSquare);
            }
            System.out.print("\n");
        }
    }
}