package com.global.commtech.test.anagramfinder.service;

import static java.util.Objects.nonNull;

import com.global.commtech.test.anagramfinder.repository.AnagramRepository;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnagramService {

    private final AnagramRepository anagramRepository;

    public void sortIntoAnagrams(final Stream<String> lines) {
        lines.forEach(word -> {
            final char[] chars = word.toCharArray();
            Arrays.sort(chars);
            final String key = String.valueOf(chars);
            final Set<String> words = anagramRepository.getAnagram(key);
            if (words != null) {
                final Set<String> newSet = new HashSet<>(words);
                newSet.add(word);
                anagramRepository.addAnagram(key, newSet);
            } else {
                anagramRepository.addAnagram(key, Set.of(word));
            }
        });
        publishAnagrams();
    }

    private void publishAnagrams() {
        final Stream<Set<String>> allAnagrams = anagramRepository.getAllAnagrams();
        allAnagrams.forEach(anagramGroup -> System.out.println(anagramGroup.stream().sorted().collect(Collectors.joining(","))));
    }
}
