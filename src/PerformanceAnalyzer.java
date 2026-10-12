import java.util.*;

/** Member 5: Performance / complexity comparison. */
public class PerformanceAnalyzer {

    public static void run(Scanner sc, Graph graph) {
        System.out.println("\n=== PERFORMANCE COMPARISON ===");

        // ---- Searching comparison ----
        int n = Main.readInt(sc, "Array size for search test (e.g. 100000): ");
        if (n <= 0) { System.out.println("Size must be positive."); return; }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i * 2;           // sorted data
        int target = Main.readInt(sc, "Number to search for: ");

        int linSteps = 0, linIdx = -1;
        long t1 = System.nanoTime();
        for (int i = 0; i < n; i++) { linSteps++; if (arr[i] == target) { linIdx = i; break; } }
        long linTime = System.nanoTime() - t1;

        int binSteps = 0, binIdx = -1, lo = 0, hi = n - 1;
        long t2 = System.nanoTime();
        while (lo <= hi) {
            binSteps++;
            int mid = (lo + hi) >>> 1;
            if (arr[mid] == target) { binIdx = mid; break; }
            else if (arr[mid] < target) lo = mid + 1; else hi = mid - 1;
        }
        long binTime = System.nanoTime() - t2;

        // ---- Graph traversal comparison ----
        int bfsSteps = -1, dfsSteps = -1; long bfsTime = 0, dfsTime = 0;
        if (!graph.isEmpty()) {
            String start = graph.firstVertex();
            long t3 = System.nanoTime(); bfsSteps = graph.bfs(start, false); bfsTime = System.nanoTime() - t3;
            long t4 = System.nanoTime(); dfsSteps = graph.dfs(start, false); dfsTime = System.nanoTime() - t4;
        }

        System.out.println("\n=============================================");
        System.out.println(" PERFORMANCE COMPARISON");
        System.out.println("=============================================");
        System.out.printf("%-16s %-14s %-8s %-12s %s%n", "Operation", "Algorithm", "Steps", "Time(ns)", "Result");
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-16s %-14s %-8d %-12d %s%n", "Search", "Linear Search", linSteps, linTime, linIdx >= 0 ? "Found @" + linIdx : "Not found");
        System.out.printf("%-16s %-14s %-8d %-12d %s%n", "Search", "Binary Search", binSteps, binTime, binIdx >= 0 ? "Found @" + binIdx : "Not found");
        if (bfsSteps >= 0) {
            System.out.printf("%-16s %-14s %-8d %-12d%n", "Graph Traversal", "BFS", bfsSteps, bfsTime);
            System.out.printf("%-16s %-14s %-8d %-12d%n", "Graph Traversal", "DFS", dfsSteps, dfsTime);
        } else {
            System.out.println("Graph traversal skipped (graph is empty - add vertices/edges first).");
        }
        System.out.println("=============================================");
        System.out.println("Linear Search: O(n)   Binary Search: O(log n)   BFS/DFS: O(V+E)");

        Main.results.add("Search n=" + n + " target=" + target + " -> Linear steps: " + linSteps + ", Binary steps: " + binSteps);
        if (bfsSteps >= 0) Main.results.add("Graph traversal -> BFS steps: " + bfsSteps + ", DFS steps: " + dfsSteps);
    }
}
