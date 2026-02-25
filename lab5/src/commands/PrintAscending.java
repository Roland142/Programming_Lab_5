package commands;

import managers.CollectionManager;
import exceptions.EmptyCollectionException;

/**
 * Команда print_ascending — выводит элементы коллекции в порядке возрастания (сортировка по name).
 */
public class PrintAscending extends Command {
    private final CollectionManager collectionManager;

    /**
     * @param collectionManager менеджер коллекции
     */
    public PrintAscending(CollectionManager collectionManager){
        super("print_ascending");
        this.collectionManager = collectionManager;
    }

    /**
     * Выводит элементы в отсортированном по возрастанию порядке. При пустой коллекции — сообщение об ошибке.
     *
     * @param args не используется
     */
    @Override
    public void execute(String args)  {
        try{
            collectionManager.printAscending();
        } catch (EmptyCollectionException e) {
            System.err.println(e.getMessage());
        }

    }
}
