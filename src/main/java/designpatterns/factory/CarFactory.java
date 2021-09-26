package designpatterns.factory;

/**
 * The Factory Design Pattern is used to implement loose coupling in applications. Here we are not
 * responsible for creating the actual object rather we make a common interface and implement them.
 * Here even if the implementation of the child classes changes in the future we wont have to change the
 * all the places where these objects were implemented. Also another import fact is that we can change
 * the child class that are being returned altogether and it wont break the code
 *
 * 1. Factory design pattern provides approach to code for interface rather than implementation.
 * 2. Factory pattern removes the instantiation of actual implementation classes from client code.
 * 3. Factory pattern makes our code more robust, less coupled and easy to extend. For example, we can easily change PC class implementation because client program is unaware of this.
 * 4. Factory pattern provides abstraction between implementation and client classes through inheritance.
 */
public class CarFactory {

    private CarFactory() {
    }

    public static Car createCar(CarType type) throws Exception {
        switch (type) {
            case LUXURY:
                return new LuxuryCar();
            case RENTAL:
                return new TravelCar();
            case TRAVEL:
                return new RentalCar();
            default:
                throw new Exception("Invalid Type");
        }
    }
}
