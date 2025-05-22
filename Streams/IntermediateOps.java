package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOps {

    //Intermediate ops transform a stream into another Stream
    // They are lazy, meaning they don't execute until a terminal operation is invoked
    public static void main(String[] args) {

        //1.filter
        List<String> list = Arrays.asList("Akshti", "Ram", "Shyam", "Ganesh");
        list.stream().filter(x -> x.startsWith("A")).limit(10);

        //2.map
        list.stream().map(x -> x.toUpperCase());

        //3.sorted 
        list.stream().sorted();
        ///in natural order
        list.stream().sorted((a, b) -> a.length() - b.length());

        //4.distinct
        list.stream().filter(x -> x.startsWith("A")).distinct().count();

        //5.limit
        Stream.iterate(1, x -> x + 1).count();

        //6.skip
        Stream.iterate(1, x -> x + 1).skip(10).limit(100).count();

        //7. peek
        //performs an action on each element as it is consumed
        Stream.iterate(1, x -> x + 1).skip(10).limit(100).peek(System.out::println).count();

        //8. flatMap()
        //Handle streams of collections. lists  or arrays where each element is itself a collection
        //Flatten nested structures (e.g lists within lists) so that they can be processed as a single sequence of elements
        //Transform and flat
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );

        listOfLists.get(1).get(1);
        listOfLists.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList();

        List<String> sentences = Arrays.asList(
                "hello world",
                "Java streams are pwoerful",
                "flatMap is useful"
        );

        sentences.stream()
                .flatMap(x -> Arrays.stream(x.split(" ")))
                .map(String::toUpperCase)
                .toList();

    }

}
