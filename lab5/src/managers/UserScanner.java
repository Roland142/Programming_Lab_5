package managers;

import java.util.Scanner;

/**
 * Единый экземпляр {@link java.util.Scanner} для ввода с консоли.
 * Используется {@link ManualInput} и при необходимости может быть подменён (тесты, скрипты).
 */
public class UserScanner {
    /** Сканер стандартного ввода */
    public static Scanner customScanner = new Scanner(System.in);

    /**
     * Возвращает общий сканер для консольного ввода.
     *
     * @return экземпляр Scanner
     */
    public static Scanner getUserScanner() {
        return customScanner;
    }
}