import java.util.Arrays;

/** LIFO stack implemented on a growable array. All operations O(1) amortised. */
public class MyStack {
    private int[] items = new int[8];
    private int top = -1;

    public boolean isEmpty() { return top == -1; }
    public int size() { return top + 1; }

    public void push(int value) {
        if (top == items.length - 1) items = Arrays.copyOf(items, items.length * 2);
        items[++top] = value;
    }

    /** Removes and returns the top item. @throws IllegalStateException if empty (underflow). */
    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack underflow: cannot pop from an empty stack.");
        return items[top--];
    }

    /** Returns the top item without removing it. */
    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty: nothing to peek.");
        return items[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("  Stack is empty.");
            return;
        }
        System.out.println("  Stack (top -> bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println("    | " + items[i] + " |" + (i == top ? "  <- top" : ""));
        }
        System.out.println("    +---+");
    }
}
