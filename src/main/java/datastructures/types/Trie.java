package datastructures.types;

import datastructures.components.TrieNode;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Basic implementation of a Trie
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        String sentence = "this is the best trie thing ever";

        for (String str : sentence.split(" ")) trie.insert(str);

        System.out.println(trie.autocomplete("b"));
    }

    public final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word in the trie
     *
     * @param word - Word to be inserted
     * @return Root of the trie
     */
    public TrieNode insert(String word) {
        int len = word.length();
        TrieNode pCrawl = root;
        int idx;

        for (int i = 0; i < len; i++) {
            idx = word.charAt(i) - 'a';
            if (pCrawl.children[idx] == null)
                pCrawl.children[idx] = new TrieNode();

            pCrawl = pCrawl.children[idx];
        }
        pCrawl.isWordEnd = true;

        return root;
    }

    /**
     * Inserts a list of Strings into the trie
     *
     * @param list - List of words to be inserted
     * @return Root of the trie
     */
    public TrieNode insert(String[] list) {
        for (String str : list) insert(str);
        return root;
    }

    /**
     * Searches a word in the trie
     *
     * @param word - Word to be searched
     * @return true or false based on search
     */
    public boolean search(String word) {
        int len = word.length();
        TrieNode pCrawl = root;
        int idx;

        for (int i = 0; i < len; i++) {
            idx = word.charAt(i) - 'a';
            if (pCrawl.children[idx] == null) return false;
            pCrawl = pCrawl.children[idx];
        }

        return pCrawl != null && pCrawl.isWordEnd;
    }

    /**
     * Searches and returns a {@link TrieNode} if found
     *
     * @param word - Word to be searched
     * @return Found TrieNode
     */
    public TrieNode searchNode(String word) {
        int len = word.length();
        int idx;
        TrieNode pCrawl = root;

        for (int i = 0; i < len; i++) {
            idx = word.charAt(i) - 'a';
            if (pCrawl.children[idx] == null)
                throw new NoSuchElementException("Prefix doesn't exist");

            pCrawl = pCrawl.children[idx];
        }
        return pCrawl;
    }

    /**
     * Counts the number of children present in the passed node
     *
     * @param node - The node whose children is to be found
     * @return number of children
     */
    public int countChildren(TrieNode node) {
        int len = 0;

        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) len++;
        }

        return len;
    }

    /**
     * Wrapper function to call DFS on Trie
     *
     * @param prefix - Prefix for which the list of matching words are to be fetched
     * @return List of words with matched prefix
     */
    public List<String> autocomplete(String prefix) {
        List<String> searchResult = new ArrayList<>();
        autocomplete(searchNode(prefix), new StringBuilder(), searchResult, prefix);
        return searchResult;
    }

    /**
     * This function uses DFS and backtracking to find all words with matching prefix
     *
     * @param prefixNode - The prefix node to start search from
     * @param sb         - The string being built
     * @param list       - List of words to be generated
     * @param prefix     - The prefix to be searched
     */
    private void autocomplete(TrieNode prefixNode, StringBuilder sb, List<String> list, String prefix) {
        // Base case in case a word is found and added to solution set
        if (prefixNode.isWordEnd) {
            list.add(prefix.concat(sb.toString()));
            return;
        }

        for (int i = 0; i < prefixNode.children.length; i++) {
            if (prefixNode.children[i] != null) {
                sb.append((char) (i + 'a')); // Choose
                autocomplete(prefixNode.children[i], sb, list, prefix); // Explore
                sb.deleteCharAt(sb.length() - 1); // Un-choose / Backtrack
            }
        }
    }
}
