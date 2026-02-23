package builders;

import elements.Coordinates;
import exceptions.InvalidDataException;

public class CoordinatesBuilder extends Builder {
    public Coordinates create() throws InvalidDataException {
        return new Coordinates(buildDouble("x"), buildInt("y"));
    }
}
