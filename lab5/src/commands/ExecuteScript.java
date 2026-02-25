package commands;
import managers.CommandManager;
import managers.FileMod;
import managers.ScriptExecutorManager;
import java.io.*;
import java.util.NoSuchElementException;


/**
 * Команда execute_script file_name — выполняет команды из указанного файла построчно.
 * Поддерживает вложенные вызовы; рекурсия по одному и тому же пути блокируется.
 */
public class ExecuteScript extends Command {

    private final CommandManager commandManager;

    /**
     * @param commandManager менеджер команд для выполнения строк скрипта
     */
    public ExecuteScript(CommandManager commandManager) {
        super("execute_script");
        this.commandManager = commandManager;
    }

    /**
     * Открывает файл по пути args, переключает ввод в режим файла и выполняет каждую строку как команду.
     *
     * @param args путь к файлу скрипта
     */
    @Override
    public void execute(String args) {
        String path = args.trim();
        try {
            FileMod.setFileMod(true);
            ScriptExecutorManager.pushFile(path);
            for (String line = ScriptExecutorManager.readfile(); line != null; line = ScriptExecutorManager.readfile()) {
                try{
                    String[] command = (line + " ").split(" ", 2);
                    if (command[0].isBlank()) return;
                    if (command[0].equals("execute_script")) {
                        if (ScriptExecutorManager.fileReapeting(command[1])){
                            System.err.println("Найдена рекурсия при выполнении команды execute_script");
                            continue;
                        }
                    }
                    System.out.println("Выполнение команды " + command[0]);
                    commandManager.execute(command[0], command[1]);
                } catch (NoSuchElementException e) { }
            }
            ScriptExecutorManager.popfile();
        }
        catch (FileNotFoundException fileNotFoundException){
            System.err.println("Такого файла не существует");
        } catch (IOException e) {
            System.err.println("Ошибка ввода вывода");
        } catch (NoSuchElementException e) { }
        FileMod.setFileMod(false);
    }
}
