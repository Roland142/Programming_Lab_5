package exceptions;

/**
 * Исключение при некорректных данных (валидация полей, парсинг и т.д.).
 * Checked-исключение — объявляется в сигнатурах методов.
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
