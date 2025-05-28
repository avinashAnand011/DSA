package Streams;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsPartOne {

  // Part1- List of Strings- Basic.
  public static void main(String[] args) {

    List<String> fruits =
        Arrays.asList(
            "apple", "orange", "pineapple", "berry", "strawberry", "kiwi", "berry", "kiwi");

    List<String> sortedAndUpperCase = fruits.stream().map(String::toUpperCase).sorted().toList();
    System.out.println(sortedAndUpperCase);

    List<String> lengthMoreThanFive =
        fruits.stream().filter(str -> str.length() > 5).sorted().distinct().toList();
    System.out.println(lengthMoreThanFive);

    List<String> withASpecificWord = fruits.stream().filter(str -> str.contains("kiwi")).toList();
    System.out.println(withASpecificWord);

    List<String> withASpecificCharacter = fruits.stream().filter(str -> str.contains("s")).toList();
    System.out.println(withASpecificCharacter);

    List<String> removeWithSpecificWordStartingWith =
        fruits.stream().filter(str -> !str.startsWith("b")).toList();
    System.out.println(removeWithSpecificWordStartingWith);

    String firstWordWithCharacter =
        fruits.stream().filter(str -> str.startsWith("p")).findFirst().get();
    System.out.println(firstWordWithCharacter.toUpperCase());

    List<Integer> lengthOfEachString = fruits.stream().map(String::length).toList();
    System.out.println(lengthOfEachString);

    // Intermediate Questions;

    // List<String> sortStringBasedOnLength =
    //    fruits.stream().sorted((o1, o2) -> Integer.compare(o1.length(), o2.length())).toList();
    List<String> sortStringBasedOnLength =
        fruits.stream().sorted(Comparator.comparing(String::length).reversed()).toList();
    System.out.println(sortStringBasedOnLength);

    Optional<String> longestWord = fruits.stream().max(Comparator.comparing(String::length));
    System.out.println(longestWord);

    List<String> stringWithVowels =
        fruits.stream().filter(str -> str.matches(".*[aeiou.*]")).toList();
    System.out.println(stringWithVowels);

    List<String> separatedByComma = Collections.singletonList(String.join(",", fruits));
    System.out.println(separatedByComma);

    // Write a java program to create a new list of Strings, where each string is reversed from the
    // original list, using java Streams
    fruits.stream()
        .map(
            str ->
                new StringBuilder(str).reverse().toString()) // Convert StringBuilder back to String
        .forEach(System.out::println);

    // Write a java program to remove all strings from the list that are empty or null using
    // streams.
    fruits.stream().filter(str -> str != null && !str.isEmpty()).forEach(System.out::println);

    // Advanced questions;

    /*Given a list of STrings , group a list of strings by the first letter of each string using streams*/
    Map<Character, List<String>> mapWords =
        fruits.stream().collect(Collectors.groupingBy(str -> str.charAt(0)));
    mapWords.forEach(
        (key, value) -> {
          System.out.println(key + " " + value);

          // value.forEach(System.out::println);
        });

    // Given a list Of Strings by the length string
    fruits.stream()
        .collect(Collectors.groupingBy(String::length))
        .forEach((key, value) -> System.out.println(key + " " + value));

    // Given a list of Strings, create a map where the key is the last letter of the string, and
    // the value is list of strings that start with that letter using streams

    Map<Character, List<String>> lastCharacter =
        fruits.stream().collect(Collectors.groupingBy(str -> str.charAt(str.length() - 1)));
    lastCharacter.forEach((key, value) -> System.out.println(key + " " + value));

    // Given a list of String, group the list of strings with vowels and n0 vowels into two lists
    Map<Boolean, List<String>> mapWordsByVowel =
        fruits.stream().collect(Collectors.partitioningBy(str -> str.matches(".*[aeiou].*")));
    System.out.println("With Vowels" + mapWordsByVowel.get(true));
    System.out.println("Without Vowels" + mapWordsByVowel.get(false));
    mapWordsByVowel.forEach((key, value) -> System.out.println(key + " " + value));

    // Given a list of Strings print only the string elements excluding the digits using streamsy
    fruits.stream().filter(str -> !str.matches(".*[0-9].*")).forEach(System.out::println);

    // Given a list of strings find the firsts element having the length 10 if not handle exceptions
    String val =
        fruits.stream()
            .filter(str -> str.length() > 10)
            .findAny()
            .orElseThrow(() -> new NoSuchElementException("No value present"));
    System.out.println(val);

    // convert an array of strings into a list , reverse the list of string
    IntStream.range(0, fruits.size())
        .mapToObj(i -> fruits.get(fruits.size() - 1 - i))
        .forEach(System.out::println);
  }
}
