//package com.global.commtech.test.anagramfinder.service;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import com.global.commtech.test.anagramfinder.repository.AnagramRepository;
//import java.util.Map;
//import java.util.Set;
//import java.util.stream.Stream;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//class AnagramServiceTest {
//
//    @Mock
//    AnagramRepository anagramRepository;
//
//    @InjectMocks
//    AnagramService anagramService;
//
//    @Test
//    void sortIntoAnagrams() {
//        final Set<String> results = Set.of("hello", "ohlle", "lleho");
//        when(anagramRepository.getAnagram(Map.of(532, 5)))
//            .thenReturn(Set.of("hello"))
//            .thenReturn(Set.of("hello, ohlle"))
//            .thenReturn(Set.of("hello, ohlle, lleho"));
//        doReturn(Stream.of(results)).when(anagramRepository).getAllAnagrams();
//        anagramService.sortIntoAnagrams(results.stream());
//        verify(anagramRepository, times(3)).addAnagram(any(), any());
//    }
//}