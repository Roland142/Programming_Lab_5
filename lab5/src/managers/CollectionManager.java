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

public class CollectionManager {
    private TreeMap<Long, HumanBeing> collection = new TreeMap<>();
    private final LocalDate creationDate;
    public CollectionManager() {
        this.creationDate = LocalDate.now();
    }

    public TreeMap<Long, HumanBeing> getCollection() {
        return this.collection;
    }

    public void addElement(String name, Coordinates coordinates, Boolean realHero,
                           Boolean hasToothpick, double impactSpeed, String soundtrackName,
                           int minutesOfWaiting, Mood mood, Car car) throws InvalidDataException {
        HumanBeing hb = new HumanBeing(name, coordinates, realHero, hasToothpick,
                impactSpeed, soundtrackName, minutesOfWaiting, mood, car);
        collection.put(hb.getId(), hb);
    }

    public void addElement(HumanBeing hb) {
        collection.put(hb.getId(), hb);
    }

    public void update_ID() {
        long max_id = -1;
        for (HumanBeing hb: this.collection.values()) {
            max_id = hb.getId() > max_id ? hb.getId() : max_id;
        }
        HumanBeing.updateID(max_id < 0 ? 0 : max_id);
    }

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

    public void info() {
        System.out.println("Тип: " + collection.getClass());
        System.out.println("Дата инициализации: " + this.creationDate);
        System.out.println("Количество элементов " + collection.size());
    }

    public void show() {
        for (HumanBeing hb: collection.values()) {
            System.out.println(hb);
        }
    }

    public void insert(long key, HumanBeing hb) {
        collection.put(key, hb);
    }

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

    public void removeKey(long key) throws EmptyCollectionException {
        if (collection.size() == 0) {
            throw new EmptyCollectionException();
        }
        collection.remove(key);
    }

    public void clear() {
        collection.clear();
    }


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

    public boolean isIDUsed (long id) {
        for (HumanBeing hb: collection.values()) {
            if (hb.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
