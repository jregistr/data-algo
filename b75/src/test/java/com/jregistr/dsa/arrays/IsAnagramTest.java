package com.jregistr.dsa.arrays;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IsAnagramTest {

    @Test
    public void testItReturnsTrue() {
        var underTest = new IsAnagram();
        assertTrue(underTest.isAnagram("anagram", "nagaram"));
    }
}