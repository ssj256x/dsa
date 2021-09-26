package algorithms.recursion.tree;

import datastructures.components.TreeNode;

public class MaxSumPath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxSumPath sumPath = new MaxSumPath();
        System.out.println(sumPath.maxPathSum(root));
    }

    /*
    Idea: To find max Path sum

    -> 3 cases possible for a node - do a post order traversal for datas

    case 1:  its part of a chain (max path = c-b-a) node's left or right is chosen
             in max path but not both (notice x not part of max path chain, a is a part of max chain ) - pass max sum to parent
			 since its not the end of chain

                    c
                   /
                  b - node is a part of the max path
                 / \
                a   x

    case 2: its the parent of the chain (both the paths are chosen) - no need to pass to parent since its an inflection point
            when (max path = a-b-x)

                    c
                   /
                  b - node is a parent of the max path (left & right paths of parent are chosen)
                 / \
                a   x

    case 3: node is not part of max chain (max path = c-b-a) - no pass required since its not part of max path

                    c
                   /
                  b
                 / \
                a   x - node is a parent of the max path (left & right paths of parent are chosen)

    -> update max path at each node exploration

    */

    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        if (root == null) {
            result = 0;
        }

        findMaxPathSum(root);
        return result;
    }

    public int findMaxPathSum(TreeNode root) {

        // leaf nodes left & right childs gives sum 0
        if (root == null) {
            return 0;
        }

        int rootVal = root.val;
        int left = findMaxPathSum(root.left);
        int right = findMaxPathSum(root.right);

        // case 1 - part of chain hence need to be passed above (either of chain left or right + root val (or) root val if left & right both are -ve nos)
        int straightPath = Math.max(Math.max(left, right) + rootVal, rootVal);

        // case 2 - (choosing both left & right chain + root.val)
        int rootPath = Math.max(right + left + rootVal, rootVal);

        // update each stage the max result of case 1 & 2  (if node not part of max chain it will be less than result)
        result = Math.max(Math.max(straightPath, rootPath), result);

        return straightPath;
    }
}
