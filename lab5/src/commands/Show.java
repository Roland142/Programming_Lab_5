package commands;

import managers.CollectionManager;

/**
 * Команда {@code show} — выводит все элементы коллекции в строковом представлении.
 */
public class Show extends Command{
    private final CollectionManager collectionManager;

    /**
     * @param collectionManager менеджер коллекции
     */
    public Show(CollectionManager collectionManager){
        super("show");
        this.collectionManager = collectionManager;
    }

    /**
     * Выводит все элементы коллекции.
     *
     * @param args не используется
     */
    @Override
    public void execute(String args){
        collectionManager.show();
    }
}
