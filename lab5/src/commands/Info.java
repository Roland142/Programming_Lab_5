package commands;

import managers.CollectionManager;

/**
 * Команда info — выводит тип коллекции, дату инициализации и количество элементов.
 */
public class Info extends Command {

    private final CollectionManager collectionManager;

    /**
     * @param collectionManager менеджер коллекции
     */
    public Info(CollectionManager collectionManager){
        super("info");
        this.collectionManager = collectionManager;
    }

    /**
     * Выводит информацию о коллекции.
     *
     * @param args не используется
     */
    @Override
    public void execute(String args){
        collectionManager.info();
    }
}