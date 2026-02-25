package commands;

import builders.HumanBeingBuilder;
import managers.CollectionManager;
import exceptions.*;

/**
 * Команда insert key — добавляет новый элемент с заданным ключом.
 */
public class Insert extends Command {

    private final CollectionManager collectionManager;

    /**
     * @param collectionManager менеджер коллекции
     */
    public Insert(CollectionManager collectionManager){
        super("insert");
        this.collectionManager = collectionManager;
    }

    /**
     * Парсит ключ из args, запрашивает поля элемента через HumanBeingBuilder и вставляет в коллекцию.
     *
     * @param args один аргумент — ключ (long)
     */
    @Override
    public void execute(String args) {
        if (args == null || args.trim().isEmpty()) {
            System.out.println("Ошибка: Команда insert требует аргумент - ключ.");
        } else {
            try {
                long key = Long.parseLong(args.trim());
                if (collectionManager.getCollection().containsKey(key)) {
                    throw new InvalidDataException("Ключи должны быть уникальными");
                }
                collectionManager.insert(key, new HumanBeingBuilder().create());
                System.out.println("Объект добавлен успешно");
            } catch (NumberFormatException e){
                System.err.println("Ошибка: Команда insert требует аргумент типа long");
            } catch (InvalidDataException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
