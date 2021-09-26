package designpatterns.decorator;

public class BasicBike implements Bike {

    @Override
    public void assemble() {
        System.out.println("---------------\n Adding Basic Components \n---------------");
        System.out.println("Added wheels");
        System.out.println("Added handlebar");
        System.out.println("Added exhaust");
        System.out.println("Added foot pegs");
        System.out.println("Cost : " + this.price());
    }

    @Override
    public double price() {
        return 1000.0;
    }
}
