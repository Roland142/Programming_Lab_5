package managers;

import commands.Command;
import java.util.HashMap;
import java.util.ArrayDeque;

/**
 * Класс, отвечающий за исполнение команд
 */
public class CommandManager {
    private HashMap<String, Command> commands = new HashMap<>();
    public ArrayDeque<String> lastCommands = new ArrayDeque<>();

    /**
     * @param command команда, добавляемая в Map
     */
    public void addCommand(Command command) {
        this.commands.put(command.getName(), command);
    }

    /**
     * @param name название команды
     * @param args ее аргументы(id элемента, index коллекции и тд)
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
