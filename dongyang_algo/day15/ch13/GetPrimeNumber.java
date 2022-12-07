package day15.ch13;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetPrimeNumber {
    public static void main(String[] args) {
        int start = 3, end = 16;
        List<Integer> arr = IntStream.rangeClosed(start, end).boxed()
                .filter(i -> BigInteger.valueOf(i).isProbablePrime(10)).collect(Collectors.toList());
        System.out.println(arr);
    }
}
