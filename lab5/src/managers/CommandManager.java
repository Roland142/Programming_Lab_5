package managers;

import commands.Command;
import java.util.HashMap;
import java.util.ArrayDeque;

/**
 * Реестр и исполнение команд по имени.
 * Хранит последние 12 выполненных команд для истории.
 */
public class CommandManager {
    private HashMap<String, Command> commands = new HashMap<>();
    /** История последних 12 имён выполненных команд */
    public ArrayDeque<String> lastCommands = new ArrayDeque<>();

    /**
     * Регистрирует команду под её именем (getName()).
     *
     * @param command команда для добавления
     */
    public void addCommand(Command command) {
        this.commands.put(command.getName(), command);
    }

    /**
     * Выполняет команду по имени с заданными аргументами и добавляет имя в историю.
     *
     * @param name имя команды (как введено пользователем)
     * @param args строка аргументов (id, ключ, путь к файлу и т.д.)
     */
    public void execute(String name, String args) {
        if (lastCommands.size() > 12) {
            lastCommands.removeFirst();
        }
        Command command = commands.get(name);
        if (command == null) {
            System.out.println("Такой команды нет");
        } else {
            command.execute(args);
            lastCommands.addLast(name);
        }
    }
}
