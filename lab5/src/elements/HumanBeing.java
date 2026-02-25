package elements;

import java.util.Date;
import java.util.Objects;

import exceptions.InvalidDataException;

/**
 * Элемент коллекции — описание персонажа.
 * Хранит id, имя, координаты, дату создания и остальные поля.
 * Реализует {@link Comparable} по полю id.
 */
public class HumanBeing implements Comparable<HumanBeing>{
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private Boolean hasToothpick; //Поле может быть null
    private double impactSpeed;
    private String soundtrackName; //Поле не может быть null
    private int minutesOfWaiting;
    private Mood mood; //Поле может быть null
    private Car car; //Поле может быть null
    private static long ID = 1;

    /**
     * Создаёт объект с автогенерируемыми id и creationDate и заданными полями.
     * @param name имя (не null, не пустая строка)
     * @param coordinates координаты
     * @param realHero признак «настоящий герой» (не null)
     * @param hasToothpick есть ли зубочистка
     * @param impactSpeed скорость удара
     * @param soundtrackName название саундтрека (не null)
     * @param minutesOfWaiting минуты ожидания
     * @param mood настроение (может быть null)
     * @param car машина (может быть null)
     * @throws InvalidDataException если данные не проходят валидацию
     */
    public HumanBeing(String name, Coordinates coordinates, Boolean realHero,
                      Boolean hasToothpick, double impactSpeed, String soundtrackName,
                      int minutesOfWaiting, Mood mood, Car car) throws InvalidDataException {
        this.id = ID++;
        this.setName(name);
        this.setCoordinates(coordinates);
        this.setCreationDate(new Date());
        this.setRealHero(realHero);
        this.setHasToothpick(hasToothpick);
        this.setImpactSpeed(impactSpeed);
        this.setSoundtrackName(soundtrackName);
        this.setMinutesOfWaiting(minutesOfWaiting);
        this.setMood(mood);
        this.setCar(car);
    }

    /**
     * Возвращает идентификатор объекта.
     *
     * @return id (должен быть больше 0)
     */
    public long getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор. Используется при загрузке из файла.
     *
     * @param id новое значение (должно быть больше 0)
     * @throws InvalidDataException если id <= 0
     */
    public void setId(long id) throws InvalidDataException {
        if (id <= 0) { throw new InvalidDataException("Ошибка: id должно быть больше 0"); }
        this.id = id;
    }

    /**
     * Возвращает имя персонажа.
     *
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя.
     *
     * @param name строка хотя бы из одного символа (не null)
     * @throws InvalidDataException если name null или пустая
     */
    public void setName(String name) throws InvalidDataException {
        if (name == null || name.equals("")) {throw new InvalidDataException("Ошибка: Имя должно быть строкой хотя бы из одного символа");}
        this.name = name;
    }

    /**
     * Возвращает координаты.
     *
     * @return координаты
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Устанавливает координаты.
     *
     * @param coordinates объект координат (не null)
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Возвращает дату создания.
     *
     * @return дата создания
     */
    public java.util.Date getCreationDate() {
        return creationDate;
    }

    /**
     * Устанавливает дату создания (при загрузке из файла).
     *
     * @param creationDate дата
     */
    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Возвращает признак «настоящий герой».
     *
     * @return true/false
     */
    public Boolean getRealHero() {
        return realHero;
    }

    /**
     * Устанавливает признак «настоящий герой».
     *
     * @param realHero значение
     * @throws InvalidDataException если realHero == null
     */
    public void setRealHero(Boolean realHero) throws InvalidDataException {
        if (realHero == null) {throw new InvalidDataException("Ошибка: realHero не может быть null");}
        this.realHero = realHero;
    }

    /**
     * Возвращает признак наличия зубочистки.
     *
     * @return true/false (может быть null)
     */
    public Boolean getHasToothpick() {
        return hasToothpick;
    }

    /**
     * Устанавливает признак наличия зубочистки.
     *
     * @param hasToothpick значение (может быть null)
     */
    public void setHasToothpick(Boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    /**
     * Возвращает скорость удара.
     *
     * @return скорость удара
     */
    public double getImpactSpeed() {
        return impactSpeed;
    }

    /**
     * Устанавливает скорость удара.
     *
     * @param impactSpeed значение
     */
    public void setImpactSpeed(double impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    /**
     * Возвращает название саундтрека.
     *
     * @return строка
     */
    public String getSoundtrackName() {
        return soundtrackName;
    }

    /**
     * Устанавливает название саундтрека.
     *
     * @param soundtrackName строка (не null)
     * @throws InvalidDataException если soundtrackName == null
     */
    public void setSoundtrackName(String soundtrackName) throws InvalidDataException {
        if (soundtrackName == null) {throw new InvalidDataException("Ошибка: soundtrackName не может быть null");}
        this.soundtrackName = soundtrackName;
    }

    /**
     * Возвращает минуты ожидания.
     *
     * @return количество минут
     */
    public int getMinutesOfWaiting() {
        return minutesOfWaiting;
    }

    /**
     * Устанавливает минуты ожидания.
     *
     * @param minutesOfWaiting значение
     */
    public void setMinutesOfWaiting(int minutesOfWaiting) {
        this.minutesOfWaiting = minutesOfWaiting;
    }

    /**
     * Возвращает настроение.
     *
     * @return значение перечисления (может быть null)
     */
    public Mood getMood() {
        return mood;
    }

    /**
     * Устанавливает настроение.
     *
     * @param mood значение (может быть null)
     */
    public void setMood(Mood mood) {
        this.mood = mood;
    }

    /**
     * Возвращает машину.
     *
     * @return объект Car (может быть null)
     */
    public Car getCar() {
        return car;
    }

    /**
     * Устанавливает машину.
     *
     * @param car объект (может быть null)
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Устанавливает начальное значение счётчика id для новых объектов.
     *
     * @param id следующее значение счётчика (обычно max_id + 1 или 0 для пустой коллекции)
     */
    public static void updateID(long id) {
        ID = id;
    }

    /**
     * Сравнивает объекты.
     * Сравнение идет сначала по имени (алфавитный порядок),
     * а при совпадении — по уникальному идентификатору (id).
     */
    @Override
    public int compareTo(HumanBeing other) {
        if (this == other) return 0;
        if (other == null) return 1;
        int res = this.name.compareTo(other.name);
        if (res == 0) {
            return Long.compare(this.id, other.id);
        }
        return res;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\nName: " + name +
                "\nCoordinates: " + coordinates +
                "\nCreation date: " + creationDate +
                "\nReal hero: " + realHero +
                "\nHas toothpick: " + hasToothpick +
                "\nSoundtrack name: " + soundtrackName +
                "\nImpact speed: " + impactSpeed +
                "\nMinutes of waiting : " + minutesOfWaiting +
                "\nMood : " + mood +
                "\nCar : " + car;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HumanBeing that = (HumanBeing) obj;

        return id == that.id &&
                Double.compare(that.impactSpeed, impactSpeed) == 0 &&
                minutesOfWaiting == that.minutesOfWaiting &&
                Objects.equals(name, that.name) &&
                Objects.equals(coordinates, that.coordinates) &&
                Objects.equals(realHero, that.realHero) &&
                Objects.equals(hasToothpick, that.hasToothpick) &&
                Objects.equals(soundtrackName, that.soundtrackName) &&
                mood == that.mood &&
                Objects.equals(car, that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, realHero, hasToothpick,
                impactSpeed, soundtrackName, minutesOfWaiting, mood, car);
    }
}