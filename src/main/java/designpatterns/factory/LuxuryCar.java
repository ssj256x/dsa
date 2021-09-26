package designpatterns.factory;

public class LuxuryCar implements Car {
    @Override
    public void buildBody() {
        System.out.println("Luxury build body");
    }

    @Override
    public void buildEngine() {
        System.out.println("Luxury build engine");
    }

    @Override
    public void buildTires() {
        System.out.println("Luxury build tires");
    }
}
