package datastructures.interfaces;

/**
 * Interface for a Tree.
 */
public interface Tree {

    /**
     * To insert a data in the tree.
     *
     * @param data - The data to be insert.
     */
    void insert(Integer data);

    /**
     * To search a tree for the given data.
     *
     * @param data - data to be searched.
     * @return true or false based on result.
     */
    boolean search(Integer data);

    /**
     * To print the tree after traversing in pre-order.
     */
    void preOrderTraverse();

    /**
     * To print the tree after traversing in in-order.
     */
    void inOrderTraverse();

    /**
     * To print the tree after traversing in pre-order.
     */
    void postOrderTraverse();

    /**
     * To get the height of the tree.
     *
     * @return The height of the tree.
     */
    int height();

    /**
     * To get the size of the tree
     *
     * @return The size of the tree
     */
    int size();

    /**
     * To delete a node from the tree.
     *
     * @param data - The data to be removed.
     * @return The deleted node data
     */
    Integer deleteNode(Integer data);
}
