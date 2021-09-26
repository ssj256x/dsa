package designpatterns.decorator;

public class DecoratorTest {

    public static void main(String[] args) {
        Bike advTourer = new AdventureBike(new EnduroBike(new BasicBike()));
        advTourer.assemble();

        System.out.println("-----------------------------------------------");

        Bike weirdBike = new CruiserBike(advTourer);
        weirdBike.assemble();
    }
}
