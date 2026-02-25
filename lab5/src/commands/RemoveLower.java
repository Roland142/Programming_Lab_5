package commands;

import builders.HumanBeingBuilder;
import managers.CollectionManager;
import exceptions.*;

/**
 * Команда remove_lower — удаляет из коллекции все элементы, меньшие заданного.
 */
public class RemoveLower extends Command {

    private final CollectionManager collectionManager;

    /**
     * @param collectionManager менеджер коллекции
     */
    public RemoveLower(CollectionManager collectionManager){
        super("remove_lower");
        this.collectionManager = collectionManager;
    }

    /**
     * Создаёт эталонный элемент через HumanBeingBuilder и удаляет все элементы, меньшие его.
     *
     * @param args не используется
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
