package Streams;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class StreamsPartTwo {
  public static void main(String[] args) {
    // Arrays of number-List of integers - Basic , Intermediate and advanced

    List<Integer> numList = Arrays.asList(12, 67, 86, 53, 11, 90, 82, 86, 25);
    int[] numArrays = new int[] {10, 24, 25, 21, 86, 95, 100};

    // even and odd from both list and array.
    // even number
    numList.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    stream(numArrays).filter(n -> n % 2 == 0).forEach(System.out::println);

    // odd number
    numList.stream().filter(n -> n % 2 != 0).forEach(System.out::println);
    stream(numArrays).filter(n -> n % 2 != 0).forEach(System.out::println);

    // get the even/odd number between a range(include both)
    IntStream.rangeClosed(10, 100).filter(n -> n % 2 == 0).forEach(System.out::println);
    IntStream.rangeClosed(10, 100).filter(n -> n % 2 != 0).forEach(System.out::println);

    // sort a list of integers in descending/ascending order
    // Ascending order
    numList.stream().sorted().forEach(System.out::println);
    stream(numArrays).sorted().forEach(System.out::println);

    // Descending order
    numList.stream()
        // .sorted((a, b) -> b - a)
        .sorted(Comparator.comparingInt(Integer::intValue).reversed())
        .forEach(System.out::println);

    stream(numArrays)
        .boxed()
        // .mapToObj(Integer::valueOf)
        .sorted((a, b) -> b - a)
        .forEach(System.out::println);

    // calculate the sum and average of numbers in an array/list of numbers
    int total =
        numList.stream()
            // .mapToInt(num->num.intValue())
            .mapToInt(Integer::intValue)
            .sum();
    System.out.println(total);

    Optional<Integer> optnum = numList.stream().reduce(Integer::sum);
    optnum.ifPresent(System.out::println);

    int arrTotal = Arrays.stream(numArrays).sum();
    System.out.println(arrTotal);

    // average
    OptionalDouble avg = numList.stream().mapToDouble(Integer::doubleValue).average();
    System.out.println(avg);

    OptionalDouble avgArr = Arrays.stream(numArrays).average();
    System.out.println(avgArr);

    // find the maximum and minimum number in a array/list of numbers
    int maxValue = numList.stream().max(Comparator.comparing(Integer::valueOf)).get();
    System.out.println(maxValue);

    OptionalInt maxArrValue = Arrays.stream(numArrays).max();
    System.out.println(maxArrValue);

    // intermediate
    // Remove duplicate elements from an array/list of Integers
    numList.stream().distinct().forEach(System.out::println);
    Arrays.stream(numArrays).distinct().forEach(System.out::println);

    // Convert a list/average of integers to a list of their squares and print them
    numList.stream().map(num -> num * num).forEach(System.out::println);

    Arrays.stream(numArrays).map(num -> num * num).forEach(System.out::println);
    // OR
    Arrays.stream(numArrays)
        .mapToDouble(num -> Math.pow(num, 2))
        .mapToInt(doubleValue -> (int) doubleValue)
        .forEach(System.out::println);

    // Find the sum of squares of all the numbers in the array/list
    int sumOfSquares = numList.stream().map(num -> num * num).reduce(0, (x, y) -> (x + y));
    System.out.println(sumOfSquares);
    // OR
    int sumOFSquares = numList.stream().mapToInt(num -> num * num).sum();
    System.out.println(sumOFSquares);

    double sum = Arrays.stream(numArrays).mapToDouble(num -> Math.pow(num, 2)).sum();
    System.out.println(sum);

    // get the second largest and second smallest number in an list/array
    int secondLargest = numList.stream().sorted((a, b) -> (b - a)).skip(1).findFirst().get();
    System.out.println(secondLargest);

    secondLargest =
        Arrays.stream(numArrays)
            .mapToObj(Integer::valueOf)
            .sorted((a, b) -> (b - a))
            .skip(1)
            .findFirst()
            .get();
    System.out.println(secondLargest);

    // Get the first number greater than 50 in a list/arrays
    numList.stream().filter(num -> num > 50).findFirst().get();
    Arrays.stream(numArrays).filter(num -> num > 50).findFirst().getAsInt();

    // HARD LEVEL
    // Get the sum of numbers of two dimensional array and list of list of integers
    List<List<Integer>> multiList =
        Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7, 4));
    multiList.stream().flatMap(list -> list.stream()).reduce((x, y) -> (x + y)).get();
    // OR
    int totalSum = multiList.stream().flatMap(Collection::stream).mapToInt(Integer::intValue).sum();
    System.out.println(totalSum);

    int[][] twoDim = new int[][] {{1, 2}, {3, 4}, {5, 6}};
    int twoDimSUM = Arrays.stream(twoDim).flatMapToInt(Arrays::stream).sum();
    System.out.println(twoDimSUM);

    // convert and array of integers into a map where the key is the  number and the value is square
    Map<Integer, Integer> mapNum =
        numList.stream().collect(Collectors.toMap(key -> key, value -> value * value));
    mapNum.forEach((key, value) -> System.out.println(key + " " + value));

    Arrays.stream(numArrays)
        .boxed()
        .collect(Collectors.toMap(key -> key, value -> value * value))
        .forEach((key, value) -> System.out.println(key + " " + value));

    // Partition an array of integers into two groups: even and odd using Streams
    Map<Boolean, List<Integer>> mapNums =
        numList.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
    System.out.println(mapNums.get(true)); // Even numbers
    System.out.println(mapNums.get(false)); // Odd numbers

    Arrays.stream(numArrays)
        .boxed()
        .collect(Collectors.partitioningBy(num -> num % 2 == 0))
        .forEach((key, value) -> System.out.println(key + " " + value));

    // Calculate the product of all numbers in the array using reduce
    int product = numList.stream().reduce(1, (x, y) -> x * y);
    System.out.println(product);

    product = Arrays.stream(numArrays).reduce((x, y) -> x * y).getAsInt();
    System.out.println(product);

    // Implement a parallel stream that computes sum of squares of numbers in an array/list
    int totalSumParallelStream =
        numList.parallelStream().map(num -> num * num).reduce(0, Integer::sum);
    System.out.println(totalSumParallelStream);

    totalSumParallelStream = Arrays.stream(numArrays).parallel().map(num -> num * num).sum();
    System.out.println(totalSumParallelStream);
  }
}
