package com.global.commtech.test.anagramfinder.service;

import static java.util.Objects.nonNull;

import com.global.commtech.test.anagramfinder.repository.AnagramRepository;
import com.global.commtech.test.anagramfinder.util.Alphabet;
import java.util.HashSet;
import java.util.Map;
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
            final int wordSum = Alphabet.getAlphabeticalSum(word.toCharArray());
            final Map<Integer, Integer> wordData = Map.of(wordSum, word.length());
            final Set<String> words = anagramRepository.getAnagram(wordData);
            if (nonNull(words)) {
                final Set<String> newSet = new HashSet<>(words);
                newSet.add(word);
                anagramRepository.addAnagram(wordData, newSet);
            } else {
                anagramRepository.addAnagram(wordData, Set.of(word));
            }
        });
        publishAnagrams();
    }

    private void publishAnagrams() {
        final Stream<Set<String>> allAnagrams = anagramRepository.getAllAnagrams();
        allAnagrams.forEach(anagramGroup -> System.out.println(anagramGroup.stream().sorted().collect(Collectors.joining(","))));
    }
}
