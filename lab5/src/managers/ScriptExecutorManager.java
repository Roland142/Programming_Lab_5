package managers;

import interfaces.Reader;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayDeque;

/**
 * Чтение ввода из файла скрипта (очередь файлов для execute_script).
 * Реализует {@link interfaces.Reader}.
 */
public class ScriptExecutorManager implements Reader {
    private static final ArrayDeque<String> filepaths = new ArrayDeque<>();
    private static final ArrayDeque<Scanner> reader = new ArrayDeque<>();

    /**
     * Читает следующую строку из текущего (верхнего) файла в очереди.
     *
     * @return прочитанная строка
     * @throws IOException ошибка чтения файла
     */
    public static String readfile() throws IOException {
        return reader.getFirst().nextLine();
    }

    /**
     * Добавляет файл в начало очереди (чтение будет из этого файла).
     *
     * @param file_path путь к файлу скрипта
     * @throws FileNotFoundException если файл не найден
     */
    public static void pushFile(String file_path) throws FileNotFoundException {
        File file = new File(file_path);
        reader.push(new Scanner(file));
        filepaths.push(file_path);
    }

    /**
     * Закрывает текущий файл и удаляет его из очереди.
     *
     * @throws IOException при ошибке закрытия
     */
    public static void popfile() throws IOException {
        reader.getFirst().close();
        reader.pop();
        filepaths.pop();
    }

    /**
     * Проверяет, не выполнялся ли уже этот файл (защита от рекурсии).
     *
     * @param filepath путь к файлу
     * @return true, если файл уже в стеке выполнения
     */
    public static boolean fileReapeting(String filepath) {
        String absolutePath = new File(filepath).getAbsolutePath();
        return filepaths.contains(absolutePath);
    }

    /**
     * Возвращает следующую строку из текущего файла скрипта; при IOException — пустая строка.
     *
     * @return строка или ""
     */
    @Override
    public String nextLine() {
        try {
            return readfile();
        } catch (IOException e) {
            return "";
        }
    }
}
