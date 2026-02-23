package builders;

import interfaces.Reader;
import managers.FileMod;
import managers.ManualInput;
import managers.ScriptExecutorManager;

/**
 * Класс для ввода определенных данных
 */
public abstract class Builder {
    protected final Reader scanner;

    public Builder() {
        this.scanner = (FileMod.isFileMod) ? new ScriptExecutorManager() : new ManualInput();
    }

    /**
     * @param name запрашиваемый ввод
     * @return возвращает введенную пользователем строку
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
     * @param name запрашиваемый ввод
     * @return возвращает введенное пользователем число типа Double
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

    public Boolean buildBoolean(String name) {
        String input;
        System.out.println("Введите " + name);
        input = scanner.nextLine();
        return Boolean.parseBoolean(input);
        }


    /**
     * @param name запрашиваемый ввод
     * @return возвращает введенное пользователем число типа Long
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
     * @param name запрашиваемый ввод
     * @return возвращает введенное пользователем число типа int
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