package algorithms.sorting;

import java.util.Arrays;

/**
 * Implementation for a simple Counting Sort
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] a = {7, 4, 5, 0, 9, 1, 2};
        new CountingSort().sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * The idea is to find the max element from the array and then make an auxiliary
     * array of size max + 1. Now iterate over the array to be sorted and count the
     * occurrence of each number. Now overwrite the original array with non zero indices
     * of the auxiliary array.
     *
     * @param a - Array to be sorted
     */
    public void sort(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int n : a) max = Math.max(n, max);

        int[] count = new int[max + 1];
        for (int n : a) count[n]++;

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                a[j++] = i;
            }
        }
    }
}
