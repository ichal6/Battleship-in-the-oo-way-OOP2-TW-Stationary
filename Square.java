public class Square {
    private boolean isShipPart;
    private boolean isShotCorrect;
    private boolean isShotIncorrect;
    private int x, y;
    

    Square(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return (isShipPart) ? "X" : "-";
    }

    public void setIsShipPart(){
        isShipPart = true;
    }

    public void setIsShotCorrect(){
        isShotCorrect = true;
    }

    public void setIsShotIncorrect(){
        isShotIncorrect = true;
    }

    public String toStringView(){
        String content = "";
        if (isShotCorrect){
            content = "X";
        }
        else if(isShotIncorrect){
            content = "O";
        }
        else{
            content = "-";
        }
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