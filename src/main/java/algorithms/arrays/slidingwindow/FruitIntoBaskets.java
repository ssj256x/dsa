package algorithms.arrays.slidingwindow;

/**
 * https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitIntoBaskets {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2};
        System.out.println(totalFruit(arr));
    }

    /**
     * The problem basically breaks down to the finding the longest continuous sub-array with 2 distinct numbers.
     * <p>
     * Everytime we encounter a new fruit we add it to the lookup and increment its frequency. We also keep track on the
     * number of fruits if the number is being added to the basket for the first time.
     * Then we check that if the number of fruits > 2 then we remove the fruit  (shrink the window from right) and also
     * check if on removing the number the count becomes zero, ten we decrease the number of fruits. Now we calculate
     * the max size of the window
     *
     * @param fruits - The fruits array
     * @return The number of fruits that can be collected
     */
    public static int totalFruit(int[] fruits) {
        int noOfFruits = 0;
        int max = 0;
        int[] lookup = new int[100001];
        int start = 0;

        for (int end = 0; end < fruits.length; end++) {
            if (lookup[fruits[end]]++ == 0)
                noOfFruits++;

            while (noOfFruits > 2 && start < fruits.length) {
                if (--lookup[fruits[start++]] == 0)
                    noOfFruits--;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
