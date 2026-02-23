package commands;

import managers.CollectionManager;
import exceptions.*;

/**
 * Команда 'remove_all_by_minutes_of_waiting'
 * Добавляет новый элемент с заданным ключом
 */
public class RemoveAllByMinutesOfWaiting extends Command {
    private final CollectionManager collectionManager;
    public RemoveAllByMinutesOfWaiting(CollectionManager collectionManager){
        super("remove_all_by_minutes_of_waiting");
        this.collectionManager = collectionManager;
    }


    /**
     * @param args аргументы команды
     * Метод запуска команды
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
