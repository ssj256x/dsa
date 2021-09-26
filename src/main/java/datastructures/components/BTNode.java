package datastructures.components;

/**
 * Node for a Binary Tree
 */
public class BTNode {
    /**
     * The data to be stored in the node
     */
    public Integer data;
    /**
     * If there are duplicate elements then this variable stores the count
     */
    public Integer count;
    /**
     * The left {@link BTNode} pointer
     */
    public BTNode left;
    /**
     * The right {@link BTNode} pointer
     */
    public BTNode right;

    /**
     * Initialize node with data
     * @param data - The data to be stored
     */
    public BTNode(Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
