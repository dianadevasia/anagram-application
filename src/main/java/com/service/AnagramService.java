package com.service;

import com.model.AnagramsList;
import com.model.Checker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public AnagramsList getAllAnagrams(String anagramString) {
        List<String> anagramList = new ArrayList<>();
        permutations(anagramString, 0, anagramString.length()-1, anagramList);
        return new AnagramsList(anagramList);
    }

    private void permutations(String stringToPermute, int start, int end, List<String> anagramList) {
        if (start == end)
            anagramList.add(stringToPermute);
        else
        {
            for (int counter = start; counter <= end; counter++)
            {
                stringToPermute = swap(stringToPermute, start, counter);
                permutations(stringToPermute, start+1, end, anagramList);
                stringToPermute = swap(stringToPermute, start, counter);
            }
        }
    }

    private String swap(String stringToSwap, int i, int j)
    {
        char temp;
        char[] charArray = stringToSwap.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
