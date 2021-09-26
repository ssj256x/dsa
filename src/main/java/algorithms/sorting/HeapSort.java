package algorithms.sorting;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        new HeapSort().heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * Takes an array as input and rearranges as a Max Heap.
     * Then it swaps the first element with the last element and maxHeapfies the array
     * it then reduces the size of array by 1 and repeats the process until size is 0.
     * <p>
     * So at each iteration the largest element is put in the end of the array, then the
     * second max element at end - 1 pos of array and so on.
     *
     * @param a - Array to be sorted
     */
    public void heapSort(int[] a) {
        int size = a.length;

        buildMaxHeap(a, size);
        for (int i = size - 1; i > 0; i--) {
            swap(a, 0, i);
            maxHeapify(a, 0, i);
        }
    }

    /**
     * Builds the max heap from the parent node of the array (size / 2 - 1) is the parent node.
     *
     * @param a    - Arrays to be heapified
     * @param size - size of array
     */
    private void buildMaxHeap(int[] a, int size) {
        for (int i = size / 2 - 1; i >= 0; i--)
            maxHeapify(a, i, size);
    }

    /**
     * In the array the left child of given node is given as '2 * node + 1' and the right
     * child is give as '2 * node + 2'.
     * <p>
     * Then the left node is compared with the largest. if left > largest then largest is set as left
     * and the same goes for right node.
     * <p>
     * If the currently passed node is not equal to the largest node. We swap largest and the given node
     * and heapify the array
     *
     * @param a    - Array to be heapified
     * @param node - Node from where array should be heapified
     * @param size - Size of the aeeay
     */
    private void maxHeapify(int[] a, int node, int size) {
        int left = 2 * node + 1;
        int right = 2 * node + 2;
        int largest = node;

        if (left < size && a[left] > a[largest])
            largest = left;
        if (right < size && a[right] > a[largest])
            largest = right;

        if (largest != node) {
            swap(a, largest, node);
            maxHeapify(a, largest, size);
        }
    }

    /**
     * Swap passed index i and j in array a
     *
     * @param a - Array where swap is to be performed
     * @param i - index 1
     * @param j - index 2
     */
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
