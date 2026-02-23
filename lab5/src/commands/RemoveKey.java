package commands;

import managers.CollectionManager;
import exceptions.*;

/**
 * Команда {@code remove_key key} — удаляет элемент из коллекции по заданному ключу.
 */
public class RemoveKey extends Command {
    private final CollectionManager collectionManager;

    /**
     * @param collectionManager менеджер коллекции
     */
    public RemoveKey(CollectionManager collectionManager){
        super("remove_key");
        this.collectionManager = collectionManager;
    }

    /**
     * Удаляет элемент с ключом, равным args (long). При пустой коллекции выводит сообщение об ошибке.
     *
     * @param args один аргумент — ключ (long)
     */
    @Override
    public void execute(String args) {
        if (args == null || args.trim().isEmpty()) {
            System.out.println("Ошибка: Команда remove_key требует аргумент - ключ.");
        } else {
            try {
                long key = Long.parseLong(args.trim());
                collectionManager.removeKey(key);
                System.out.println("Объект удалён успешно");
            } catch (NumberFormatException e){
                System.err.println("Ошибка: Команда remove_key требует аргумент типа long");
            } catch (EmptyCollectionException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
