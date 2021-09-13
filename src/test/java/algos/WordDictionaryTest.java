package algos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static algos.WordDictionary.TreeNode;

public class WordDictionaryTest {

    WordDictionary dictionary;

    @BeforeEach
    void setUp() {
        dictionary = new WordDictionary();
    }

    @Test
    void testLeetCodeExample() {
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");

        assertFalse(dictionary.search("pad"));
        assertTrue(dictionary.search("bad"));
        assertTrue(dictionary.search(".ad"));
        assertTrue(dictionary.search("b.."));
    }

    @Test
    void testOneLetter() {
         /*
    ["WordDictionary","addWord","addWord","search","search","search","search","search","search"]
    [[],              ["a"],     ["a"],    ["."],   ["a"],   ["aa"],  ["a"],   [".a"],  ["a."]]
     */
        dictionary.addWord("a");
        dictionary.addWord("a");
        assertTrue(dictionary.search("."));
        assertTrue(dictionary.search("a"));
        assertFalse(dictionary.search("aa"));
        assertTrue(dictionary.search("a"));
        assertFalse(dictionary.search(".a"));
        assertFalse(dictionary.search("a."));
    }

    @Test
    void testCorner1() {
        /*
        ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        [[],              ["bad"],  ["dad"],  ["mad"],  ["pad"], ["bad"], [".ad"], ["b.."]]
         */
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        assertFalse(dictionary.search("pad"));
        assertTrue(dictionary.search("bad"));
        assertTrue(dictionary.search(".ad"));
        assertTrue(dictionary.search("b."));
    }
}
