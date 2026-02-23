package commands;

import interfaces.Executor;
import java.util.Objects;

/**
 * Абстрактная команда с именем и методом выполнения.
 * Реализует {@link interfaces.Executor}; наследники переопределяют {@link #execute(String)}.
 */
public abstract class Command implements Executor {
    private final String name;

    /**
     * Создаёт команду с заданным именем (используется пользователем для вызова).
     *
     * @param name имя команды
     */
    public Command(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Возвращает имя команды.
     *
     * @return имя (например, "help", "insert")
     */
    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return Objects.equals(name, command.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Выполняет команду с заданными аргументами.
     *
     * @param args строка аргументов (может быть пустой или null)
     */
    public abstract void execute(String args);
}

