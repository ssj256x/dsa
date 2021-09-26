package designpatterns.decorator;

public class CruiserBike extends BikeDecorator {

    public CruiserBike(Bike bike) {
        super(bike);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("---------------\n Adding Cruiser Components \n---------------");
        System.out.println("Added low seat");
        System.out.println("Added relaxed ergos");
        System.out.println("Cost : " + this.price());
    }

    @Override
    public double price() {
        return super.price() + 150;
    }
}
