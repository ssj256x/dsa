package designpatterns.factory;

public class RentalCar implements Car {
    @Override
    public void buildBody() {
        System.out.println("Rental build body");
    }

    @Override
    public void buildEngine() {
        System.out.println("Rental build engine");
    }

    @Override
    public void buildTires() {
        System.out.println("Rental build tires");
    }
}
