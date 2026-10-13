# Data Structure & Graph Performance Analyzer

**Course:** CIT300 Data Structures and Algorithms – Graded Practical Assignment 2
**Language:** Java (console application)

## Project Description
A menu-driven Java console application that implements the core data structures from Weeks 1-11
(Array, Stack, Queue, Linked List, Graph), searching algorithms (Linear and Binary), and a
performance analyzer that compares algorithms by **number of steps** and **execution time**, then
relates the results to algorithmic complexity.

## Team Members  (⚠ EDIT BEFORE SUBMITTING – names and IDs must be exact)

| Student Name | Student ID | Assigned Responsibility |
|---|---|---|
| [Full name – Member 1] | [ID] | Array and Searching |
| [Full name – Member 2] | [ID] | Stack and Queue |
| **[Full name – Sahani]** | **23DA2-0924** | **Linked List** |
| [Full name – Member 4] | [ID] | Graph (BFS/DFS) |
| [Full name – Member 5] | [ID] | Performance comparison, main menu, integration, testing |

*(If your group is smaller, combine roles – every component must still be present.)*

## Individual Contributions

**Student Name:** Z.Fathima Sahani]
**Student ID:** 23DA2-0924
**Assigned Responsibility:** Linked List
**Individual Contribution:**
- Implemented `MyLinkedList` (singly linked list with a private `Node` class)
- Implemented insert at head, insert at tail, insert at position, delete by value, search and display
- Added handling for empty lists, invalid positions and values that are not found
- Added step counters used by the Performance Comparison (array vs linked list)
- Built and tested the Linked List submenu and integrated it into the main menu

**Student Name:** [Member 1]  **Student ID:** [ID]
**Assigned Responsibility:** Array and Searching
**Individual Contribution:**
- Implemented `DynamicArray` (insert, append, delete, search, display, auto-resize)
- Implemented `Searching` (linear and binary search with step and time counters)
- Built the Searching submenu and linear-vs-binary comparison

**Student Name:** [Member 2]  **Student ID:** [ID]
**Assigned Responsibility:** Stack and Queue
**Individual Contribution:**
- Implemented `MyStack` and `MyQueue` (push/pop/peek/display and enqueue/dequeue/peek/display, underflow handling)

**Student Name:** [Member 4]  **Student ID:** [ID]
**Assigned Responsibility:** Graph
**Individual Contribution:**
- Implemented `Graph` (adjacency list; add vertex/edge; display; BFS; DFS)
- Tested graph functionality and integrated it with the main application

**Student Name:** [Member 5]  **Student ID:** [ID]
**Assigned Responsibility:** Performance comparison, main menu, integration, testing
**Individual Contribution:**
- Implemented `PerformanceAnalyzer`, `ResultLog`, `InputHelper`, and `Main`

## Technologies Used
Java 11+ (tested on Java 21), Git and GitHub.

## Main System Features
- Array: insert, append, delete, search, display, random fill
- Stack: push, pop, peek, display (underflow handled)
- Queue: enqueue, dequeue, peek, display (underflow handled)
- Linked list: insert (head / tail / position), delete, search, display
- Searching: linear search, binary search, side-by-side comparison
- Graph (undirected, adjacency list): add vertex, add edge, display, BFS, DFS, sample graph
- Performance comparison table (steps, nanoseconds, complexity)
- Display All Results log for the session
- Input validation everywhere (non-numeric input, out-of-range values, empty structures)

## Project Structure
```
src/
  Main.java                 main menu and submenus
  InputHelper.java          validated console input
  DynamicArray.java         array component
  MyStack.java              stack component
  MyQueue.java              queue component
  MyLinkedList.java         linked list component
  Searching.java            linear and binary search
  Graph.java                graph, BFS, DFS
  PerformanceAnalyzer.java  benchmarks and comparison table
  ResultLog.java            "Display All Results"
```

## How to Run
```bash
cd src
javac *.java
java Main
```
Or open the folder in IntelliJ IDEA / Eclipse / VS Code and run `Main`.

## Complexity Summary

| Component | Operation | Complexity |
|---|---|---|
| Array | insert / delete at position | O(n) (shifting) |
| Array | append | O(1) amortised |
| Stack | push / pop / peek | O(1) |
| Queue (circular array) | enqueue / dequeue / peek | O(1) |
| Linked list | insert at head | O(1) |
| Linked list | insert at tail / search / delete | O(n) |
| Linear search | search | O(n) |
| Binary search | search (sorted data) | O(log n) |
| Graph (adjacency list) | BFS / DFS | O(V + E) |

**Why results differ:** linear search steps grow in proportion to N while binary search grows by
about one step each time N doubles. Array front-insertion shifts every element, while a linked list
only re-links the head. BFS and DFS both visit each vertex and edge once, so their step counts are
similar, but the order of visiting differs (BFS goes level by level using a queue; DFS goes deep
using a stack). Timings in nanoseconds fluctuate between runs because of JIT warm-up and OS
scheduling, so step counts are the more reliable measure.
