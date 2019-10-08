public class Square {
    private boolean isShipPart;

    public String toString(){
        String content = (isShipPart) ? "X" : " ";
        return content;
    }
    public void setIsShipPart(){
        isShipPart = true;
    }
}