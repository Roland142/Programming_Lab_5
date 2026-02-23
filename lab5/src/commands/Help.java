package commands;

import managers.CollectionManager;

/**
 * Команда {@code help} — выводит справку по всем доступным командам.
 */
public class Help extends Command{
    private final CollectionManager collectionManager;

    /**
     * @param collectionManager менеджер коллекции (вызов help())
     */
    public Help(CollectionManager collectionManager){
        super("help");
        this.collectionManager = collectionManager;
    }

    /**
     * Выводит список команд и их описание.
     *
     * @param args не используется
     */
    @Override
    public void execute(String args) {
        collectionManager.help();
    }
}
