package builders;

import elements.HumanBeing;
import exceptions.InvalidDataException;

/**
 * Строит объект {@link elements.HumanBeing} путём пошагового ввода полей (консоль или скрипт).
 */
public class HumanBeingBuilder extends Builder {

    /**
     * Создаёт новый HumanBeing, запрашивая все поля через консоль/скрипт.
     *
     * @return новый объект HumanBeing с заполненными полями
     * @throws InvalidDataException если введённые данные не проходят валидацию
     */
    public HumanBeing create() throws InvalidDataException {
        return new HumanBeing(
                buildString("name"),
                new CoordinatesBuilder().create(),
                buildBoolean("realHero"),
                buildBooleanNullable("hasToothpick"),
                buildDouble("impactSpeed"),
                buildString("soundtrackName"),
                buildInt("minutesOfWaiting"),
                new MoodBuilder().create(),
                new CarBuilder().create());
    }

    /**
     * Обновляет поля существующего HumanBeing, запрашивая новые значения.
     *
     * @param hb объект для обновления
     * @return тот же объект с обновлёнными полями
     * @throws InvalidDataException если введённые данные не проходят валидацию
     */
    public HumanBeing update(HumanBeing hb) throws InvalidDataException {
        hb.setName(buildString("name"));
        hb.setCoordinates(new CoordinatesBuilder().create());
        hb.setRealHero(buildBoolean("realHero"));
        hb.setHasToothpick(buildBooleanNullable("hasToothpick"));
        hb.setImpactSpeed(buildDouble("impactSpeed"));
        hb.setSoundtrackName(buildString("soundtrackName"));
        hb.setMinutesOfWaiting(buildInt("minutesOfWaiting"));
        hb.setMood(new MoodBuilder().create());
        hb.setCar(new CarBuilder().create());
        return hb;
    }
}
