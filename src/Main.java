import java.util.*;

/** Member 5: Main menu and integration. */
public class Main {
    public static final List<String> results = new ArrayList<>();

    /** Safe integer input - never crashes on bad input. */
    public static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try { return Integer.parseInt(line); }
            catch (NumberFormatException e) { System.out.println("Invalid input. Please enter a whole number."); }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph();

        while (true) {
            System.out.println("\n=============================================");
            System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations\n2. Stack Operations\n3. Queue Operations");
            System.out.println("4. Linked List Operations\n5. Searching Operations\n6. Graph Operations");
            System.out.println("7. Performance Comparison\n8. Display All Results\n9. Exit");
            int choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                // TODO: replace these lines with your teammates' class/method names
                //case 1: ArrayOperations.run(sc); break;       // Member 1
                //case 2: StackOperations.run(sc); break;       // Member 2
                //case 3: QueueOperations.run(sc); break;       // Member 2
                //case 4: LinkedListOperations.run(sc); break;  // Member 3
                //case 5: SearchOperations.run(sc); break;      // Member 1
                case 6: graph.menu(sc); break;
                case 7: PerformanceAnalyzer.run(sc, graph); break;
                case 8:
                    if (results.isEmpty()) System.out.println("No results recorded yet.");
                    else { System.out.println("\n--- ALL RESULTS ---"); for (String r : results) System.out.println("- " + r); }
                    break;
                case 9: System.out.println("Goodbye!"); sc.close(); return;
                default: System.out.println("Invalid choice. Enter 1-9.");
            }
        }
    }
}
