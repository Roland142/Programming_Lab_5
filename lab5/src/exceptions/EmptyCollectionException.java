package exceptions;

/**
 * Исключение при выполнении операции над пустой коллекцией, когда коллекция должна быть непустой.
 * RuntimeException — бросается из {@link managers.CollectionManager}, ловится в командах.
 */
public class EmptyCollectionException extends RuntimeException {

    /**
     * Создаёт исключение с сообщением «Коллекция пуста».
     */
    public EmptyCollectionException() {
        super("Коллекция пуста");
    }
}
