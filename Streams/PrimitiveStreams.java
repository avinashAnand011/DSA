package Streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        int [] numbers={1,2,3,4};
        IntStream stream = Arrays.stream(numbers);
    }
}
