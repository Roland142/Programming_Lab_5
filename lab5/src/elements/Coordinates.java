package elements;

import exceptions.InvalidDataException;

/**
 * Координаты в двумерном пространстве.
 */
public class Coordinates {
    private Double x; // > -975, не null
    private Integer y; // не null

    public Coordinates(Double x, Integer y) throws InvalidDataException {
        this.setX(x);
        this.setY(y);
    }

    public Double getX() { return x; }

    public void setX(Double x) throws InvalidDataException {
        if (x == null || x <= -975) throw new InvalidDataException("x должно быть > -975 и не null");
        this.x = x;
    }

    public Integer getY() { return y; }

    public void setY(Integer y) throws InvalidDataException {
        if (y == null) throw new InvalidDataException("y не может быть null");
        this.y = y;
    }

    public String getCoordinates() {
        return x + ";" + y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
