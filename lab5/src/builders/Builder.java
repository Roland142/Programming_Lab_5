package builders;

import interfaces.Reader;
import managers.FileMod;
import managers.ManualInput;
import managers.ScriptExecutorManager;

/**
 * Базовый класс для пошагового ввода данных (консоль или скрипт).
 * Использует {@link interfaces.Reader} в зависимости от режима ({@link managers.FileMod}).
 * Наследники вызывают buildString, buildDouble и т.д. для запроса полей.
 */
public abstract class Builder {
    /** Источник ввода: консоль или файл скрипта */
    protected final Reader scanner;

    /**
     * Создаёт билдер и инициализирует источник ввода по текущему режиму (файл/консоль).
     */
    public Builder() {
        this.scanner = (FileMod.isFileMod) ? new ScriptExecutorManager() : new ManualInput();
    }

    /**
     * Запрашивает у пользователя непустую строку.
     *
     * @param name подпись к запросу (например, "name")
     * @return введённая строка (не пустая)
     */
    public String buildString(String name) {
        String input;
        while (true) {
            System.out.println("Введите " + name);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.err.println("Строка не может быть пустой!");
            } else {
                return input;
            }

        }
    }

    /**
     * Запрашивает число типа Double; при ошибке формата переспрашивает.
     *
     * @param name подпись к запросу
     * @return введённое число
     */
    public Double buildDouble(String name){
        String input;
        while (true) {
            System.out.println("Введите " + name);
            input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            }
            catch (NumberFormatException e){
                System.err.println("Число должно быть Double");
            }
        }
    }

    /**
     * Запрашивает значение boolean (true/false по строке).
     *
     * @param name подпись к запросу
     * @return результат Boolean.parseBoolean введённой строки
     */
    public Boolean buildBoolean(String name) {
        String input;
        System.out.println("Введите " + name);
        input = scanner.nextLine();
        return Boolean.parseBoolean(input);
        }


    /**
     * Запрашивает число типа Long; при ошибке формата переспрашивает.
     *
     * @param name подпись к запросу
     * @return введённое число
     */
    public Long buildLong(String name){
        String input;
        while (true) {
            System.out.println("Введите " + name);
            input = scanner.nextLine();
            try{
                return  Long.parseLong(input);
            }
            catch (NumberFormatException e){
                System.err.println("Число должно быть long");
            }
        }
    }

    /**
     * Запрашивает число типа int; при ошибке формата переспрашивает.
     *
     * @param name подпись к запросу
     * @return введённое число
     */
    public Integer buildInt(String name){
        String input;
        while (true) {
            System.out.println("Введите " + name);
            input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            }
            catch (NumberFormatException e){
                System.err.println("Число должно быть int");
            }
        }
    }
}