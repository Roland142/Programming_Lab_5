package builders;

import elements.Car;
import exceptions.InvalidDataException;

public class CarBuilder extends Builder {
    public Car create() throws InvalidDataException {
        return new Car(buildString("Car name"));
    }
}
