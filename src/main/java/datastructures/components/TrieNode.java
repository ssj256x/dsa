package datastructures.components;

import java.util.Arrays;

public class TrieNode {
    public boolean isWordEnd;
    public TrieNode[] children;

    public TrieNode() {
        isWordEnd = false;
        children = new TrieNode[26];
        Arrays.fill(children, null);
    }
}