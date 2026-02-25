package builders;

import elements.Mood;
import exceptions.InvalidDataException;

/**
 * Строит значение {@link elements.Mood} по вводу пользователя (консоль или скрипт).
 * При неверном значении выводит сообщение и переспрашивает.
 */
public class MoodBuilder extends Builder {

    /**
     * Выводит список допустимых настроений и запрашивает строку до тех пор, пока ввод не совпадёт с константой Mood.
     *
     * @return выбранное настроение
     * @throws InvalidDataException в текущей реализации не бросается (используется цикл с переспросом)
     */
    public Mood create() throws InvalidDataException {
        System.out.println("Возможные настроения: ");
        System.out.println(java.util.Arrays.toString(Mood.values()));

        while (true) {
            String input = scanner.nextLine();
            if (input == null || input.trim().isEmpty())
                return null;
            try {
                return Mood.valueOf(input.toUpperCase());

            } catch (IllegalArgumentException e) {
                System.err.println("Такого настроения нет в списке");
            }
        }
    }
}
