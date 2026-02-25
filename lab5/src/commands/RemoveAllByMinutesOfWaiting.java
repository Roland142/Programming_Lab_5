package commands;

import managers.CollectionManager;
import exceptions.*;

/**
 * Команда remove_all_by_minutes_of_waiting minutesOfWaiting — удаляет все элементы с заданным значением поля minutesOfWaiting.
 */
public class RemoveAllByMinutesOfWaiting extends Command {
    private final CollectionManager collectionManager;

    /**
     * @param collectionManager менеджер коллекции
     */
    public RemoveAllByMinutesOfWaiting(CollectionManager collectionManager){
        super("remove_all_by_minutes_of_waiting");
        this.collectionManager = collectionManager;
    }

    /**
     * Удаляет элементы, у которых minutesOfWaiting совпадает с args (int).
     *
     * @param args один аргумент — значение minutesOfWaiting (int)
     */
    @Override
    public void execute(String args) {
        if (args == null || args.trim().isEmpty()) {
            System.out.println("Ошибка: Команда remove_all_by_minutes_of_waiting требует аргумент - значение minutes_of_waiting.");
        } else {
            try {
                int minuts = Integer.parseInt(args.trim());
                collectionManager.removeAllByMinutesOfWaiting(minuts);
                System.out.println("Объекты удалены успешно");
            } catch (NumberFormatException e){
                System.err.println("Ошибка: Команда remove_all_by_minutes_of_waiting требует аргумент типа int");
            } catch (EmptyCollectionException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
