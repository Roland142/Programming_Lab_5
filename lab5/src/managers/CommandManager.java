package managers;

import commands.Command;
import java.util.HashMap;
import java.util.ArrayDeque;

/**
 * Менеджер команд.
 * Хранение и исполнение команд по имени.
 * Хранит историю выполненных команд.
 */
public class CommandManager {
    private HashMap<String, Command> commands = new HashMap<>();
    public ArrayDeque<String> lastCommands = new ArrayDeque<>();

    /**
     * Регистрирует команду под её именем.
     *
     * @param command команда для добавления
     */
    public void addCommand(Command command) {
        this.commands.put(command.getName(), command);
    }

    /**
     * Выполняет команду по имени с заданными аргументами и добавляет имя в историю команд.
     *
     * @param name имя команды
     * @param args строка аргументов
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
