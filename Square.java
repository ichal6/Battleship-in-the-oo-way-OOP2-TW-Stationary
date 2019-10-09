public class Square {
    private boolean isShipPart;
    private boolean isShotCorrect;
    private int x, y;

    Square(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        String content = (isShipPart) ? "X" : "-";
        return content;
    }

    public void setIsShipPart(){
        isShipPart = true;
    }

    public void setIsShotCorrect(){
        isShotCorrect = true;
    }

    public String toStringView(){
        String content = (isShotCorrect) ? "X" : "O";
        return content;
    }

    public boolean getIsShipPart(){
        return isShipPart;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}