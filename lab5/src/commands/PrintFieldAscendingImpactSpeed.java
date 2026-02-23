package commands;

import managers.CollectionManager;
import exceptions.EmptyCollectionException;

/**
 * Команда 'print_field_ascending_impact_speed'
 * Выводит значенияполя category в порядке возрастания для всех элементов коллекции
 */
public class PrintFieldAscendingImpactSpeed extends Command {
    private final CollectionManager collectionManager;

    public PrintFieldAscendingImpactSpeed(CollectionManager collectionManager){
        super("print_field_ascending_impact_speed");
        this.collectionManager=collectionManager;
    }

    /**
     * @param args аргументы команды
     * Метод запуска команды
     */
    @Override
    public void execute(String args)  {
        try{
            collectionManager.printFieldAscendingImpactSpeed();
        } catch (EmptyCollectionException e) {
            System.err.println(e.getMessage());
        }

    }
}
