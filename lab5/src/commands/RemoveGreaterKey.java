package commands;

import managers.CollectionManager;
import exceptions.*;

/**
 * Команда 'remove_greater_key'
 * Добавляет новый элемент с заданным ключом
 */
public class RemoveGreaterKey extends Command {
    private final CollectionManager collectionManager;
    public RemoveGreaterKey(CollectionManager collectionManager){
        super("remove_greater_key");
        this.collectionManager = collectionManager;
    }


    /**
     * @param args аргументы команды
     * Метод запуска команды
     */
    @Override
    public void execute(String args) {
        if (args == null || args.trim().isEmpty()) {
            System.out.println("Ошибка: Команда remove_greater_key требует аргумент - ключ.");
        } else {
            try {
                long key = Long.parseLong(args.trim());
                collectionManager.removeGreaterKey(key);
                System.out.println("Объекты удалены успешно");
            } catch (NumberFormatException e){
                System.err.println("Ошибка: Команда remove_greater_key требует аргумент типа long");
            } catch (EmptyCollectionException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
