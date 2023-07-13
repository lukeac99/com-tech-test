package com.global.commtech.test.anagramfinder.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramRepositoryTest {

    private final AnagramRepository anagramRepository = new AnagramRepository();

    private Set<String> words1;
    private Set<String> words2;
    private Set<String> words3;

    private static final String key1 = "hello";
    private static final String key2 = "apple";
    private static final String key3 = "test";

    @BeforeEach
    void beforeEach() {
        words1 = Set.of("hello", "elolh");
        words2 = Set.of("apple", "elpap", "paple");
        words3 = Set.of("test");
        anagramRepository.addAnagram(key1, words1);
        anagramRepository.addAnagram(key2, words2);
        anagramRepository.addAnagram(key3, words3);
    }

    @Test
    void getAnagram() {
        assertThat(anagramRepository.getAnagram(key1)).isEqualTo(words1);
        assertThat(anagramRepository.getAnagram(key2)).isEqualTo(words2);
        assertThat(anagramRepository.getAnagram(key3)).isEqualTo(words3);
    }

    @Test
    void getAllAnagrams() {
        assertThat(anagramRepository.getAllAnagrams()).contains(words1, words2, words3);
    }
}