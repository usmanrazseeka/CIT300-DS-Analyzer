import java.util.*;

/** Undirected, unweighted graph stored as an adjacency list. */
public class Graph {
    private final Map<String, List<String>> adj = new LinkedHashMap<>();

    /** Holds the outcome of a traversal. */
    public static class Traversal {
        public final List<String> order = new ArrayList<>();
        public long steps;   // vertices visited + edges examined
        public long nanos;
    }

    public boolean isEmpty() { return adj.isEmpty(); }
    public boolean hasVertex(String v) { return adj.containsKey(v); }
    public int vertexCount() { return adj.size(); }
    public String firstVertexName() { return adj.keySet().iterator().next(); }

    public int edgeCount() {
        int total = 0;
        for (List<String> l : adj.values()) total += l.size();
        return total / 2;
    }

    public boolean addVertex(String v) {
        if (adj.containsKey(v)) return false;
        adj.put(v, new ArrayList<>());
        return true;
    }

    /** Adds an undirected edge. Returns an error message, or null on success. */
    public String addEdge(String a, String b) {
        if (!hasVertex(a)) return "Vertex '" + a + "' does not exist.";
        if (!hasVertex(b)) return "Vertex '" + b + "' does not exist.";
        if (a.equals(b)) return "Self-loops are not allowed.";
        if (adj.get(a).contains(b)) return "Edge " + a + " - " + b + " already exists.";
        adj.get(a).add(b);
        adj.get(b).add(a);
        return null;
    }

    public void clear() { adj.clear(); }

    public void display() {
        if (adj.isEmpty()) {
            System.out.println("  Graph is empty.");
            return;
        }
        System.out.println("  Adjacency list (" + vertexCount() + " vertices, " + edgeCount() + " edges):");
        for (Map.Entry<String, List<String>> e : adj.entrySet()) {
            System.out.println("    " + e.getKey() + " -> " + e.getValue());
        }
    }

    /** Breadth-first traversal using a queue. O(V + E). */
    public Traversal bfs(String start) {
        Traversal t = new Traversal();
        long begin = System.nanoTime();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            String v = queue.poll();
            t.order.add(v);
            t.steps++;
            for (String n : adj.get(v)) {
                t.steps++;
                if (visited.add(n)) queue.add(n);
            }
        }
        t.nanos = System.nanoTime() - begin;
        return t;
    }

    /** Depth-first traversal using an explicit stack. O(V + E). */
    public Traversal dfs(String start) {
        Traversal t = new Traversal();
        long begin = System.nanoTime();
        Set<String> visited = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            String v = stack.pop();
            if (!visited.add(v)) continue;
            t.order.add(v);
            t.steps++;
            List<String> neighbours = adj.get(v);
            // push in reverse so the first neighbour is explored first
            for (int i = neighbours.size() - 1; i >= 0; i--) {
                t.steps++;
                if (!visited.contains(neighbours.get(i))) stack.push(neighbours.get(i));
            }
        }
        t.nanos = System.nanoTime() - begin;
        return t;
    }

    /** Loads a small demo graph. */
    public void loadSample() {
        clear();
        for (String v : new String[]{"A", "B", "C", "D", "E", "F", "G"}) addVertex(v);
        String[][] edges = {{"A","B"},{"A","C"},{"B","D"},{"B","E"},{"C","F"},{"E","G"},{"F","G"}};
        for (String[] e : edges) addEdge(e[0], e[1]);
    }

    /** Builds a connected graph with n vertices (ring plus chords) for benchmarking. */
    public static Graph generate(int n) {
        Graph g = new Graph();
        for (int i = 0; i < n; i++) g.addVertex("V" + i);
        for (int i = 0; i < n; i++) g.addEdge("V" + i, "V" + ((i + 1) % n));
        for (int i = 0; i < n; i += 3) g.addEdge("V" + i, "V" + ((i + n / 2) % n));
        return g;
    }
}
