/** Linear and binary search that also report steps and execution time. */
public class Searching {

    /** Holds the outcome of one search. */
    public static class Result {
        public final int index;
        public final long steps;
        public final long nanos;
        public Result(int index, long steps, long nanos) {
            this.index = index; this.steps = steps; this.nanos = nanos;
        }
    }

    /** O(n): checks each element in turn. Works on unsorted data. */
    public static Result linearSearch(int[] arr, int key) {
        long start = System.nanoTime();
        long steps = 0;
        int found = -1;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == key) { found = i; break; }
        }
        return new Result(found, steps, System.nanoTime() - start);
    }

    /** O(log n): halves the search range each step. REQUIRES a sorted array. */
    public static Result binarySearch(int[] sortedArr, int key) {
        long start = System.nanoTime();
        long steps = 0;
        int low = 0, high = sortedArr.length - 1, found = -1;
        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (sortedArr[mid] == key) { found = mid; break; }
            else if (sortedArr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return new Result(found, steps, System.nanoTime() - start);
    }
}
