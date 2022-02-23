package algorithms.arrays.twopointers;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 * https://leetcode.com/problems/happy-number/solution/
 */
public class HappyNumber {

    public static void main(String[] args) {

    }

    public boolean isHappyUsingSet(int n) {
        Set<Integer> set = new HashSet<>();

        while(n != 1 && !set.contains(n)) {
            set.add(n);
            n = sumOfDigits(n);
        }

        return n == 1;
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfDigits(n);

        while(fast != 1 && fast != slow) {
            slow = sumOfDigits(slow);
            fast = sumOfDigits(sumOfDigits(fast));
        }

        return fast == 1;
    }

    public static int sumOfDigits(int n) {
        int sum = 0;
        while(n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
}
