package managers;

import interfaces.Reader;
import java.util.Scanner;

public class ManualInput implements Reader {
    private static final Scanner userScanner = UserScanner.getUserScanner();

    @Override
    public String nextLine() {
        return userScanner.nextLine();
    }
}

