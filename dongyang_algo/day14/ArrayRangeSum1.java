package day14;

import java.util.stream.IntStream;

public class ArrayRangeSum1 {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 5).boxed().mapToInt(i -> i * 10).sum();
        System.out.println(sum);
    }
}
