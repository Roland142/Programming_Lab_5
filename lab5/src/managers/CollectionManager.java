package managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import builders.HumanBeingBuilder;
import exceptions.EmptyCollectionException;
import exceptions.InvalidDataException;
import elements.*;
import java.time.LocalDate;

/**
 * Менеджер коллекции элементов {@link elements.HumanBeing}.
 * Хранит данные в {@link java.util.TreeMap} (ключ — long, значение — HumanBeing), обеспечивает добавление, удаление,
 * обновление и вывод. При операциях над пустой коллекцией (где это недопустимо) бросает {@link exceptions.EmptyCollectionException}.
 */
public class CollectionManager {
    private TreeMap<Long, HumanBeing> collection = new TreeMap<>();
    private final LocalDate creationDate;

    /**
     * Создаёт менеджер с пустой коллекцией и фиксирует дату инициализации.
     */
    public CollectionManager() {
        this.creationDate = LocalDate.now();
    }

    /**
     * Возвращает ссылку на коллекцию (ключ — long, значение — HumanBeing).
     *
     * @return текущая коллекция
     */
    public TreeMap<Long, HumanBeing> getCollection() {
        return this.collection;
    }

    /**
     * Создаёт новый HumanBeing по переданным полям и добавляет его в коллекцию (ключ = id элемента).
     *
     * @param name имя
     * @param coordinates координаты
     * @param realHero признак «настоящий герой»
     * @param hasToothpick наличие зубочистки
     * @param impactSpeed скорость удара
     * @param soundtrackName название саундтрека
     * @param minutesOfWaiting минуты ожидания
     * @param mood настроение
     * @param car машина
     * @throws InvalidDataException если данные не проходят валидацию
     */
    public void addElement(String name, Coordinates coordinates, Boolean realHero,
                           Boolean hasToothpick, double impactSpeed, String soundtrackName,
                           int minutesOfWaiting, Mood mood, Car car) throws InvalidDataException {
        HumanBeing hb = new HumanBeing(name, coordinates, realHero, hasToothpick,
                impactSpeed, soundtrackName, minutesOfWaiting, mood, car);
        collection.put(hb.getId(), hb);
    }

    /**
     * Добавляет готовый объект HumanBeing в коллекцию (ключ = id элемента).
     *
     * @param hb добавляемый объект
     */
    public void addElement(HumanBeing hb) {
        collection.put(hb.getId(), hb);
    }

    /**
     * Обновляет статический счётчик id в HumanBeing по максимальному id в коллекции.
     * Вызывать после загрузки из файла, чтобы новые элементы получали корректные id.
     */
    public void update_ID() {
        long max_id = -1;
        for (HumanBeing hb: this.collection.values()) {
            max_id = hb.getId() > max_id ? hb.getId() : max_id;
        }
        HumanBeing.updateID(max_id < 0 ? 0 : max_id);
    }

    /**
     * Выводит в консоль справку по всем доступным командам.
     */
    public void help() {
        System.out.println("Доступные команды:\n" +
                "help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "insert null {element} : добавить новый элемент с заданным ключом\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_key null : удалить элемент из коллекции по его ключу\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "history : вывести последние 12 команд (без их аргументов)\n" +
                "remove_greater_key null : удалить из коллекции все элементы, ключ которых превышает заданный\n" +
                "remove_all_by_minutes_of_waiting minutesOfWaiting : удалить из коллекции все элементы, значение поля minutesOfWaiting которого эквивалентно заданному\n" +
                "print_ascending : вывести элементы коллекции в порядке возрастания\n" +
                "print_field_ascending_impact_speed : вывести значения поля impactSpeed всех элементов в порядке возрастания\n");
    }

    /**
     * Выводит тип коллекции, дату инициализации и количество элементов.
     */
    public void info() {
        System.out.println("Тип: " + collection.getClass());
        System.out.println("Дата инициализации: " + this.creationDate);
        System.out.println("Количество элементов " + collection.size());
    }

    /**
     * Выводит в консоль все элементы коллекции в строковом представлении.
     */
    public void show() {
        for (HumanBeing hb: collection.values()) {
            System.out.println(hb);
        }
    }

    /**
     * Вставляет элемент в коллекцию по заданному ключу.
     *
     * @param key ключ (может не совпадать с id элемента)
     * @param hb добавляемый объект
     */
    public void insert(long key, HumanBeing hb) {
        collection.put(key, hb);
    }

