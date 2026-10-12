import java.util.*;

/** Undirected graph using an adjacency list. Member 4: Graph component. */
public class Graph {
    private final Map<String, List<String>> adj = new LinkedHashMap<>();

    public boolean addVertex(String v) {
        if (v == null || v.trim().isEmpty() || adj.containsKey(v)) return false;
        adj.put(v, new ArrayList<>());
        return true;
    }

    public boolean addEdge(String a, String b) {
        if (!adj.containsKey(a) || !adj.containsKey(b) || a.equals(b)) return false;
        if (adj.get(a).contains(b)) return false; // already exists
        adj.get(a).add(b);
        adj.get(b).add(a);
        return true;
    }

    public boolean isEmpty() { return adj.isEmpty(); }
    public boolean hasVertex(String v) { return adj.containsKey(v); }
    public String firstVertex() { return adj.keySet().iterator().next(); }

    public void display() {
        if (adj.isEmpty()) { System.out.println("Graph is empty."); return; }
        for (Map.Entry<String, List<String>> e : adj.entrySet())
            System.out.println(e.getKey() + " -> " + e.getValue());
    }

    /** BFS using a queue. Returns steps (vertices visited + edges checked). */
    public int bfs(String start, boolean print) {
        int steps = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        StringBuilder order = new StringBuilder();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            steps++;
            order.append(cur).append(" ");
            for (String n : adj.get(cur)) {
                steps++;
                if (visited.add(n)) queue.add(n);
            }
        }
        if (print) System.out.println("BFS order: " + order + "| Steps: " + steps);
        return steps;
    }

    /** DFS using a stack. Returns steps (vertices visited + edges checked). */
    public int dfs(String start, boolean print) {
        int steps = 0;
        Set<String> visited = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder order = new StringBuilder();
        stack.push(start);
        while (!stack.isEmpty()) {
            String cur = stack.pop();
            if (!visited.add(cur)) continue;
            steps++;
            order.append(cur).append(" ");
            for (String n : adj.get(cur)) {
                steps++;
                if (!visited.contains(n)) stack.push(n);
            }
        }
        if (print) System.out.println("DFS order: " + order + "| Steps: " + steps);
        return steps;
    }

    /** Graph submenu. */
    public void menu(Scanner sc) {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS ------------");
            System.out.println("1. Add Vertex\n2. Add Edge\n3. Display Graph");
            System.out.println("4. BFS Traversal\n5. DFS Traversal\n6. Return to Main Menu");
            int c = Main.readInt(sc, "Enter your choice: ");
            switch (c) {
                case 1:
                    System.out.print("Vertex name: ");
                    String v = sc.nextLine().trim();
                    System.out.println(addVertex(v) ? "Vertex added." : "Invalid or duplicate vertex.");
                    break;
                case 2:
                    System.out.print("From vertex: "); String a = sc.nextLine().trim();
                    System.out.print("To vertex: ");   String b = sc.nextLine().trim();
                    System.out.println(addEdge(a, b) ? "Edge added." : "Invalid edge (missing vertex, self-loop or duplicate).");
                    break;
                case 3: display(); break;
                case 4:
                case 5:
                    if (isEmpty()) { System.out.println("Graph is empty. Add vertices first."); break; }
                    System.out.print("Start vertex: ");
                    String s = sc.nextLine().trim();
                    if (!hasVertex(s)) { System.out.println("Vertex not found."); break; }
                    int steps = (c == 4) ? bfs(s, true) : dfs(s, true);
                    Main.results.add((c == 4 ? "BFS" : "DFS") + " from " + s + " -> steps: " + steps);
                    break;
                case 6: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
