package commands;

import builders.HumanBeingBuilder;
import managers.CollectionManager;
import exceptions.*;

/**
 * Команда 'remove_lower'
 * Добавляет новый элемент с заданным ключом
 */
public class RemoveLower extends Command {

    private final CollectionManager collectionManager;

    public RemoveLower(CollectionManager collectionManager){
        super("remove_lower");
        this.collectionManager = collectionManager;
    }

    /**
     * @param args аргументы команды
     * Метод запуска команды
     */
    @Override
    public void execute(String args) {
        try {
            collectionManager.removeLower(new HumanBeingBuilder().create());
            System.out.println("Объекты удалены успешно");
        } catch (InvalidDataException | EmptyCollectionException e) {
            System.err.println(e.getMessage());
        }
    }
}
