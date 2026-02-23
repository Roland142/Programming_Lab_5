package elements;

import exceptions.InvalidDataException;

/**
 * Координаты в двумерном пространстве.
 * x должно быть больше -975 и не null, y не может быть null.
 */
public class Coordinates {
    private Double x; // > -975, не null
    private Integer y; // не null

    /**
     * Создаёт координаты с заданными x и y.
     *
     * @param x абсцисса (не null, строго больше -975)
     * @param y ордината (не null)
     * @throws InvalidDataException если значения не проходят валидацию
     */
    public Coordinates(Double x, Integer y) throws InvalidDataException {
        this.setX(x);
        this.setY(y);
    }

    /**
     * Возвращает абсциссу.
     *
     * @return x (не null, &gt; -975)
     */
    public Double getX() { return x; }

    /**
     * Устанавливает абсциссу.
     *
     * @param x значение (не null, строго больше -975)
     * @throws InvalidDataException если x null или &lt;= -975
     */
    public void setX(Double x) throws InvalidDataException {
        if (x == null || x <= -975) throw new InvalidDataException("x должно быть > -975 и не null");
        this.x = x;
    }

    /**
     * Возвращает ординату.
     *
     * @return y (не null)
     */
    public Integer getY() { return y; }

    /**
     * Устанавливает ординату.
     *
     * @param y значение (не null)
     * @throws InvalidDataException если y == null
     */
    public void setY(Integer y) throws InvalidDataException {
        if (y == null) throw new InvalidDataException("y не может быть null");
        this.y = y;
    }

    /**
     * Возвращает строковое представление координат для CSV (x;y).
     *
     * @return строка вида "x;y"
     */
    public String getCoordinates() {
        return x + ";" + y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
