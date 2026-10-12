# GitHub Workflow and Video Guide (not part of the code)

## GitHub collaboration (the lecturer checks this)
One person creates the repo and adds the others as collaborators. Then:
```bash
git clone <repo-url>
git checkout -b feature/linked-list          # each member uses their own branch
git add src/MyLinkedList.java
git commit -m "Add singly linked list with head/tail/position insert"
git commit -m "Add delete, search and display with empty-list handling"
git push -u origin feature/linked-list
```
Open a **Pull Request** on GitHub from your branch into `main`, have a teammate review and merge it.
Suggested branches: `feature/array-searching`, `feature/linked-list`, `feature/linked-list`,
`feature/graph`, `feature/integration`. Make several small, meaningful commits per person rather than
one big upload, and create a few GitHub Issues (one per component).

## Video (under 15 minutes, face visible during your own part)
Each member's section: face on camera -> name, ID, responsibility -> show code -> run demo ->
explain data structure/algorithm -> explain complexity -> show integration in the main menu.

### Linked List section script (about 2-3 minutes)
1. "I am [name], ID 23DA2-0924. I was responsible for the Linked List."
2. Show `MyLinkedList.java`: private `Node` (value + next), `head`, `size`. Singly linked: each node points only to the next.
3. Demo (Main menu 4): delete on empty list (error shown) -> insert at head 3 -> insert at tail 8 -> insert at position 1 value 99 -> display `HEAD -> [3] -> [99] -> [8] -> NULL` -> search 8 -> delete 3 -> try invalid position.
4. Explain: insert at head is O(1) (re-link head). Insert at tail, search and delete by value are O(n) because there is no tail pointer and you must walk the list. Memory is allocated per node, so no resizing or shifting.
5. Compare with arrays: array front-insert shifts every element, O(n). Linked list head-insert is O(1).
6. Integration: Main menu option 7 (Performance Comparison) shows 10,000 front-inserts: 49,995,000 shifts for the array vs 10,000 steps for the linked list.
