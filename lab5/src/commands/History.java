package commands;

import managers.CommandManager;

/**
 * Команда {@code history} — выводит последние 12 выполненных команд (без аргументов).
 */
public class History extends Command{
    private final CommandManager commandManager;

    /**
     * @param commandManager менеджер команд (доступ к lastCommands)
     */
    public History(CommandManager commandManager) {
        super("history");
        this.commandManager = commandManager;
    }

    /**
     * Выводит имена последних 12 команд.
     *
     * @param args не используется
     */
    @Override
    public void execute(String args) {
        for (String command: commandManager.lastCommands) {
            System.out.println(command);
        }
    }
}