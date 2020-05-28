package com.service;

import com.model.AnagramsList;
import com.model.Checker;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

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

        assertFalse(checker.isAreAnagrams());
    }

    @Test
    public void returnFalseIfBothStringsAreNotSame() {
        String firstString = "anagraaa";
        String secondString = "anagrams";
        final Checker checker = anagramService.checkIfStringsAreAnagrams(firstString, secondString);

        assertFalse(checker.isAreAnagrams());
    }

    @Test
    public void returnTrueIfBothStringsAreSame() {
        String firstString = "smargnaa";
        String secondString = "anagrams";
        final Checker checker = anagramService.checkIfStringsAreAnagrams(firstString, secondString);
        assertTrue(checker.isAreAnagrams());
    }

    @Test
    public void returnListOfAnagramsForAValidString() {
        final ArrayList<String> list = new ArrayList<>();
        list.add("ab"); list.add("ba");
        final AnagramsList expectedAnagramsList = new AnagramsList(list);
        String firstString = "ab";

        final AnagramsList actualAnagrams = anagramService.getAllAnagrams(firstString);

        assertEquals(expectedAnagramsList, actualAnagrams);
    }
}