package commands;

import managers.FileManager;

/**
 * Команда {@code save} — сохраняет коллекцию в CSV-файл (путь задаётся при создании команды).
 */
public class Save extends Command {

    private FileManager fileManager;
    private final String file_path;

    /**
     * @param fileManager менеджер файла для записи
     * @param file_path путь к файлу для сохранения
     */
    public Save(FileManager fileManager, String file_path){
        super("save");
        this.fileManager = fileManager;
        this.file_path = file_path;
    }

    /**
     * Записывает коллекцию в файл и выводит сообщение об успехе.
     *
     * @param args не используется
     */
    @Override
    public void execute(String args) {
            fileManager.saveObjects(file_path);
            System.out.println("Объекты успешно сохранены");
    }
}
