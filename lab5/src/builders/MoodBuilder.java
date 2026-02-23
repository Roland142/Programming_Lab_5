package builders;

import elements.Mood;
import exceptions.InvalidDataException;

public class MoodBuilder extends Builder{
    public Mood create() throws InvalidDataException {
        System.out.println("Возможные настроения: ");
        System.out.println(java.util.Arrays.toString(Mood.values()));

        while (true) {
            String input = scanner.nextLine();
            try {
                return Mood.valueOf(input.toUpperCase());

            } catch (IllegalArgumentException e) {
                System.err.println("Такого настроения нет в списке");
            }
        }
    }
}
