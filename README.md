# Anagram Finder
A simple command line utility for finding anagrams in a specified file

## Software required to run this
* Java 17

## Building and Running the tests
```
./gradlew clean build
```

## Running the program
```
./gradlew bootRun --args="example2.txt" 
```
where example2.txt is the text file that we want to search for anagrams

## Assumptions made

It was assumed after examining the test files that all words inputted would be in lower case.

## Description of Solution

For this task I decided that each word would need a unique identifier which was independent of the ordering of the letters within this word.
This was done by first sorting the individual letters of each word into alphabetical order by converting each word into a charArray. This would create a unique key that any combination of the same letters will match.
This Key was used in a Map with a set of Strings (each word). A Set was used to avoid duplicates. The repository was checked to see if this key exists. If it does then the word was added to the set stored for that key. If not then a new key and set of words was created.
