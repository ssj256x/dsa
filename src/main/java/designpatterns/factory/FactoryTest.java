package designpatterns.factory;

public class FactoryTest {

    public static void main(String[] args) throws Exception {

        Car luxuryCar = CarFactory.createCar(CarType.LUXURY);
        Car travelCar = CarFactory.createCar(CarType.TRAVEL);
        Car rentalCar = CarFactory.createCar(CarType.RENTAL);

        luxuryCar.buildBody();
        luxuryCar.buildEngine();
        luxuryCar.buildTires();

        System.out.println("------------");

        travelCar.buildBody();
        travelCar.buildEngine();
        travelCar.buildTires();

        System.out.println("------------");

        rentalCar.buildBody();
        rentalCar.buildEngine();
        rentalCar.buildTires();
    }
}
