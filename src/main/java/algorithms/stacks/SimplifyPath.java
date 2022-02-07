package algorithms.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home//foo/"));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");

        for(String s : arr) {
            if(s.equals("") || s.equals(".")) continue;
            else if(!stack.isEmpty() && s.equals("..")) stack.pop();
            else if(stack.isEmpty() && s.equals("..")) continue;
            else stack.push(s);
        }

        if(stack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder("/");

        for(String s : stack)
            sb.append(s).append("/");

        return sb.substring(0, sb.length() - 1);
    }
}
