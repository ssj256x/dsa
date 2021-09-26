package designpatterns.decorator;

/**
 * Decorator design pattern is a Structural design pattern whose primary focus is to customize object creation
 * during runtime. Lets say we have a lot of different features than the application can provide. And we want
 * to pick and choose which features we want to apply. Not all features might be chosen. So to deal with
 * this object creation at runtime we need pattern that would allow us to remove complex if-else logic and
 * come to a simpler solution.
 * <p>
 * This is how we implement a solution.
 * <p>
 * 1. We have a basic interface {@link Bike} which has the functionality we want to get implemented
 * 2. We then implement this with a class called {@link BasicBike} and implement the Basic functionality
 * every bike will have.
 * 3. We then create a Decorator class that will have an instance variable of type {@link Bike} and we will
 * initialize it with a constructor.
 * 4. This Decorator class will call the same methods from the instantiated variable within the implementation
 * of the Bike class' method.
 * 5. We will now provide concrete classes that will extend this Decorator class and will initialize the
 * super constructor, i.e. the super class' constructor
 * 6. The concrete implementation can build over the functionality of the super class now in their own way.
 * 7. In our implementation class {@link DecoratorTest} we are now free to choose whichever object's features
 * we want and can provide them in any order. It kind of forms a "pipeline" of features.
 *
 * Since we are Decorating a base implementation of {@link Bike} with the Decorator extended concrete
 * implementations, this patter is called the Decorator Pattern.
 */
public class BikeDecorator implements Bike {

    protected Bike bike;

    public BikeDecorator(Bike bike) {
        this.bike = bike;
    }

    @Override
    public void assemble() {
        this.bike.assemble();
    }

    @Override
    public double price() {
        return this.bike.price();
    }
}
