package algorithms.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 */
public class CheckIfNAndItsDoubleExist {

    public static void main(String[] args) {
        int[] arr = {0, 0};
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int res = binarySearch(arr, 2 * arr[i]);
            if (res != i && res != -1)
                return true;
        }
        return false;
    }

    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (target > arr[mid])
                l = mid + 1;
            else if (target < arr[mid])
                r = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
