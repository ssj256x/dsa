package algorithms.trie;

import datastructures.components.TrieNode;
import datastructures.types.Trie;

public class LongestCommonPrefix {

    int index;

    public static void main(String[] args) {

        String[] arr = {"geeksforgeeks", "geeks", "geeksforcse"};

        LongestCommonPrefix obj = new LongestCommonPrefix();
        System.out.println(obj.longestCommonPrefixTrie(arr));
    }

    /**
     * This is the simplest implementation of LCP using trie. The idea here is that if a node has
     * single child we add it to the common prefix and find repeat the same for all children. The moment
     * we find a node with more than one children that means that we have found our longest common prefix yet
     * <p>
     * NOTE : this implementation works only if all the words start from the same letter
     *
     * @param arr - Array of Strings
     * @return The LCP
     */
    public String longestCommonPrefixTrie(String[] arr) {
        index = 0;
        StringBuilder prefix = new StringBuilder();
        Trie trie = new Trie();
        for (String str : arr) trie.insert(str);

        TrieNode temp = trie.root;

        while (countChildren(temp) == 1 && !temp.isWordEnd) {
            temp = temp.children[index];
            prefix.append((char) (index + 'a'));
        }

        return prefix.toString();
    }

    /**
     * We count the number of children a node has. And we then keep track of the index where we found the
     * child. This index is used later to walk the trie
     *
     * @param node - The node whose children is to be found
     * @return the number of children
     */
    public int countChildren(TrieNode node) {
        int len = 0;

        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                len++;
                index = i;
            }
        }

        return len;
    }
}
