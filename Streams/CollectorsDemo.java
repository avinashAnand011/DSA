package Streams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String[] args) {
        //Collectors is a utility class
        //provides a set of methods to create common collectors

        List<String> names = Arrays.asList("alice", "bob", "charlie");
        List<String> a = names.stream().
                filter(name -> name.startsWith("A")).collect(Collectors.toList());

        //collecting to a specific collection
        ArrayDeque<String> collect = names.stream()
                .collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        //joining Strings
        names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));

        //summarizing data
        //Generates statistical summary (count, sum, min, average,max)
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 7);
        IntSummaryStatistics stats = numbers.stream()
                .collect(Collectors.summarizingInt(x -> x));

        //calculating averages
        Double average = numbers.stream().collect(Collectors.averagingInt(x -> x));

        //Counting Elements
        Long collect1 = numbers.stream().collect(Collectors.counting());

        //Grouping elements
        List<String> words = Arrays.asList("hello", "world", "java", "streams", "collecting");
        words.stream().collect(Collectors.groupingBy(x -> x.length()));
        words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));

        //9. Partitioning elements
        //Partition elements into two groups (true and false) based on a predicate
        words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5));

        //10. Mapping and Collecting
        //Applies a mapppping function before collecting
        words.stream().collect(Collectors.mapping(x -> x.toString().toUpperCase(), Collectors.toList()));

        //Example 1: Collecting Names by Length
        List<String> l1 = Arrays.asList("Anna", "Bob", "Alexander", "Brian", "Alice");
        l1.stream().collect(Collectors.groupingBy(String::length));

        //Example 2 : Counting word occurences
        String sentence = "hello world hello java world!";
        Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        //Example 3: Partitioning Even and Odd numbers
        List<Integer> l2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        l2.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));

        //Example 4 : Summing values in a map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("banana", 20);
        items.put("Orange", 15);
        items.values().stream().reduce(Integer::sum);
        items.values().stream().collect(Collectors.summingInt(x -> x));

        //Exmaple 5: Creating a map from Stream Elements
        List<String> fruits = Arrays.asList("Apple","Banana","Cherry");
        fruits.stream().collect(Collectors.toMap(x->x.toUpperCase(),x->x.length()));


        //Example 6: count the no. of repetetive words
        List<String> words2 = Arrays.asList("apple","banana","apple","orange","banana","apple");
        words.stream().collect(Collectors.toMap(k->k,v->1,(x,y)->x+y));
    }

}
