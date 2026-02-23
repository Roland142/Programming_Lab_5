package managers;

/**
 * Флаг режима ввода: консоль или файл скрипта.
 * Используется в {@link builders.Builder} для выбора {@link interfaces.Reader}.
 */
public class FileMod {
    /** true — ввод из скрипта (execute_script), false — с консоли */
    public static boolean isFileMod = false;

    /**
     * Устанавливает режим ввода.
     *
     * @param FileMod true для режима скрипта, false для консоли
     */
    public static void setFileMod(boolean FileMod) {
        isFileMod = FileMod;
    }
}
