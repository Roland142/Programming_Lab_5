package commands;

import managers.CommandManager;

/**
 * Команда 'history'
 * Выводит последние 12 команд без аргументов
 */
public class History extends Command{
    private final CommandManager commandManager;
    public History(CommandManager commandManager) {
        this.commandManager = commandManager;
        super("history");
    }

    /**
     * @param args аргументы команды
     * Метод запуска команды
     */
    @Override
    public void execute(String args) {
        for (String command: commandManager.lastCommands) {
            System.out.println(command);
        }
    }
}