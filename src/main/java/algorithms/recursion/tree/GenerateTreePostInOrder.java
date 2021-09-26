package algorithms.recursion.tree;

import datastructures.components.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Generate Binary tree from a given inorder and postorder traversal
 */
public class GenerateTreePostInOrder {

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});

        inorder(root);
        System.out.println();
        postorder(root);
    }

    /**
     * This function calls the construct function to build the tree.
     *
     * @param inorder   - In-order traversal of the Binary Tree
     * @param postorder - Post-order traversal of the Binary Tree
     * @return The root node of the binary tree
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();

        // Storing the indices of the values in in-order array
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        AtomicInteger pIndex = new AtomicInteger(postorder.length - 1);

        return construct(0, postorder.length - 1, postorder, pIndex, map);

    }

    /**
     * The logic here is to locate the last element of the postorder array. This element
     * is the root of the tree. Now we locate the index of this element in the inorder array.
     * All elements to the left belong to the left sub-tree and the right to tis element
     * belong to the right subtree. We recursively use this idea to build the entire binary tree
     *
     * @param start     - Start Index of post-order array.
     * @param end       - End index of post order array.
     * @param postorder - Post order array
     * @param pIndex    - Last processed index of post order array
     * @param map       - Map containing indices of the values in inorder array
     * @return The root node of the constructed array
     */
    public static TreeNode construct(int start,
                                     int end,
                                     int[] postorder,
                                     AtomicInteger pIndex,
                                     Map<Integer, Integer> map) {

        if (start > end) return null;

        // Consider the next item from the end of given postorder sequence
        // This value would be the root node of subtree formed by inorder[start, end]
        TreeNode root = new TreeNode(postorder[pIndex.getAndDecrement()]);

        // search the index of current node in inorder sequence to determine
        // the boundary of left and right subtree
        int index = map.get(root.val);

        // recursively construct the right  and left subtree
        root.right = construct(index + 1, end, postorder, pIndex, map);
        root.left = construct(start, index - 1, postorder, pIndex, map);

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
