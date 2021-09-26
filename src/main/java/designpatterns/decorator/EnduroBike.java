package designpatterns.decorator;

public class EnduroBike extends BikeDecorator {

    public EnduroBike(Bike bike) {
        super(bike);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("---------------\n Adding Enduro Components \n---------------");
        System.out.println("Added enduro screen");
        System.out.println("Added GPS");
        System.out.println("Cost : " + this.price());
    }

    @Override
    public double price() {
        return super.price() + 200;
    }
}
