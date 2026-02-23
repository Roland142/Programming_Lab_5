package interfaces;

/**
 * Интерфейс ввода строк.
 * Позволяет реализовать чтение из консоли ({@link managers.ManualInput}) или из файла скрипта ({@link managers.ScriptExecutorManager}).
 */
public interface Reader {

    /**
     * Возвращает следующую строку ввода.
     *
     * @return следующая строка (без перевода строки в конце)
     */
    String nextLine();
}