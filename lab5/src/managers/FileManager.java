package managers;

import elements.*;
import exceptions.InvalidDataException;

import java.util.Scanner;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

/**
 * Класс, отвечающий за чтение и запись содержимого коллекции в/из файла в формате CSV
 */
public class FileManager {
    private final CollectionManager collectionManager;
    private static final String SEPARATOR = ";";

    public FileManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Читает CSV файл и добавляет объекты в коллекцию
     *
     * @param file_path путь к файлу
     */
    public void addFromFile(String file_path) throws IOException, InvalidDataException {
        File file = new File(file_path);
        try (Scanner scanner = new Scanner(file)) {
            String line;

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.trim().isEmpty()) continue;

                Object[] resultparsing = parseHumanFromCsv(line);
                long key = (long) resultparsing[0];
                HumanBeing hb = (HumanBeing) resultparsing[1];

                collectionManager.insert(key, hb);
            }
        }
    }

    /**
     * Записывает коллекцию в файл в формате CSV
     *
     * @param file_path путь к файлу
     */
    public void saveObjects(String file_path) {
        try (PrintWriter writer = new PrintWriter(new File(file_path))) {
            for (Map.Entry<Long, HumanBeing> entry : collectionManager.getCollection().entrySet()) {
                long key = entry.getKey();
                HumanBeing hb = entry.getValue();
                String row = HumanToCsv(hb);
                writer.println(key + ";" + row);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    /**
     * Вспомогательный метод для конвертации объекта в строку CSV
     */
    private String HumanToCsv(HumanBeing hb) {
        return String.join(SEPARATOR,
                String.valueOf(hb.getId()),
                hb.getName(),
                hb.getCoordinates().getCoordinates(),
                hb.getCreationDate().toString(),
                String.valueOf(hb.getRealHero()),
                String.valueOf(hb.getHasToothpick()),
                String.valueOf(hb.getImpactSpeed()),
                hb.getSoundtrackName(),
                String.valueOf(hb.getMinutesOfWaiting()),
                String.valueOf(hb.getMood()),
                String.valueOf(hb.getCar()));
    }

    /**
     * Вспомогательный метод для создания объекта из строки CSV
     */
    private Object[] parseHumanFromCsv(String csvLine) throws InvalidDataException{
        String[] parts = csvLine.split(SEPARATOR);
        try {
            int bias = 0;
            long id = -1;
            Date creationDate = null;
            long key = Long.parseLong(parts[0]);
            try {
                id = Integer.parseInt(parts[1]);
                bias++;
            } catch (NumberFormatException e) {}
            String name = parts[1+bias];
            Double x = Double.parseDouble(parts[2+bias]);
            Integer y = Integer.parseInt(parts[3+bias]);
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
                creationDate = formatter.parse(parts[4+bias]);
                bias++;
            } catch (Exception e) {}
            Boolean realHero = Boolean.parseBoolean(parts[4+bias]);
            Boolean hasToothpick = Boolean.parseBoolean(parts[5+bias]);
            Double impactSpeed = Double.parseDouble(parts[6+bias]);
            String soundtrackName = parts[7+bias];
            Integer minutesOfWaiting = Integer.parseInt(parts[8+bias]);
            Mood mood = Mood.valueOf(parts[9+bias]);
            Car car = new Car(parts[10+bias]);
            HumanBeing hb = new HumanBeing(name, new Coordinates(x, y), realHero,
                    hasToothpick, impactSpeed, soundtrackName, minutesOfWaiting,
                    mood, car);
            if (id != -1) {
                if (!collectionManager.isIDUsed(id)) {
                    hb.setId(id);
                }
            }
            if (creationDate != null) {
                hb.setCreationDate(creationDate);
            }
            return new Object[] {key, hb};
        } catch (Exception e) {
            throw new InvalidDataException("Некорректные данные в файле для объекта HumanBeing");
        }
    }
}
