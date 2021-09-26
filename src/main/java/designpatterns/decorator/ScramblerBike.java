package designpatterns.decorator;

public class ScramblerBike extends BikeDecorator {

    public ScramblerBike(Bike bike) {
        super(bike);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("---------------\n Adding Scrambler Components \n---------------");
        System.out.println("Added off road tires");
        System.out.println("Added headlight cage");
        System.out.println("Cost : " + this.price());
    }

    @Override
    public double price() {
        return super.price() + 50;
    }
}
