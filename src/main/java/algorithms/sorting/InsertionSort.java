package algorithms.sorting;

/**
 * Implementation of a simple Insertion Sort
 */
public class InsertionSort {

    /**
     * Sorts the given Integer array
     * Complexity - O(n^2)
     *
     * @param a - The passed array
     */
    public void sort(int[] a) {
        int n = a.length;

        for(int i = 0; i < n; i++) {
            int temp = a[i];
            int j = i;
            while(j > 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }
}
