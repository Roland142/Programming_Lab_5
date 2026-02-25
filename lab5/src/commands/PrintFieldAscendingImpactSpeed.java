package commands;

import managers.CollectionManager;
import exceptions.EmptyCollectionException;

/**
 * Команда print_field_ascending_impact_speed — выводит значения поля impactSpeed всех элементов в порядке возрастания.
 */
public class PrintFieldAscendingImpactSpeed extends Command {
    private final CollectionManager collectionManager;

    /**
     * @param collectionManager менеджер коллекции
     */
    public PrintFieldAscendingImpactSpeed(CollectionManager collectionManager){
        super("print_field_ascending_impact_speed");
        this.collectionManager = collectionManager;
    }

    /**
     * Выводит impactSpeed всех элементов, отсортированные по возрастанию. При пустой коллекции — сообщение об ошибке.
     *
     * @param args не используется
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
