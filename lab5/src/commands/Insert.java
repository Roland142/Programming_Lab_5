package commands;

import builders.HumanBeingBuilder;
import managers.CollectionManager;
import exceptions.*;

/**
 * Команда 'insert'
 * Добавляет новый элемент с заданным ключом
 */
public class Insert extends Command {

    private final CollectionManager collectionManager;

    public Insert(CollectionManager collectionManager){
        super("insert");
        this.collectionManager = collectionManager;
    }

    /**
     * @param args аргументы команды
     * Метод запуска команды
     */
    @Override
    public void execute(String args) {
        if (args == null || args.trim().isEmpty()) {
            System.out.println("Ошибка: Команда insert требует аргумент - ключ.");
        } else {
            try {
                long key = Long.parseLong(args.trim());
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
