package algorithms.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/submissions/
 */
public class VerifyPreorderSerializationOfBinaryTree {

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    /**
     * Here we try to match out groups of leaf nodes with its root. If the stack becomes empty or in the end if the stack
     * has more than one element which is not a null value, we have an imperfect serialisation.
     *
     * @param preorder - The preorder traversal string
     * @return If the traversal is valid
     */
    public static boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] arr = preorder.split(",");

        for (String s : arr) {
            while (!stack.isEmpty() && stack.peek().equals("#") && s.equals("#")) {
                stack.pop();
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(s);
        }

        return stack.size() == 1 && stack.pop().equals("#");
    }
}
