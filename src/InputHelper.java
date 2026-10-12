import java.util.Scanner;

/** Safe console input with validation. Use this class everywhere instead of a raw Scanner. */
public class InputHelper {
    private static final Scanner SC = new Scanner(System.in);

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SC.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a whole number.");
            }
        }
    }

    public static int readInt(String prompt, int min, int max) {
        while (true) {
            int v = readInt(prompt);
            if (v >= min && v <= max) return v;
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }

    public static String readLine(String prompt) {
        System.out.print(prompt);
        return SC.nextLine().trim();
    }
}
