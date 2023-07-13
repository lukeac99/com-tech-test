package com.global.commtech.test.anagramfinder.repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AnagramRepository {

    private final Map<String, Set<String>> anagrams = new HashMap<>();

    public Set<String> getAnagram(String key) {
        return anagrams.get(key);
    }

    public void addAnagram(String key, Set<String> words) {
        anagrams.put(key, words);
    }

    public Stream<Set<String>> getAllAnagrams() {
        return anagrams.values().stream();
    }
}
