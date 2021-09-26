package algorithms.sorting;

/**
 * Implementation of a simple Selection Sort
 */
public class SelectionSort {

    /**
     * Sorts the given Integer array
     * Complexity - O(n^2)
     *
     * The idea is to find the minimum element in the array and put it in its correct position.
     * 1. So we select assume the minimum is the first element
     * 2. We then find the minimum element's index from the array.
     * 3. we then swap the currently considered index(i) with min index
     *
     * In each iteration the number of comparison is reduced.
     * Since we are going over the array n^2 times the order is O(n^2)
     *
     * @param arr - The passed array
     */
    public void sort(int[] arr) {
        int n = arr.length;
        int min;

        for(int i = 0; i < n - 1; i++) {
            min = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[min])
                    min = j;
            }
            int t = arr[i];
            arr[i] = arr[min];
            arr[min] = t;
        }
    }
}
