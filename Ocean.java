import java.util.ArrayList;

public class Ocean {
    int boardLimit = 10;
    Square[][] board;
    ArrayList<Ship> ships;
    ArrayList<Square> roundsOfShip = new ArrayList<>();
    ArrayList<Square> shipOfSquares = new ArrayList<>();

    Ocean(){
        ships = new ArrayList<Ship>();
        board = new Square[boardLimit][boardLimit];
        initializeBoard();
    }

    private void initializeBoard(){
        for(int x = 0; x < boardLimit; x++){
            for(int y = 0; y < boardLimit; y++){
                board[x][y] = new Square(x, y);
            }
        }
    }

    private void addRoundsOfShip(int x, int y, int length, boolean isHorizontal){
        ;
        if (isHorizontal){
            roundsOfShip.add(board[x][y-1]);
            roundsOfShip.add(board[x][y+length]);
    
            for (int i = 0; i < length; i++){
                roundsOfShip.add(board[x-1][y+i]);
                roundsOfShip.add(board[x+1][y+i]);
            }
        }
        else{
            roundsOfShip.add(board[x-1][y]);
            roundsOfShip.add(board[x+length][y]);
            for (int i = 0; i < length; i++){
                roundsOfShip.add(board[x-i][y-1]);
                roundsOfShip.add(board[x+i][y+1]);
            }    
        }
    }


    private boolean checkIfOnLists(Square square, ArrayList<Square> roundsOfShip, ArrayList<Square> shipOfSquares){
        if (roundsOfShip.isEmpty()){
            return true;
        }
        boolean isOnShipList = shipOfSquares.contains(square);
        boolean isOnRoundsOfShipList = roundsOfShip.contains(square);

        if (isOnShipList || isOnRoundsOfShipList){
            return false;
        }
        return true;   
    }

    private boolean checkOutOfBounds(int x, int y){
        if ((x<= 0 || x >= boardLimit-1) || (y <=0 || y >= boardLimit-1) ){
            return true;
        }
        return false;
    }

    public boolean addShip(int x, int y, int length, boolean isHorizontal){
        Square[] shipElements = new Square[length];
        if(isHorizontal){
            for(int i = 0; i < length; i++){
                if (checkOutOfBounds(x, y+i)){
                    return false;
                }
                if (checkIfOnLists(board[x][y+i], roundsOfShip, shipOfSquares) == false){
                    return false;
                }
                shipElements[i] = board[x][y+i];
                shipOfSquares.add(board[x][y+i]);
            }
        }
        else {

            for(int i = 0; i < length; i++){
                if (checkOutOfBounds(x+i, y)){
                    return false;
                }
                if (checkIfOnLists(board[x+i][y], roundsOfShip, shipOfSquares) == false){
                    return false;
                }
                shipElements[i] = board[x+i][y];
                shipOfSquares.add(board[x+i][y]);
            }
        }
        Ship ship = new Ship(shipElements);
        ships.add(ship);
        addRoundsOfShip(x, y, length, isHorizontal);
        return true;
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

    public void printBoardView(){
        for(int x = 0; x < boardLimit; x++){
            for(int y = 0; y < boardLimit; y++){
                Square boardSquare = board[x][y];
                System.out.print(boardSquare.toStringView());
            }
            System.out.print("\n");
        }
    }

    public void checkIfShotCorrect(int x, int y){
        for(Square element : shipOfSquares){
            if(element.getX() == x && element.getY() == y){
                board[x][y].setIsShotCorrect();
            }
        }
        board[x][y].setIsShotIncorrect();
    }


}