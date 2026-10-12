/** FIFO queue implemented as a circular array. All operations O(1) amortised. */
public class MyQueue {
    private int[] items = new int[8];
    private int front = 0;
    private int count = 0;

    public boolean isEmpty() { return count == 0; }
    public int size() { return count; }

    private void grow() {
        int[] bigger = new int[items.length * 2];
        for (int i = 0; i < count; i++) bigger[i] = items[(front + i) % items.length];
        items = bigger;
        front = 0;
    }

    public void enqueue(int value) {
        if (count == items.length) grow();
        items[(front + count) % items.length] = value;
        count++;
    }

    /** Removes and returns the front item. @throws IllegalStateException if empty (underflow). */
    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue underflow: cannot dequeue from an empty queue.");
        int v = items[front];
        front = (front + 1) % items.length;
        count--;
        return v;
    }

    /** Returns the front item without removing it. */
    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty: nothing at the front.");
        return items[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("  Queue is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("  FRONT -> ");
        for (int i = 0; i < count; i++) {
            sb.append("[").append(items[(front + i) % items.length]).append("] ");
        }
        System.out.println(sb.append("<- REAR"));
    }
}
