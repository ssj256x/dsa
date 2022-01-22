package algorithms.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/crawler-log-folder
 */
public class CrawlerLogFolder {

    public static void main(String[] args) {
        String[] str = {"./", "../", "./"};
        System.out.println(minOperations(str));
    }

    public static int minOperations(String[] logs) {
        String BACK = "../";
        String SAME = "./";
        Stack<String> stack = new Stack<>();

        for (String s : logs) {
            if (stack.isEmpty() && s.equals(BACK)) continue;
            if (s.equals(SAME)) continue;

            if (s.equals(BACK)) stack.pop();
            else stack.push(s);
        }

        return stack.size();
    }
}
