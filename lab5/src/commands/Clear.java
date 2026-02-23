package commands;

import managers.CollectionManager;

/**
 * Команда 'clear'
 * Добавляет новый элемент с заданным ключом
 */
public class Clear extends Command {
    private final CollectionManager collectionManager;
    public Clear(CollectionManager collectionManager){
        super("clear");
        this.collectionManager = collectionManager;
    }


    /**
     * @param args аргументы команды
     * Метод запуска команды
     */
    @Override
    public void execute(String args) {
        collectionManager.clear();
        System.out.println("Коллекция очищена успешно");
    }
}
