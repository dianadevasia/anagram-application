package com.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Checker;
import com.service.AnagramService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AnagramTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnagramService service;

    @Test
    public void shouldReturnPayloadTrueWhenStringsAreAnagram() throws Exception {
        final Checker checker = new Checker(true);
        final ObjectMapper objectMapper = new ObjectMapper();
        final String expectedResponse = objectMapper.writeValueAsString(checker);

        when(service.checkIfStringsAreAnagrams("abcd", "dcba")).thenReturn(checker);

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/anagrams/abcd/dcba"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }
}
