package algorithms.stacks;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 */
public class MinimumAddToMakeParenthesesValid {

    public static void main(String[] args) {

    }

    /**
     * Here we use the concept of balancing out brackets. If the number of '(' == number of ')' then the balance should
     * be zero. To implement this, everytime we get a '(' we add 1 to balance and subtract 1 when we get a ')'. There
     * could be a state when the number of ')' > number of '('. In that case we increment the balance by 1, back to 0,
     * and instead keep another variable to keep track of these extra closing brackets.
     *
     * @param s - The String to be parsed
     * @return Minimum add to make valid
     */
    public int minAddToMakeValid(String s) {
        int bal = 0;
        int ans = 0;

        for (char c : s.toCharArray()) {
            bal += c == '(' ? 1 : -1;
            if (bal == -1) {
                ans++;
                bal++;
            }
        }
        return ans + bal;
    }
}
