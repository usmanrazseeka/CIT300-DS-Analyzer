
import java.util.*;
import structures.ActionStack;
import structures.ActionQueue;

/** Main menu and integration. */
public class Main {
    public static final List<String> results = new ArrayList<>();

    private static final ActionStack stack = new ActionStack();
    private static final ActionQueue queue = new ActionQueue();
    private static final LinkedListManager linkedList = new LinkedListManager();

    public static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

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

    // Stack menu
    private static void stackMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--- STACK OPERATIONS ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            int choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1: {
                    String action = readText(sc, "Action to push: ");
                    stack.pushAction(action);
                    results.add("Stack push: " + action);
                    break;
                }
                case 2:
                    stack.popAction();
                    break;
                case 3:
                    stack.peekAction();
                    break;
                case 4:
                    stack.displayActions();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Queue menu
    private static void queueMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--- QUEUE OPERATIONS ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek Front");
            System.out.println("4. Display Queue");
            System.out.println("5. Return to Main Menu");

            int choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1: {
                    String request = readText(sc, "Request to add: ");
                    queue.enqueueAction(request);
                    results.add("Queue enqueue: " + request);
                    break;
                }
                case 2:
                    queue.dequeueAction();
                    break;
                case 3:
                    queue.peekAction();
                    break;
                case 4:
                    queue.displayActions();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Linked List menu
    private static void linkedListMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--- LINKED LIST OPERATIONS ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Return to Main Menu");

            int choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1: {
                    String element = readText(sc, "Element to insert: ");
                    linkedList.addElement(element);
                    results.add("Linked List insert: " + element);
                    break;
                }
                case 2:
                    linkedList.removeElement(
                        readText(sc, "Element to delete: ")
                    );
                    break;
                case 3:
                    linkedList.displayList();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
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
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");

            int choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    comingSoon("Array");
                    break;
                case 2:
                    stackMenu(sc);
                    break;
                case 3:
                    queueMenu(sc);
                    break;
                case 4:
                    linkedListMenu(sc);
                    break;
                case 5:
                    comingSoon("Searching");
                    break;
                case 6:
                    graph.menu(sc);
                    break;
                case 7:
                    PerformanceAnalyzer.run(sc, graph);
                    break;
                case 8:
                    if (results.isEmpty()) {
                        System.out.println("No results recorded yet.");
                    } else {
                        System.out.println("\n--- ALL RESULTS ---");
                        for (String result : results) {
                            System.out.println("- " + result);
                        }
                    }
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Enter 1-9.");
            }
        }
    }
}
