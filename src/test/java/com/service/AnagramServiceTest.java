package com.service;

import com.model.Checker;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramServiceTest {

    private AnagramService anagramService;

    @Before
    public void setUp() {
        anagramService = new AnagramService();
    }

    @Test
    public void returnFalseIfBothStringLengthAreNotSame() {
        String firstString = "anagram";
        String secondString = "anagrams";
        final Checker checker = anagramService.checkIfStringsAreAnagrams(firstString, secondString);

        assertFalse(checker.areAnagrams);
    }

    @Test
    public void returnFalseIfBothStringsAreNotSame() {
        String firstString = "anagraaa";
        String secondString = "anagrams";
        final Checker checker = anagramService.checkIfStringsAreAnagrams(firstString, secondString);

        assertFalse(checker.areAnagrams);
    }

    @Test
    public void returnTrueIfBothStringsAreSame() {
        String firstString = "smargnaa";
        String secondString = "anagrams";
        final Checker checker = anagramService.checkIfStringsAreAnagrams(firstString, secondString);
        assertTrue(checker.areAnagrams);
    }

}