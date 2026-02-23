package commands;


/**
 * Команда {@code exit} — завершает программу без сохранения коллекции в файл.
 */
public class Exit extends Command {

    /**
     * Создаёт команду выхода.
     */
    public Exit(){
        super("exit");
    }

    /**
     * Завершает работу приложения (System.exit(0)).
     *
     * @param args не используется
     */
    @Override
    public void execute(String args) {

        System.exit(0);
    }
}
