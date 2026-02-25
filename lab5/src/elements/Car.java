package elements;

/**
 * Машина — поле элемента коллекции (может быть null).
 */
public class Car {
    private String name;

    /**
     * Создаёт машину с заданным именем.
     *
     * @param name название/имя машины (может быть null)
     */
    public Car(String name) {
        this.name = name;
    }

    /**
     * Возвращает имя машины.
     *
     * @return имя (может быть null)
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя машины.
     *
     * @param name новое имя (может быть null)
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
