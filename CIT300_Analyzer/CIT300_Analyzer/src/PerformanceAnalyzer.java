/** Runs benchmarks that compare algorithms/data structures by steps and time. */
public class PerformanceAnalyzer {

    private static String row(String op, String algo, String size, long steps, long nanos, String complexity) {
        return String.format("%-16s %-22s %-9s %-11d %-13d %s", op, algo, size, steps, nanos, complexity);
    }

    private static void record(String line) {
        System.out.println(line);
        ResultLog.add("PERF | " + line.trim().replaceAll("\\s{2,}", " | "));
    }

    public static void run(Graph userGraph) {
        System.out.println("=============================================");
        System.out.println("PERFORMANCE COMPARISON");
        System.out.println("=============================================");
        System.out.printf("%-16s %-22s %-9s %-11s %-13s %s%n",
                "Operation", "Algorithm", "N", "Steps", "Time (ns)", "Complexity");
        System.out.println("-----------------------------------------------------------------------------------");

        // 1. Searching: worst case (key not present), so linear checks every element.
        for (int n : new int[]{1_000, 10_000, 100_000, 1_000_000}) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = i * 2; // sorted, even numbers only
            int key = -1;                                  // absent => worst case
            Searching.Result lin = Searching.linearSearch(arr, key);
            Searching.Result bin = Searching.binarySearch(arr, key);
            record(row("Search", "Linear Search", String.valueOf(n), lin.steps, lin.nanos, "O(n)"));
            record(row("Search", "Binary Search", String.valueOf(n), bin.steps, bin.nanos, "O(log n)"));
        }
        System.out.println();

        // 2. Insert at the front: array shifts everything, linked list just re-links the head.
        int n = 10_000;
        DynamicArray arr = new DynamicArray(n);
        MyLinkedList list = new MyLinkedList();
        long arrSteps = 0, listSteps = 0;
        long t0 = System.nanoTime();
        for (int i = 0; i < n; i++) { arr.insert(0, i); arrSteps += arr.lastSteps; }
        long arrTime = System.nanoTime() - t0;
        t0 = System.nanoTime();
        for (int i = 0; i < n; i++) { list.insertAtHead(i); listSteps += list.lastSteps; }
        long listTime = System.nanoTime() - t0;
        record(row("Insert at front", "Array", String.valueOf(n), arrSteps, arrTime, "O(n) each"));
        record(row("Insert at front", "Linked List", String.valueOf(n), listSteps, listTime, "O(1) each"));
        System.out.println();

        // 3. Stack and queue: constant-time operations.
        MyStack stack = new MyStack();
        MyQueue queue = new MyQueue();
        t0 = System.nanoTime();
        for (int i = 0; i < n; i++) stack.push(i);
        while (!stack.isEmpty()) stack.pop();
        long stackTime = System.nanoTime() - t0;
        t0 = System.nanoTime();
        for (int i = 0; i < n; i++) queue.enqueue(i);
        while (!queue.isEmpty()) queue.dequeue();
        long queueTime = System.nanoTime() - t0;
        record(row("Push+Pop", "Stack", String.valueOf(n), 2L * n, stackTime, "O(1) each"));
        record(row("Enqueue+Dequeue", "Queue", String.valueOf(n), 2L * n, queueTime, "O(1) each"));
        System.out.println();

        // 4. Graph traversal: use the user's graph if it has vertices, else a generated one.
        Graph g = (userGraph != null && !userGraph.isEmpty()) ? userGraph : Graph.generate(500);
        String label = (g == userGraph) ? "V=" + g.vertexCount() : "V=500";
        String start = firstVertex(g);
        Graph.Traversal bfs = g.bfs(start);
        Graph.Traversal dfs = g.dfs(start);
        record(row("Graph Traversal", "BFS", label, bfs.steps, bfs.nanos, "O(V+E)"));
        record(row("Graph Traversal", "DFS", label, dfs.steps, dfs.nanos, "O(V+E)"));

        System.out.println("=============================================");
        System.out.println("Notes:");
        System.out.println(" - Linear search steps grow with N (O(n)); binary search grows by ~1 step each time N doubles (O(log n)).");
        System.out.println(" - Binary search needs sorted data; sorting costs O(n log n) once.");
        System.out.println(" - Array front-insert shifts every element; linked-list head-insert is a single re-link.");
        System.out.println(" - BFS and DFS both visit every vertex and edge once, so both are O(V+E); step counts are similar,");
        System.out.println("   but the visiting ORDER differs (level by level vs. deep first).");
        System.out.println(" - Time (ns) varies per run (JIT warm-up, OS scheduling); step counts are the reliable measure.");
        System.out.println("=============================================");
    }

    private static String firstVertex(Graph g) {
        // BFS from any vertex; generated graph names start at V0, sample graph at A
        return g.hasVertex("V0") ? "V0" : g.hasVertex("A") ? "A" : g.firstVertexName();
    }
}
