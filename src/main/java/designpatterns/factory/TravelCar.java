package designpatterns.factory;

public class TravelCar implements Car {
    @Override
    public void buildBody() {
        System.out.println("Travel build body");
    }

    @Override
    public void buildEngine() {
        System.out.println("Travel build engine");
    }

    @Override
    public void buildTires() {
        System.out.println("Travel build tires");
    }
}