    /**
     * Обновляет элемент с заданным id через интерактивный ввод (HumanBeingBuilder.update).
     *
     * @param id id элемента для обновления
     * @throws EmptyCollectionException если коллекция пуста
     * @throws InvalidDataException если введённые при обновлении данные невалидны
     */
    public void update(long id) throws InvalidDataException, EmptyCollectionException {
        if (collection.size() == 0) {
            throw new EmptyCollectionException();
        }
        for (Map.Entry<Long, HumanBeing> entry : collection.entrySet()) {
            Long key = entry.getKey();
            HumanBeing value = entry.getValue();
            if (value.getId() == id) {
                collection.put(key, new HumanBeingBuilder().update(value));
            }
        }
    }

    /**
     * Удаляет элемент по ключу.
     *
     * @param key ключ удаляемого элемента
     * @throws EmptyCollectionException если коллекция пуста
     */
    public void removeKey(long key) throws EmptyCollectionException {
        if (collection.size() == 0) {
            throw new EmptyCollectionException();
        }
        collection.remove(key);
    }

    /**
     * Очищает коллекцию.
     */
    public void clear() {
        collection.clear();
    }

    /**
     * Удаляет все элементы, меньшие заданного (сравнение по compareTo).
     *
     * @param hb эталонный объект
     * @throws EmptyCollectionException если коллекция пуста
     */
    public void removeLower(HumanBeing hb) throws EmptyCollectionException {
        if (collection.size() == 0) {
            throw new EmptyCollectionException();
        }
        TreeMap<Long, HumanBeing> newCollection = new TreeMap<>();
        this.collection.forEach((key, value) -> {
            if (value.compareTo(hb) >= 0) {
                newCollection.put(key, value);
            }
        });
        this.collection = newCollection;
    }

    /**
     * Удаляет все элементы, ключ которых больше заданного.
     *
     * @param akey граничный ключ (остаются элементы с ключом &lt;= akey)
     * @throws EmptyCollectionException если коллекция пуста
     */
    public void removeGreaterKey(long akey) throws EmptyCollectionException {
        if (collection.size() == 0) {
            throw new EmptyCollectionException();
        }
        TreeMap<Long, HumanBeing> newCollection = new TreeMap<>();
        this.collection.forEach((key, value) -> {
            if (key <= akey) {
                newCollection.put(key, value);
            }
        });
        this.collection = newCollection;
    }

    /**
     * Удаляет все элементы с заданным значением minutesOfWaiting.
     *
     * @param minuts значение поля minutesOfWaiting для удаляемых элементов
     * @throws EmptyCollectionException если коллекция пуста
     */
    public void removeAllByMinutesOfWaiting(int minuts) throws EmptyCollectionException {
        if (collection.size() == 0) {
            throw new EmptyCollectionException();
        }
        TreeMap<Long, HumanBeing> newCollection = new TreeMap<>();
        for (Map.Entry<Long, HumanBeing> entry: collection.entrySet()) {
            long key = entry.getKey();
            HumanBeing value = entry.getValue();
            if (value.getMinutesOfWaiting() != minuts) {
                newCollection.put(key, value);
            }
        }
        this.collection = newCollection;
    }

    /**
     * Выводит элементы в порядке возрастания (сортировка по compareTo).
     *
     * @throws EmptyCollectionException если коллекция пуста
     */
    public void printAscending() throws EmptyCollectionException {
        if (collection.size() == 0) {
            throw new EmptyCollectionException();
        }
        List<HumanBeing> sortedValues = new ArrayList<>(collection.values());
        Collections.sort(sortedValues);
        for (HumanBeing hb: sortedValues) {
            System.out.println(hb);
        }
    }

    /**
     * Выводит значения поля impactSpeed всех элементов в порядке возрастания.
     *
     * @throws EmptyCollectionException если коллекция пуста
     */
    public void printFieldAscendingImpactSpeed() throws EmptyCollectionException {
        if (collection.size() == 0) {
            throw new EmptyCollectionException();
        }
        List<Double> sortedSpeeds = new ArrayList<>();
        for (HumanBeing hb: collection.values()) {
            sortedSpeeds.add(hb.getImpactSpeed());
        }
        Collections.sort(sortedSpeeds);
        for (Double speed: sortedSpeeds) {
            System.out.println(speed);
        }
    }

    /**
     * Проверяет, занят ли уже такой id в коллекции (по полю id элементов).
     *
     * @param id проверяемый идентификатор
     * @return true, если хотя бы один элемент имеет данный id
     */
    public boolean isIDUsed (long id) {
        for (HumanBeing hb: collection.values()) {
            if (hb.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
