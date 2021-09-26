package algorithms.divideandconquer;

/**
 * The quick select algorithm is used to find K-th smallest/largest/frequent type problems
 */
public class QuickSelect {

    public static void main(String[] args) {
        System.out.println(kthSmallestNum(new int[]{10, 4, 5, 8, 6, 11, 26}, 3));
    }

    public static int kthSmallestNum(int[] arr, int k) {
        return findKthSmallest(arr, 0, arr.length - 1, k - 1);
    }

    /**
     * This is similar to Quick Sort but here instead of iterating on both partitions we only iterate of the
     * partition which contains k-th smallest element.
     * if k-th index is more than the partition we recur on the right side
     * else we recur on the left side
     * <p>
     * if k == partition we return the partition index of arr
     *
     * @param arr  - The array to be processed
     * @param low  - The low index
     * @param high - The high index
     * @param k    - The k-th smallest element to find
     * @return K-th smallest element
     */
    public static int findKthSmallest(int[] arr, int low, int high, int k) {
        int partition = partition(arr, low, high);

        if (k == partition)
            return arr[partition];
        else if (partition < k)
            return findKthSmallest(arr, partition + 1, high, k);
        else
            return findKthSmallest(arr, low, partition - 1, k);
    }

    /**
     * Here find the partition. It's similar to quick sort where we choose the last element of the partition as
     * pivot and then putt all elements less than the pivot to left side and all the elements greater to the right
     *
     * @param arr  - array to be processed
     * @param low  - Low index
     * @param high - High index
     * @return The partition value
     */
    public static int partition(int[] arr, int low, int high) {
        int pivotLoc = low;
        int pivot = arr[high];

        for (int i = low; i <= high; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, pivotLoc);
                pivotLoc++;
            }
        }

        swap(arr, high, pivotLoc);

        return pivotLoc;
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
