package com.controller;

import com.model.Checker;
import com.service.AnagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Validated
public class AnagramResource {

    @Autowired
    AnagramService anagramService;

    @GetMapping("/anagrams/{string1}/{string2}")
    public ResponseEntity<Checker> checkAnagrams(@PathVariable(value = "string1") String string1, @PathVariable(value = "string2") String string2) {
        final Checker anagramChecker = anagramService.checkIfStringsAreAnagrams(string1, string2);
        return ResponseEntity.ok().body(anagramChecker);
    }
}
