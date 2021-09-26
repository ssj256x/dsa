package designpatterns.decorator;

public class AdventureBike extends BikeDecorator {

    public AdventureBike(Bike bike) {
        super(bike);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("---------------\n Adding Adventure Components \n---------------");
        System.out.println("Added long travel suspension");
        System.out.println("Added torquey engine");
        System.out.println("Cost : " + this.price());
    }

    @Override
    public double price() {
        return super.price() + 100;
    }
}
