package builders;

import elements.Car;
import exceptions.InvalidDataException;

/**
 * Строит объект {@link elements.Car} (имя машины) через ввод с консоли или из скрипта.
 */
public class CarBuilder extends Builder {

    /**
     * Запрашивает имя машины и создаёт Car.
     *
     * @return новый объект Car
     * @throws InvalidDataException при ошибке ввода (не используется в текущей реализации)
     */
    public Car create() throws InvalidDataException {
        return new Car(buildString("Car name"));
    }
}
