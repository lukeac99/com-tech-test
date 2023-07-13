package com.global.commtech.test.anagramfinder.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.global.commtech.test.anagramfinder.repository.AnagramRepository;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AnagramServiceTest {

    @Mock
    AnagramRepository anagramRepository;

    @InjectMocks
    AnagramService anagramService;

    @Test
    void sortIntoAnagrams() {
        final Set<String> words = Set.of("hello", "ohlle", "lleho", "apple", "alppe");
        when(anagramRepository.getAnagram("ehllo"))
            .thenReturn(Set.of("hello"))
            .thenReturn(Set.of("hello, ohlle"))
            .thenReturn(Set.of("hello, ohlle, lleho"));
        when(anagramRepository.getAnagram("aelpp"))
            .thenReturn(Set.of("apple"))
            .thenReturn(Set.of("apple, allpe"));
        doReturn(Stream.of(words)).when(anagramRepository).getAllAnagrams();
        anagramService.sortIntoAnagrams(words.stream());
        verify(anagramRepository, times(5)).addAnagram(any(), any());
    }
}