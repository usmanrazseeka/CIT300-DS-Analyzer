import java.util.*;
import structures.ActionStack;

/** Member 5: Main menu and integration. */
public class Main {
    public static final List<String> results = new ArrayList<>();

    // Shared objects so data stays between menu visits
    private static final ActionStack stack = new ActionStack();          // Simrana
    private static final LinkedListManager linkedList = new LinkedListManager(); // Afra
    private static final DynamicArray array = new DynamicArray(10);      // Sahani

    /** Safe integer input - never crashes on bad input. */
    public static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try { return Integer.parseInt(line); }
            catch (NumberFormatException e) { System.out.println("Invalid input. Please enter a whole number."); }
        }
    }

    /** Safe text input - rejects empty text. */
    public static String readText(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) return line;
            System.out.println("Input cannot be empty.");
        }
    }

    private static void comingSoon(String name) {
        System.out.println(name + " module is not available yet.");
    }

    // ---------- Array submenu (uses Sahani's DynamicArray) ----------
    private static void arrayMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--------------- ARRAY OPERATIONS ------------");
            System.out.println("1. Append\n2. Insert at index\n3. Delete at index");
            System.out.println("4. Search (Linear)\n5. Display\n6. Return to Main Menu");
            int c = readInt(sc, "Enter your choice: ");
            switch (c) {
                case 1:
                    array.append(readInt(sc, "Value: "));
                    System.out.println("Value appended.");
                    break;
                case 2:
                    int idx = readInt(sc, "Index (0 to " + array.size() + "): ");
                    int val = readInt(sc, "Value: ");
                    System.out.println(array.insert(idx, val)
                            ? "Inserted. Elements shifted: " + array.lastSteps
                            : "Invalid index.");
                    break;
                case 3:
                    if (array.isEmpty()) { System.out.println("Array is empty. Nothing to delete."); break; }
                    int d = readInt(sc, "Index to delete (0 to " + (array.size() - 1) + "): ");
                    System.out.println(array.deleteAt(d)
                            ? "Deleted. Elements shifted: " + array.lastSteps
                            : "Invalid index.");
                    break;
                case 4:
                    if (array.isEmpty()) { System.out.println("Array is empty."); break; }
                    int target = readInt(sc, "Value to search: ");
                    int found = array.indexOf(target);
                    System.out.println(found >= 0 ? "Found at index " + found : "Not found");
                    System.out.println("Steps: " + array.lastSteps);
                    results.add("Array linear search for " + target + " -> steps: " + array.lastSteps);
                    break;
                case 5: array.display(); break;
                case 6: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    // ---------- Stack submenu (uses Simrana's ActionStack) ----------
    private static void stackMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--------------- STACK OPERATIONS ------------");
            System.out.println("1. Push\n2. Pop\n3. Display\n4. Return to Main Menu");
            // TODO: add Peek once ActionStack has a peekAction() method
            int c = readInt(sc, "Enter your choice: ");
            switch (c) {
                case 1:
                    String a = readText(sc, "Action to push: ");
                    stack.pushAction(a);
                    results.add("Stack push: " + a);
                    break;
                case 2: stack.popAction(); break;
                case 3: stack.displayActions(); break;
                case 4: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    // ---------- Linked List submenu (uses Afra's LinkedListManager) ----------
    private static void linkedListMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--------------- LINKED LIST OPERATIONS ------------");
            System.out.println("1. Insert\n2. Delete\n3. Display\n4. Return to Main Menu");
            // TODO: add Search once LinkedListManager has a search method
            int c = readInt(sc, "Enter your choice: ");
            switch (c) {
                case 1:
                    String e = readText(sc, "Element to insert: ");
                    linkedList.addElement(e);
                    results.add("Linked List insert: " + e);
                    break;
                case 2: linkedList.removeElement(readText(sc, "Element to delete: ")); break;
                case 3: linkedList.displayList(); break;
                case 4: return;
                default: System.out.println("Invalid choice.");
            }
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
                case 1: arrayMenu(sc); break;              // Sahani
                case 2: stackMenu(sc); break;
                case 3: comingSoon("Queue"); break;        // Simrana - not pushed yet
                case 4: linkedListMenu(sc); break;
                case 5: comingSoon("Searching"); break;    // Member 1 - not pushed yet
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