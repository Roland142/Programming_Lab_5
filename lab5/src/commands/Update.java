package commands;

import managers.CollectionManager;
import exceptions.*;

/**
 * Команда update id — обновляет элемент с заданным id.
 */
public class Update extends Command {
    private final CollectionManager collectionManager;

    /**
     * @param collectionManager менеджер коллекции
     */
    public Update(CollectionManager collectionManager){
        super("update");
        this.collectionManager = collectionManager;
    }

    /**
     * Парсит id из args и запускает интерактивное обновление элемента через CollectionManager.update(id).
     *
     * @param args один аргумент — id элемента (long)
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
