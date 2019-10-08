public class Ship{

    Ship(Square[] shipElements){
        for (Square element: shipElements){
            element.setIsShipPart();
        }
    }
}