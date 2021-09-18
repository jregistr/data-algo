package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
From leetcode: https://leetcode.com/problems/design-add-and-search-words-data-structure/

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 */
public class WordDictionary {

    public final TreeNode root = new TreeNode();

    public static class TreeNode {
        boolean end = false;
        TreeNode[] children = new TreeNode[26];
    }

    public void addWord(String toInsert) {
        if(toInsert.length() == 0) return;

        TreeNode current = root;
        for(char ch : toInsert.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index] == null) {
                current.children[index] = new TreeNode();
            }
            current = current.children[index];
        }
        current.end = true;
    }

    public boolean search(String toSearch) {
        return search(toSearch, 0, root);
    }

    private boolean search(String toSearch, int startI, TreeNode root) {
        TreeNode current = root;
        for(int i = startI; i < toSearch.length(); i ++) {
            char ch = toSearch.charAt(i);
            if(ch == '.') {
                List<TreeNode> children = Arrays
                        .stream(current.children)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());
                for (TreeNode child : children) {
                    if(search(toSearch, i + 1, child)) return true;
                }
                return false;
            } else {
                int chIndex = ch - 'a';
                TreeNode chNode = current.children[chIndex];
                if(chNode == null) return false;
                current = current.children[chIndex];
            }
        }
        return current.end;
    }
}
