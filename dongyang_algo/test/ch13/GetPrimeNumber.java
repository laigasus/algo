package test.ch13;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class GetPrimeNumber {
    public static void main(String[] args) {
        int start = 3, end = 16;
        IntStream.rangeClosed(start, end).boxed().filter(i -> BigInteger.valueOf(i).isProbablePrime(10)).toList()
                .forEach(System.out::println);
    }
}
