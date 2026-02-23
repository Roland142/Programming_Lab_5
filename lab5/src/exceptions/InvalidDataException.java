package exceptions;

/**
 * Исключение, отвечающее за некорректные параметры
 */
public class InvalidDataException extends Exception {

    public InvalidDataException(String message) {
        super(message);
    }
}
