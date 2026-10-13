import java.util.Arrays;

/** Resizable integer array with insert, delete, search and display. */
public class DynamicArray {
    private int[] data;
    private int size;
    /** Number of element moves/comparisons in the last operation (for analysis). */
    public long lastSteps;

    public DynamicArray(int capacity) {
        data = new int[Math.max(capacity, 4)];
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public int get(int index) { return data[index]; }

    private void ensureCapacity() {
        if (size == data.length) data = Arrays.copyOf(data, size * 2);
    }

    /** Adds a value at the end. O(1) amortised. */
    public void append(int value) {
        ensureCapacity();
        data[size++] = value;
        lastSteps = 1;
    }

    /** Inserts at index (0..size). Shifts elements right. O(n). */
    public boolean insert(int index, int value) {
        if (index < 0 || index > size) return false;
        ensureCapacity();
        lastSteps = 0;
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
            lastSteps++;
        }
        data[index] = value;
        size++;
        return true;
    }

    /** Deletes element at index. Shifts elements left. O(n). */
    public boolean deleteAt(int index) {
        if (index < 0 || index >= size) return false;
        lastSteps = 0;
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
            lastSteps++;
        }
        size--;
        return true;
    }

    /** Linear search for a value; returns index or -1. */
    public int indexOf(int value) {
        lastSteps = 0;
        for (int i = 0; i < size; i++) {
            lastSteps++;
            if (data[i] == value) return i;
        }
        return -1;
    }

    public int[] toArray() { return Arrays.copyOf(data, size); }

    public void sort() { Arrays.sort(data, 0, size); }

    public void clear() { size = 0; }

    public void display() {
        if (isEmpty()) {
            System.out.println("  Array is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("  [");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        System.out.println(sb.append("]  (size=").append(size).append(")"));
    }
}
