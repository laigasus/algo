package day13;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetPrimeNumber {
    public static void main(String[] args) {
        System.out.println(getPrimeNumbers(3, 16));
    }

    public static List<Integer> getPrimeNumbers(int start, int end) {
        return IntStream.range(start, end).boxed()
                .filter(i -> IntStream.rangeClosed(2, (int) Math.sqrt(i))
                        .noneMatch(n -> (i % n == 0)))
                .collect(Collectors.toList());
    }
}
