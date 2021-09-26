package algorithms.sorting;

/**
 * Implementation for a simple bubble sort
 */
public class BubbleSort {

    /**
     * Sorts the given Integer array
     * Complexity - O(n^2)
     *
     * @param arr - The passed array
     */
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }
}
