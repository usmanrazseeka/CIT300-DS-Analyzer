import java.util.Scanner;

/** Central place for safe, validated console input. */
public class InputHelper {
    private static final Scanner SC = new Scanner(System.in);

    private static String readLine(String prompt) {
        System.out.print(prompt);
        if (!SC.hasNextLine()) {
            System.out.println("\nInput ended. Exiting.");
            System.exit(0);
        }
        return SC.nextLine().trim();
    }

    /** Reads a whole number, repeating until the input is valid. */
    public static int readInt(String prompt) {
        while (true) {
            String line = readLine(prompt);
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("  [!] Invalid input. Please enter a whole number.");
            }
        }
    }

    /** Reads a whole number within [min, max]. */
    public static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int v = readInt(prompt);
            if (v >= min && v <= max) return v;
            System.out.println("  [!] Please enter a number between " + min + " and " + max + ".");
        }
    }

    /** Reads a non-empty string without spaces (used for vertex names). */
    public static String readWord(String prompt) {
        while (true) {
            String s = readLine(prompt);
            if (!s.isEmpty() && !s.contains(" ")) return s;
            System.out.println("  [!] Input must be non-empty and contain no spaces.");
        }
    }
}
