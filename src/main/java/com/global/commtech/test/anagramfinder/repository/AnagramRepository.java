package com.global.commtech.test.anagramfinder.repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AnagramRepository {

    private final Map<Map<Integer, Integer>, Set<String>> anagrams = new HashMap<>();

    public Set<String> getAnagram(final Map<Integer, Integer> wordData) {
        return anagrams.get(wordData);
    }

    public void addAnagram(final Map<Integer, Integer> wordData, Set<String> words) {
        anagrams.put(wordData, words);
    }

    public Stream<Set<String>> getAllAnagrams() {
        return anagrams.values().stream();
    }
}
