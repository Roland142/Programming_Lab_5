package builders;

import elements.Coordinates;
import exceptions.InvalidDataException;

/**
 * Строит объект {@link elements.Coordinates} (x, y) через ввод с консоли или из скрипта.
 */
public class CoordinatesBuilder extends Builder {

    /**
     * Запрашивает x (double) и y (int), создаёт Coordinates.
     *
     * @return новый объект Coordinates
     * @throws InvalidDataException если значения не проходят валидацию (x <= -975, y = null и т.д.)
     */
    public Coordinates create() throws InvalidDataException {
        return new Coordinates(buildDouble("x"), buildInt("y"));
    }
}
