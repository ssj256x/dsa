package algorithms.sorting;

import java.util.Arrays;

/**
 * Simple implementation of Radix Sort
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] a = {170, 45, 75, 90, 802, 24, 2, 66};
        new RadixSort().radixSort(a);
        System.out.println(Arrays.toString(a));
    }

    private int getMax(int[] a) {
        int max = a[0];
        for (int n : a) max = Math.max(n, max);
        return max;
    }

    /**
     * Performs the counting sort based on the exp-th significant digit
     *
     * @param a   - Array to be sorted
     * @param n   - size of array
     * @param exp - the position of 10^i where i is the i-th significant bit
     */
    private void countingSort(int[] a, int n, int exp) {
        int[] count = new int[10];
        int[] output = new int[n];
        int i;

        // Counting the exp-th significant bit
        for (i = 0; i < n; i++)
            count[(a[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(a[i] / exp) % 10] - 1] = a[i];
            count[(a[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            a[i] = output[i];
    }

    /**
     * Radix sort
     *
     * @param a - Array tobe sorted
     */
    public void radixSort(int[] a) {
        int max = getMax(a);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(a, a.length, exp);
        }
    }
}
