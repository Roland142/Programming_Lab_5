package commands;

import managers.CollectionManager;

/**
 * Команда {@code clear} — очищает коллекцию.
 */
public class Clear extends Command {
    private final CollectionManager collectionManager;

    /**
     * @param collectionManager менеджер коллекции
     */
    public Clear(CollectionManager collectionManager){
        super("clear");
        this.collectionManager = collectionManager;
    }

    /**
     * Очищает коллекцию и выводит сообщение об успехе.
     *
     * @param args не используется
     */
    @Override
    public void execute(String args) {
        collectionManager.clear();
        System.out.println("Коллекция очищена успешно");
    }
}
