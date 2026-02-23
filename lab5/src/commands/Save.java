package commands;

import managers.FileManager;

/**
 * Команда 'save'
 * Позволяет сохранить содержимое коллекции в файл
 */
public class Save extends Command {

    private FileManager fileManager;

    private final String file_path;

    public Save(FileManager fileManager, String file_path){
        super("save");
        this.fileManager = fileManager;
        this.file_path = file_path;
    }


    /**
     * @param args аргументы команды
     * Метод запуска команды
     */
    @Override
    public void execute(String args) {
            fileManager.saveObjects(file_path);
            System.out.println("Объекты успешно сохранены");
    }
}
