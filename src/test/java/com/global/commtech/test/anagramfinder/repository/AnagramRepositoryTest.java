//package com.global.commtech.test.anagramfinder.repository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.Map;
//import java.util.Set;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class AnagramRepositoryTest {
//
//    private final AnagramRepository anagramRepository = new AnagramRepository();
//
//    private Set<String> words1;
//    private Set<String> words2;
//    private Set<String> words3;
//
//    private Map<Integer, Integer> map1;
//    private Map<Integer, Integer> map2;
//    private Map<Integer, Integer> map3;
//
//    @BeforeEach
//    void beforeEach() {
//        words1 = Set.of("hello", "elolh");
//        words2 = Set.of("apple", "elpap", "paple");
//        words3 = Set.of("test");
//        map1 = Map.of(1, 4);
//        map2 = Map.of(4, 4);
//        map3 = Map.of(6, 4);
//        anagramRepository.addAnagram(map1, words1);
//        anagramRepository.addAnagram(map2, words2);
//        anagramRepository.addAnagram(map3, words3);
//    }
//
//    @Test
//    void getAnagram() {
//        assertThat(anagramRepository.getAnagram(map1)).isEqualTo(words1);
//        assertThat(anagramRepository.getAnagram(map2)).isEqualTo(words2);
//        assertThat(anagramRepository.getAnagram(map3)).isEqualTo(words3);
//    }
//
//    @Test
//    void getAllAnagrams() {
//        assertThat(anagramRepository.getAllAnagrams()).contains(words1, words2, words3);
//    }
//}