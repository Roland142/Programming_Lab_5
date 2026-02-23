package exceptions;

public class EmptyCollectionException extends RuntimeException {
    public EmptyCollectionException() {
        super("Коллекция пуста");
    }
}
