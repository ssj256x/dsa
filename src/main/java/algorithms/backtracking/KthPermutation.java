package algorithms.backtracking;

public class KthPermutation {

    String ans;

    public static void main(String[] args) {
        KthPermutation obj = new KthPermutation();
        System.out.println(obj.getPermutation(4, 9));
    }

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(i);

        kThPermutation(sb.toString().toCharArray(), 0, n, k, 0);

        return ans;
    }

    public void kThPermutation(char[] str, int start, int end, int k, int cur) {

        if (cur == k) {
            ans = new String(str);
            return;
        }

        for (int i = start; i < end; i++) {
            swap(str, start, i);
            cur++;
            kThPermutation(str, start + 1, end, k, cur);
            swap(str, start, i);
            cur++;
        }
    }

    /**
     * Function to swap two numbers in a given list
     *
     * @param arr - Array of numbers
     * @param i   - Index of number 1
     * @param j   - Index of number 2
     */
    public void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
