import java.util.Arrays;
import java.util.Random;

/** Console entry point: main menu and all sub-menus. */
public class Main {
    private static final DynamicArray array = new DynamicArray(16);
    private static final MyStack stack = new MyStack();
    private static final MyQueue queue = new MyQueue();
    private static final MyLinkedList list = new MyLinkedList();
    private static final Graph graph = new Graph();

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("=============================================");
            System.out.println("DATA STRUCTURE & GRAPH ANALYZER");
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
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 9);
            switch (choice) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: listMenu(); break;
                case 5: searchMenu(); break;
                case 6: graphMenu(); break;
                case 7: PerformanceAnalyzer.run(graph); break;
                case 8: ResultLog.displayAll(); break;
                case 9: System.out.println("Goodbye!"); return;
            }
        }
    }

    // ---------------------------------------------------------------- Array
    private static void arrayMenu() {
        while (true) {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert at Position");
            System.out.println("2. Append to End");
            System.out.println("3. Delete at Position");
            System.out.println("4. Search for Value");
            System.out.println("5. Display Array");
            System.out.println("6. Fill with Random Numbers");
            System.out.println("7. Return to Main Menu");
            int c = InputHelper.readIntInRange("Enter your choice: ", 1, 7);
            switch (c) {
                case 1: {
                    int idx = InputHelper.readInt("Position (0-" + array.size() + "): ");
                    int val = InputHelper.readInt("Value: ");
                    if (array.insert(idx, val)) {
                        System.out.println("  Inserted " + val + " at " + idx + " (" + array.lastSteps + " shifts).");
                    } else {
                        System.out.println("  [!] Invalid position. Valid range is 0 to " + array.size() + ".");
                    }
                    break;
                }
                case 2: {
                    array.append(InputHelper.readInt("Value: "));
                    System.out.println("  Appended.");
                    break;
                }
                case 3: {
                    if (array.isEmpty()) { System.out.println("  [!] Array is empty. Nothing to delete."); break; }
                    int idx = InputHelper.readInt("Position to delete (0-" + (array.size() - 1) + "): ");
                    if (array.deleteAt(idx)) System.out.println("  Deleted (" + array.lastSteps + " shifts).");
                    else System.out.println("  [!] Invalid position.");
                    break;
                }
                case 4: {
                    if (array.isEmpty()) { System.out.println("  [!] Array is empty."); break; }
                    int val = InputHelper.readInt("Value to search: ");
                    int idx = array.indexOf(val);
                    String msg = idx >= 0 ? val + " found at index " + idx : val + " not found";
                    System.out.println("  " + msg + " (" + array.lastSteps + " comparisons).");
                    ResultLog.add("Array search | " + msg + " | steps=" + array.lastSteps);
                    break;
                }
                case 5: array.display(); break;
                case 6: {
                    int n = InputHelper.readIntInRange("How many numbers (1-100000): ", 1, 100000);
                    Random r = new Random();
                    array.clear();
                    for (int i = 0; i < n; i++) array.append(r.nextInt(1000));
                    System.out.println("  Added " + n + " random numbers (0-999).");
                    if (n <= 30) array.display();
                    break;
                }
                case 7: return;
            }
        }
    }

    // ---------------------------------------------------------------- Stack
    private static void stackMenu() {
        while (true) {
            System.out.println("\n--------------- STACK OPERATIONS ---------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int c = InputHelper.readIntInRange("Enter your choice: ", 1, 5);
            try {
                switch (c) {
                    case 1: {
                        int v = InputHelper.readInt("Value to push: ");
                        stack.push(v);
                        System.out.println("  Pushed " + v + ".");
                        break;
                    }
                    case 2: {
                        int v = stack.pop();
                        System.out.println("  Popped " + v + ".");
                        ResultLog.add("Stack pop | " + v);
                        break;
                    }
                    case 3: System.out.println("  Top element: " + stack.peek()); break;
                    case 4: stack.display(); break;
                    case 5: return;
                }
            } catch (IllegalStateException e) {
                System.out.println("  [!] " + e.getMessage());
            }
        }
    }

    // ---------------------------------------------------------------- Queue
    private static void queueMenu() {
        while (true) {
            System.out.println("\n--------------- QUEUE OPERATIONS ---------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int c = InputHelper.readIntInRange("Enter your choice: ", 1, 5);
            try {
                switch (c) {
                    case 1: {
                        int v = InputHelper.readInt("Value to enqueue: ");
                        queue.enqueue(v);
                        System.out.println("  Enqueued " + v + ".");
                        break;
                    }
                    case 2: {
                        int v = queue.dequeue();
                        System.out.println("  Dequeued " + v + ".");
                        ResultLog.add("Queue dequeue | " + v);
                        break;
                    }
                    case 3: System.out.println("  Front element: " + queue.peek()); break;
                    case 4: queue.display(); break;
                    case 5: return;
                }
            } catch (IllegalStateException e) {
                System.out.println("  [!] " + e.getMessage());
            }
        }
    }

    // ---------------------------------------------------------- Linked list
    private static void listMenu() {
        while (true) {
            System.out.println("\n------------ LINKED LIST OPERATIONS ------------");
            System.out.println("1. Insert at Head");
            System.out.println("2. Insert at Tail");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete by Value");
            System.out.println("5. Search for Value");
            System.out.println("6. Display List");
            System.out.println("7. Return to Main Menu");
            int c = InputHelper.readIntInRange("Enter your choice: ", 1, 7);
            switch (c) {
                case 1: {
                    list.insertAtHead(InputHelper.readInt("Value: "));
                    System.out.println("  Inserted at head (" + list.lastSteps + " step).");
                    break;
                }
                case 2: {
                    list.insertAtTail(InputHelper.readInt("Value: "));
                    System.out.println("  Inserted at tail (" + list.lastSteps + " steps).");
                    break;
                }
                case 3: {
                    int pos = InputHelper.readInt("Position (0-" + list.size() + "): ");
                    int val = InputHelper.readInt("Value: ");
                    if (list.insertAt(pos, val)) System.out.println("  Inserted.");
                    else System.out.println("  [!] Invalid position. Valid range is 0 to " + list.size() + ".");
                    break;
                }
                case 4: {
                    if (list.isEmpty()) { System.out.println("  [!] List is empty. Nothing to delete."); break; }
                    int val = InputHelper.readInt("Value to delete: ");
                    if (list.delete(val)) System.out.println("  Deleted " + val + " (" + list.lastSteps + " steps).");
                    else System.out.println("  [!] " + val + " not found in the list.");
                    break;
                }
                case 5: {
                    if (list.isEmpty()) { System.out.println("  [!] List is empty."); break; }
                    int val = InputHelper.readInt("Value to search: ");
                    int pos = list.search(val);
                    String msg = pos >= 0 ? val + " found at position " + pos : val + " not found";
                    System.out.println("  " + msg + " (" + list.lastSteps + " steps).");
                    ResultLog.add("Linked list search | " + msg + " | steps=" + list.lastSteps);
                    break;
                }
                case 6: list.display(); break;
                case 7: return;
            }
        }
    }

    // ------------------------------------------------------------ Searching
    private static void searchMenu() {
        while (true) {
            System.out.println("\n-------------- SEARCHING OPERATIONS ------------");
            System.out.println("1. Linear Search (on Array data)");
            System.out.println("2. Binary Search (on sorted copy of Array data)");
            System.out.println("3. Compare Linear vs Binary");
            System.out.println("4. Return to Main Menu");
            int c = InputHelper.readIntInRange("Enter your choice: ", 1, 4);
            if (c == 4) return;
            if (array.isEmpty()) {
                System.out.println("  [!] The array is empty. Add data in Array Operations (option 1) first.");
                continue;
            }
            int key = InputHelper.readInt("Value to search for: ");
            int[] data = array.toArray();
            int[] sorted = data.clone();
            Arrays.sort(sorted);
            switch (c) {
                case 1: {
                    Searching.Result r = Searching.linearSearch(data, key);
                    printSearch("Linear Search", key, r);
                    break;
                }
                case 2: {
                    Searching.Result r = Searching.binarySearch(sorted, key);
                    printSearch("Binary Search", key, r);
                    System.out.println("  (index refers to the SORTED copy: " + preview(sorted) + ")");
                    break;
                }
                case 3: {
                    Searching.Result lin = Searching.linearSearch(data, key);
                    Searching.Result bin = Searching.binarySearch(sorted, key);
                    System.out.println("  Array size: " + data.length);
                    printSearch("Linear Search", key, lin);
                    printSearch("Binary Search", key, bin);
                    System.out.println("  Linear needed " + lin.steps + " step(s) vs binary " + bin.steps
                            + ". Linear is O(n); binary is O(log n) but needs sorted data.");
                    break;
                }
            }
        }
    }

    private static void printSearch(String name, int key, Searching.Result r) {
        String found = r.index >= 0 ? "found at index " + r.index : "not found";
        System.out.println("  " + name + ": " + key + " " + found + " | steps=" + r.steps + " | time=" + r.nanos + " ns");
        ResultLog.add(name + " | key=" + key + " | " + found + " | steps=" + r.steps + " | time=" + r.nanos + " ns");
    }

    private static String preview(int[] a) {
        if (a.length <= 15) return Arrays.toString(a);
        return Arrays.toString(Arrays.copyOf(a, 15)) + " ... (" + a.length + " items)";
    }

    // ---------------------------------------------------------------- Graph
    private static void graphMenu() {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Load Sample Graph");
            System.out.println("7. Return to Main Menu");
            int c = InputHelper.readIntInRange("Enter your choice: ", 1, 7);
            switch (c) {
                case 1: {
                    String v = InputHelper.readWord("Vertex name: ");
                    System.out.println(graph.addVertex(v) ? "  Vertex '" + v + "' added." : "  [!] Vertex '" + v + "' already exists.");
                    break;
                }
                case 2: {
                    if (graph.vertexCount() < 2) { System.out.println("  [!] Add at least two vertices first."); break; }
                    String a = InputHelper.readWord("First vertex: ");
                    String b = InputHelper.readWord("Second vertex: ");
                    String err = graph.addEdge(a, b);
                    System.out.println(err == null ? "  Edge " + a + " - " + b + " added." : "  [!] " + err);
                    break;
                }
                case 3: graph.display(); break;
                case 4:
                case 5: {
                    if (graph.isEmpty()) { System.out.println("  [!] Graph is empty."); break; }
                    String s = InputHelper.readWord("Start vertex: ");
                    if (!graph.hasVertex(s)) { System.out.println("  [!] Vertex '" + s + "' does not exist."); break; }
                    String name = c == 4 ? "BFS" : "DFS";
                    Graph.Traversal t = c == 4 ? graph.bfs(s) : graph.dfs(s);
                    System.out.println("  " + name + " order: " + String.join(" -> ", t.order));
                    System.out.println("  Steps: " + t.steps + " | Time: " + t.nanos + " ns");
                    ResultLog.add(name + " from " + s + " | " + String.join(" -> ", t.order) + " | steps=" + t.steps);
                    break;
                }
                case 6: graph.loadSample(); System.out.println("  Sample graph loaded (A-G)."); graph.display(); break;
                case 7: return;
            }
        }
    }
}
