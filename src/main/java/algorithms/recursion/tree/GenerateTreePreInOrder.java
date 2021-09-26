package algorithms.recursion.tree;

import datastructures.components.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class GenerateTreePreInOrder {

    public static void main(String[] args) {

        TreeNode root = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        inorder(root);
        System.out.println();
        postorder(root);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        // Storing the indices of the values in in-order array
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        int n = inorder.length - 1;

        return construct(0, n, preorder, n, map);
    }

    public static TreeNode construct(int start,
                              int end,
                              int[] preorder,
                              int pIndex,
                              Map<Integer, Integer> map) {

        if (start > end) return null;

        TreeNode root = new TreeNode(preorder[pIndex--]);
        int index = map.get(root.val);

        root.left = construct(start, index - 1, preorder, pIndex, map);
        root.right = construct(index + 1, end, preorder, pIndex, map);

        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void postorder(TreeNode root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }
}
