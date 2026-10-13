# CIT300-DS-Analyzer

## Project Description
A Java console-based application that demonstrates data structures, searching, graph traversal and algorithmic complexity.
The system lets the user work with an Array, Stack, Queue, Linked List and a Graph, compare Linear vs Binary search,
compare BFS vs DFS traversal, and view steps / execution time for each operation.

**Course:** CIT300 Data Structures and Algorithms – Graded Practical Assignment 2

## Team Members

| Student Name | Student ID | Assigned Responsibility |
|---|---|---|
| [FULL NAME OF SAHANI] | 23DA2-0924 | Array and Searching |
| [FULL NAME OF SIMRANA] | 23DA2-0665 | Stack and Queue |
| [FULL NAME OF AFRA] | 23DA2-1145 | Linked List |
| [FULL NAME OF RAZEEKA] | 23DA2-0976 | Group Leader – Graph, Performance Comparison, Main Menu, Integration and Testing |

## Individual Contributions

### [ZF.SAHANI] – 23DA2-0924 – Array and Searching
- Implemented `DynamicArray` (resizable integer array)
- Implemented insert, delete, linear search and display operations
- Tracked the number of steps for each operation
- Binary Search: *(TODO – update once merged)*

### [MF. SIMRANA] – 23DA2-0665 – Stack and Queue
- Implemented `ActionStack` (push, pop, display, empty-stack handling)
- Implemented `ActionQueue` (enqueue, dequeue, peek, display, empty-queue handling)

### FF. AFRA] – 23DA2-1145 – Linked List
- Implemented `LinkedListManager` (insert, delete, display)
- Implemented `searchElement` with step counting

### [ULF.RAZEEKA] – 23DA2-0976 – Graph, Performance, Main Menu, Integration
- Implemented `Graph` (adjacency list): add vertex, add edge, display, BFS (queue), DFS (stack)
- Implemented `PerformanceAnalyzer`: Linear vs Binary search and BFS vs DFS comparison (steps and execution time)
- Implemented the main menu, input validation and integrated all modules
- Managed the GitHub repository (branches, pull requests, merging)
- *(Confirm before submitting: list any extra methods you added to teammates' classes, e.g. `peekAction()` in `ActionStack`.)*

## Technologies Used
- Java (console application)
- Git and GitHub (branches, commits, pull requests)
- Visual Studio Code

## Main Features
- Array: insert, delete, search, display
- Stack: push, pop, peek, display (handles empty stack)
- Queue: enqueue, dequeue, peek, display (handles empty queue)
- Linked List: insert, delete, search, display
- Searching: Linear Search and Binary Search *(Binary Search: update status)*
- Graph: add vertex, add edge, display, BFS, DFS
- Performance comparison: steps and execution time
  - Linear Search O(n) vs Binary Search O(log n)
  - BFS and DFS O(V + E)
- Input validation and handling of empty data structures

## Project Structure
```
src/
 ├── Main.java
 ├── Graph.java
 ├── PerformanceAnalyzer.java
 ├── DynamicArray.java
 ├── LinkedListManager.java
 └── structures/
      ├── ActionStack.java
      └── ActionQueue.java
```

## How to Run
1. Install Java JDK 11 or later.
2. Clone the repository:
   ```
   git clone https://github.com/usmanrazseeka/CIT300-DS-Analyzer.git
   ```
3. Open a terminal in the `src` folder and compile:
   ```
   javac *.java structures/*.java
   ```
4. Run:
   ```
   java Main
   ```
   (Or open the project in VS Code and click **Run** on `Main.java`.)