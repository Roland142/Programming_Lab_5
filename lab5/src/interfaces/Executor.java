package interfaces;

/**
 * Интерфейс выполнения команды с аргументами.
 * Реализуется всеми командами ({@link commands.Command}).
 */
public interface Executor {

    /**
     * Выполняет команду с заданными аргументами.
     *
     * @param args строка аргументов (может быть пустой или null в зависимости от команды)
     */
    void execute(String args);
}
