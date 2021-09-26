package datastructures.types;

import datastructures.components.BTNode;
import datastructures.interfaces.Tree;

public class BinarySearchTree implements Tree {

    private BTNode root;

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public void insert(Integer data) {
        root = insertRec(root, data);
    }

    /**
     * Recursive function to insert a node in the Binary Search Tree
     *
     * @param node - Node to check if insert is possible
     * @param data - Data to save
     * @return The passed {@link BTNode} node
     */
    private BTNode insertRec(BTNode node, Integer data) {
        if (node == null) {
            node = new BTNode(data);
            return node;
        }

        if (data < node.data)
            node.left = insertRec(node.left, data);
        else if (data > node.data)
            node.right = insertRec(node.right, data);
        else
            node.count++;

        return node;
    }

    @Override
    public boolean search(Integer data) {
        return searchRec(root, data) != null;
    }

    private BTNode searchRec(BTNode node, Integer data) {
        if (node == null || node.data.equals(data)) return node;
        if (data > node.data) return searchRec(node.right, data);
        return searchRec(node.left, data);
    }

    @Override
    public void preOrderTraverse() {
        preOrderRec(root);
    }

    /**
     * Recursive function to print the Tree in pre-order
     *
     * @param node - The node to print and traverse;
     */
    private void preOrderRec(BTNode node) {
        if (node == null) return;

        System.out.println(node.data + " ");
        preOrderRec(node.left);
        preOrderRec(node.right);
    }

    @Override
    public void inOrderTraverse() {
        inOrderRec(root);
    }

    /**
     * Recursive function to print the Tree in in-order
     *
     * @param node - The node to print and traverse;
     */
    private void inOrderRec(BTNode node) {
        if (node == null) return;

        inOrderRec(node.left);
        System.out.println(node.data + " ");
        inOrderRec(node.right);
    }

    @Override
    public void postOrderTraverse() {
        postOrderRec(root);
    }

    /**
     * Recursive function to print the Tree in in-order
     *
     * @param node - The node to print and traverse;
     */
    private void postOrderRec(BTNode node) {
        if (node == null) return;

        postOrderRec(node.left);
        postOrderRec(node.right);
        System.out.println(node.data + " ");
    }

    @Override
    public int height() {
        return depth(root);
    }

    /**
     * Recursive function to go deep into a tree to calculate the height
     *
     * @param node - Node to traverse
     * @return The depth value
     */
    private int depth(BTNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    @Override
    public int size() {
        return sizeRec(root);
    }

    /**
     * Recursive function to calculate the size of the tree, i.e. the number
     * of nodes in it.
     *
     * @param node - Node to traverse
     * @return The size value
     */
    private int sizeRec(BTNode node) {
        if (node == null) return 0;
        return sizeRec(node.left) + sizeRec(node.right) + 1;
    }

    @Override
    public Integer deleteNode(Integer data) {
        return null;

    }
}
