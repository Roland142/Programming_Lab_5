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
     * Запрашивает у пользователя строку возможно пустую.
     *
     * @param name подпись к запросу
     * @return введённая строка или null, если строка пустая
     */
    public String buildStringNullable(String name) {
        System.out.println("Введите " + name);
        String input = scanner.nextLine();
        if (input == null || input.trim().isEmpty()) return null;
        return input.trim();
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
     * Запрашивает значение boolean (обязательно не null).
     *
     * @param name подпись к запросу
     * @return результат Boolean.parseBoolean введённой строки
     */
    public Boolean buildBoolean(String name) {
        while (true) {
            System.out.println("Введите " + name);
            String input = scanner.nextLine();
            if (input == null || input.trim().isEmpty()) {
                System.err.println("Поле не может быть пустым!");
                continue;
            }
            return Boolean.parseBoolean(input);
        }
        }

    /**
     * Запрашивает значение boolean (может быть null).
     *
     * @param name подпись к запросу
     * @return результат Boolean.parseBoolean введённой строки или null, если строка пустая
     */
    public Boolean buildBooleanNullable(String name) {
        System.out.println("Введите " + name);
        String input = scanner.nextLine();
        if (input == null || input.trim().isEmpty()) return null;
        return Boolean.parseBoolean(input.trim());
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