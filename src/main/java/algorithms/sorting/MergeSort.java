package algorithms.sorting;

import java.util.Arrays;

/**
 * Implementation of a simple Selection Sort
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {7, 4, 5, 0, 9, 1, 2};
        new MergeSort().sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * Calling function for passing array
     *
     * @param a - The array to be sorted
     */
    public void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    /**
     * This algorithm uses the Divide and Conquer technique to sort the array. Here we split the
     * array into N/2 sub-arrays, where N is the size of array, until each sub-array contains 1 element.
     * Then we pick a pair from each sub-array and then put it in a new array based on whichever is smaller.
     * If one array exhausts we copy the remaining elements from the other array.
     * <p>
     * So we first split the arrays and compare and merge them.
     * <p>
     * Since we can split an array into maximum (log N) times and we have to go over the array N times
     * the Order is O(N log N)
     *
     * @param a     - The array to be sorted
     * @param start - The starting index
     * @param end   - The ending index
     */
    private void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    /**
     * This function merges two sub-arrays.
     *
     * The algorithm follows the following steps
     * 1. Back up start and end in two variables.
     * 2. Create an auxiliary array of size end - start + 1.
     * 3. Initialize a current pointer.
     * 4. Iterate from 'start' to 'end'
     * 5. If start > mid then copy array from mid to aux array
     * 6. If mid > end then copy array from start to end
     * 7. Pick smaller element from array and add to aux list
     * 8. Copy aux array into original array from start to end
     *
     * @param a     - The array from which the sub-arrays are to be merged
     * @param start - The start index
     * @param mid   - The mid index
     * @param end   - The end index
     */
    private void merge(int[] a, int start, int mid, int end) {
        int p = start;
        int q = mid + 1;
        int[] sorted = new int[end - start + 1];
        int cur = 0;

        for (int i = start; i <= end; i++) {
            if (p > mid)
                sorted[cur++] = a[q++];
            else if (q > end)
                sorted[cur++] = a[p++];
            else if (a[p] < a[q])
                sorted[cur++] = a[p++];
            else
                sorted[cur++] = a[q++];
        }

        for (int i = 0; i < cur; i++)
            a[start++] = sorted[i];
    }
}
