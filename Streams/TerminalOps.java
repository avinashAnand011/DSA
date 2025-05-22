package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 3, 4, 5, 6, 6);

        //1. collect
        list.stream().skip(1).collect(Collectors.toList());

        //2. forEach
        list.stream().forEach(x -> System.out.println(x));

        //3. reduce: Combines elements to produce a single result
        Optional<Integer> optionalInteger = list.stream().reduce((x, y) -> x + y);
        System.out.println(optionalInteger.get());

        //5. anyMatch , allMatch , noneMatch
        Boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);
        list.stream().allMatch(x -> x > 0);
        list.stream().noneMatch(x -> x < 0);

        //6. findfirst , findAny
        list.stream().findFirst().get();
        list.stream().findAny().get();

        //7.toArray

        Object[] array = Stream.of(1,2,3).toArray();

        //8. min/max
        Stream.of(2,44,69).max(Comparator.naturalOrder());

        //9. forEachOrdered
        List<Integer> numbers1  = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println("Using forEach with parallel stream");
        numbers1.parallelStream().forEach(System.out::println);
        System.out.println("Using forEachOrdered with parallel stream:");
        numbers1.parallelStream().forEachOrdered(System.out::println);

        //Exmaples - to get the string length great then 3
        List<String> nameList = Arrays.asList("Avinash", "Anand", "Harsh", "kumar");
        List<String> filteredList = nameList.stream().filter(x -> x.length() > 3).collect(Collectors.toList());

        //Example:  Squaring and Sorting numbers
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 55, 5);
        numbers.stream().map(x -> x * x).sorted().toList();

        //Example : Summing values
        List<Integer> integers = Arrays.asList(1, 2, 3, 44, 5, 2, 66);
        integers.stream().reduce(Integer::sum).get();

        //Example: to count the occurence of a alphabet lets say 'l'
        String sentence = "Hello World!";
        sentence.chars().filter(x -> x == 'l').count();

        //Example
        //Stream cannot be reused after a terminal operation has been called 
        Stream<String> stream = nameList.stream();
        stream.forEach(System.out::println);
        List<String> list3 = stream.map(String::toUpperCase).toList();

    }
}
