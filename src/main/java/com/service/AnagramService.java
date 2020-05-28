package com.service;

import com.model.Checker;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AnagramService {

    public Checker checkIfStringsAreAnagrams(final String firstString, final String secondString){
        if(firstString.length() != secondString.length())
            return new Checker(false);

        final char[] firstStringArray = firstString.toCharArray();
        Arrays.sort(firstStringArray);
        final char[] secondStringArray = secondString.toCharArray();
        Arrays.sort(secondStringArray);

        for (int i = 0; i < firstStringArray.length; i++) {
            if (firstStringArray[i] != secondStringArray[i])
                return new Checker(false);
        }
        return new Checker(true);
    }
}
