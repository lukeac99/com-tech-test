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

For this task I decided that each word would need a unique identifier which was independant of the ordering of the letters within this word.
This was done by creating an enum which included each letter in the alphabet, and creating a method which would return the value of each letter(s) position within the alphabet summed.
For example: "dog" -> d=4 , o=15, g=7. Therefore 'dog' = 36. This however doesn't provide the uniqueness I required as other words could reach this combination. However other words with the same number of letters could not.
