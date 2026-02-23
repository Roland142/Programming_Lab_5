package managers;

import interfaces.Reader;
import java.util.Scanner;

/**
 * Реализация {@link interfaces.Reader} для ввода с консоли.
 * Использует общий {@link UserScanner}.
 */
public class ManualInput implements Reader {
    private static final Scanner userScanner = UserScanner.getUserScanner();

    /**
     * Читает следующую строку из консоли.
     *
     * @return введённая строка
     */
    @Override
    public String nextLine() {
        return userScanner.nextLine();
    }
}

