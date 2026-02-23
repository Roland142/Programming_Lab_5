package commands;

import managers.CollectionManager;
import exceptions.EmptyCollectionException;

/**
 * Команда 'print_ascending'
 * Выводит значенияполя category в порядке возрастания для всех элементов коллекции
 */
public class PrintAscending extends Command {
    private final CollectionManager collectionManager;

    public PrintAscending(CollectionManager collectionManager){
        super("print_ascending");
        this.collectionManager = collectionManager;
    }

    /**
     * @param args аргументы команды
     * Метод запуска команды
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
