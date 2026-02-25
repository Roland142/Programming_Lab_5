package exceptions;

/**
 * Исключение при некорректных данных
 */
public class InvalidDataException extends Exception {

    /**
     * Создаёт исключение с заданным сообщением.
     *
     * @param message текст сообщения об ошибке
     */
    public InvalidDataException(String message) {
        super(message);
    }
}
