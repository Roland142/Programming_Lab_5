package commands;

import managers.CollectionManager;
import exceptions.*;

/**
 * Команда 'update'
 * Добавляет новый элемент с заданным ключом
 */
public class Update extends Command {
    private final CollectionManager collectionManager;
    public Update(CollectionManager collectionManager){
        super("update");
        this.collectionManager = collectionManager;
    }


    /**
     * @param args аргументы команды
     * Метод запуска команды
     */
    @Override
    public void execute(String args) {
        if (args == null || args.trim().isEmpty()) {
            System.out.println("Ошибка: Команда update требует аргумент - id.");
        } else {
            try {
                long id = Long.parseLong(args.trim());
                collectionManager.update(id);
                System.out.println("Объект обновлён успешно");
            } catch (NumberFormatException e){
                System.err.println("Ошибка: Команда update требует аргумент типа long");
            } catch (InvalidDataException | EmptyCollectionException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
