package managers;

import interfaces.Reader;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayDeque;

/**
 Класс для хранения файл менеджера для команды execute
 */
public class ScriptExecutorManager implements Reader {
    private static final ArrayDeque<String> filepaths = new ArrayDeque<>();
    private static final ArrayDeque<Scanner> reader = new ArrayDeque<>();

    /**
     * @return Достает первый элемент из очереди и читает его
     * @throws IOException ошибка чтения файла
     */
    public static String readfile() throws IOException {
        return reader.getFirst().nextLine();
    }

    /**
     * Добавляет содержимое файла и путь к файлу в очереди
     * @param file_path путь к файлу
     * @throws FileNotFoundException файл не найден
     */
    public static void pushFile(String file_path) throws FileNotFoundException {
        File file = new File(file_path);
        reader.push(new Scanner(file));
        filepaths.push(file_path);
    }

    /**
     * @throws IOException
     */
    public static void popfile() throws IOException {
        reader.getFirst().close();
        reader.pop();
        filepaths.pop();
    }

    public static boolean fileReapeting(String filepath) {
        String absolutePath = new File(filepath).getAbsolutePath();
        return filepaths.contains(absolutePath);
    }

    @Override
    public String nextLine() {
        try {
            return readfile();
        } catch (IOException e) {
            return "";
        }
    }
}
