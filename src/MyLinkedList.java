/** Singly linked list of integers. */
public class MyLinkedList {
    private static class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }

    private Node head;
    private int size;
    public long lastSteps; 

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    /** Insert at head. O(1). */
    public void insertAtHead(int value) {
        Node n = new Node(value);
        n.next = head;
        head = n;
        size++;
        lastSteps = 1;
    }

    /** Insert at tail. O(n) because there is no tail pointer. */
    public void insertAtTail(int value) {
        Node n = new Node(value);
        lastSteps = 1;
        if (head == null) {
            head = n;
        } else {
            Node cur = head;
            while (cur.next != null) { cur = cur.next; lastSteps++; }
            cur.next = n;
        }
        size++;
    }

    /** Insert at position (0..size). */
    public boolean insertAt(int position, int value) {
        if (position < 0 || position > size) return false;
        if (position == 0) { insertAtHead(value); return true; }
        Node cur = head;
        lastSteps = 0;
        for (int i = 0; i < position - 1; i++) { cur = cur.next; lastSteps++; }
        Node n = new Node(value);
        n.next = cur.next;
        cur.next = n;
        size++;
        return true;
    }

    /** Deletes the first node holding value. Returns false if not found. */
    public boolean delete(int value) {
        lastSteps = 0;
        if (head == null) return false;
        lastSteps++;
        if (head.value == value) { head = head.next; size--; return true; }
        Node cur = head;
        while (cur.next != null) {
            lastSteps++;
            if (cur.next.value == value) {
                cur.next = cur.next.next;
                size--;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /** Returns zero-based position of value, or -1. */
    public int search(int value) {
        lastSteps = 0;
        Node cur = head;
        int pos = 0;
        while (cur != null) {
            lastSteps++;
            if (cur.value == value) return pos;
            cur = cur.next;
            pos++;
        }
        return -1;
    }

    public void display() {
        if (head == null) {
            System.out.println("  Linked list is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("  HEAD -> ");
        for (Node cur = head; cur != null; cur = cur.next) sb.append("[").append(cur.value).append("] -> ");
        System.out.println(sb.append("NULL  (size=").append(size).append(")"));
    }
}
