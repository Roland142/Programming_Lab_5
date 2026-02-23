package elements;

/**
 * Машина (поле может быть null).
 */
public class Car {
    private String name;

    public Car() {
        this.name = null;
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
